import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { Product } from 'src/app/demo/api/product';
import { ProductService } from 'src/app/demo/service/product.service';
import { Bureau } from 'src/app/demo/model/bureau';
import { SuiviBudget } from 'src/app/demo/model/suiviBudget';
import { DemandebureauDrpService } from 'src/app/layout/service/demandebureau-drp.service';

@Component({
  selector: 'app-demande-budget-drp',
  templateUrl: './demande-budget-drp.component.html',
  styleUrls: ['./demande-budget-drp.component.scss'],
  providers:[MessageService]
})
export class DemandeBudgetDrpComponent implements OnInit {
  productDialog: boolean = false;
  detailundrpDialog:boolean= false;
  detailBureauDialog:boolean=false;

  deleteProductDialog: boolean = false;

  deleteProductsDialog: boolean = false;

  products: Product[] = [];

  product: Product = {};

  selectedProducts: Product[] = [];

  submitted: boolean = false;

  cols: any[] = [];

  statuses: any[] = [];

  rowsPerPageOptions = [5, 10, 20];
  listdrp: SuiviBudget[] = [];
  undrp: any= [];
  bureau: any =[];

  constructor(private productService: ProductService, private messageService: MessageService, private demandeService:DemandebureauDrpService) { }


  ngOnInit(): void {
    this.afficheDrp();
    // this.productService.getProducts().then(data => this.products = data);

    // this.cols = [
    //     { field: 'product', header: 'Product' },
    //     { field: 'price', header: 'Price' },
    //     { field: 'category', header: 'Category' },
    //     { field: 'rating', header: 'Reviews' },
    //     { field: 'inventoryStatus', header: 'Status' }
    // ];

    // this.statuses = [
    //     { label: 'INSTOCK', value: 'instock' },
    //     { label: 'LOWSTOCK', value: 'lowstock' },
    //     { label: 'OUTOFSTOCK', value: 'outofstock' }
    // ];
    
  }
//Afficher la liste des drps
public afficheDrp(){
  this.demandeService.listDrp().subscribe(
    (data)=>{
      this.listdrp=data;
      console.log(this.listdrp);
  })
 
}
afficheUnDrp(idDrp:number){
  console.log(idDrp)
  this.demandeService.consulterDrp(idDrp).subscribe(prod=>{
    this.undrp=prod;

    console.log(this.undrp)});
  //this.idsuivi=c.id
  this.detailundrpDialog=true;

}
afficheBureau(idBr:number,idetat:number){
  this.demandeService.consulterBureau(idBr,idetat).subscribe(prod=>{
    this.bureau=prod;
    console.log(idBr)});
    console.log(this.bureau);
    this.detailBureauDialog=true;


}

  openNew() {
    this.product = {};
    this.submitted = false;
    this.productDialog = true;
}

deleteSelectedProducts() {
    this.deleteProductsDialog = true;
}

editProduct(product: Product) {
    this.product = { ...product };
    this.productDialog = true;
}

deleteProduct(product: Product) {
    this.deleteProductDialog = true;
    this.product = { ...product };
}

confirmDeleteSelected() {
    this.deleteProductsDialog = false;
    this.products = this.products.filter(val => !this.selectedProducts.includes(val));
    this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Products Deleted', life: 3000 });
    this.selectedProducts = [];
}

confirmDelete() {
    this.deleteProductDialog = false;
    this.products = this.products.filter(val => val.id !== this.product.id);
    this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Deleted', life: 3000 });
    this.product = {};
}

hideDialog() {
    this.productDialog = false;
    this.detailundrpDialog=false;
    this.detailBureauDialog=false;
    this.submitted = false;
}

saveProduct() {
    this.submitted = true;

    if (this.product.name?.trim()) {
        if (this.product.id) {
            // @ts-ignore
            this.product.inventoryStatus = this.product.inventoryStatus.value ? this.product.inventoryStatus.value : this.product.inventoryStatus;
            this.products[this.findIndexById(this.product.id)] = this.product;
            this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Updated', life: 3000 });
        } else {
            this.product.id = this.createId();
            this.product.code = this.createId();
            this.product.image = 'product-placeholder.svg';
            // @ts-ignore
            this.product.inventoryStatus = this.product.inventoryStatus ? this.product.inventoryStatus.value : 'INSTOCK';
            this.products.push(this.product);
            this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Created', life: 3000 });
        }

        this.products = [...this.products];
        this.productDialog = false;
        this.product = {};
    }
}

findIndexById(id: string): number {
    let index = -1;
    for (let i = 0; i < this.products.length; i++) {
        if (this.products[i].id === id) {
            index = i;
            break;
        }
    }

    return index;
}

createId(): string {
    let id = '';
    const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    for (let i = 0; i < 5; i++) {
        id += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return id;
}

onGlobalFilter(table: Table, event: Event) {
    table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
}
}
