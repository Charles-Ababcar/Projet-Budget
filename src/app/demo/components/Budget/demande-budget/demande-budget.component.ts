import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ConfirmationService, ConfirmEventType, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { Product } from 'src/app/demo/api/product';
import { ProductService } from 'src/app/demo/service/product.service';
import { Budget } from 'src/app/demo/model/budget';
import { User } from 'src/app/demo/model/user';
import { AuthServiceService } from 'src/app/layout/service/auth-service.service';
import { DemandeBudgetService } from 'src/app/layout/service/demande-budget.service';
import { LigneBudgetaire } from '/Applications/XAMPP/xamppfiles/htdocs/sakai-ng-master/src/app/demo/model/ligneBudgetaire';
import { SuiviBudget } from '/Applications/XAMPP/xamppfiles/htdocs/sakai-ng-master/src/app/demo/model/suiviBudget';


@Component({
  selector: 'app-demande-budget',
  templateUrl: './demande-budget.component.html',
  styleUrls: ['./demande-budget.component.scss'],
  providers: [ConfirmationService,MessageService]
})
export class DemandeBudgetComponent implements OnInit {

  productDialog: boolean = false;

  deleteProductDialog: boolean = false;

  deleteProductsDialog: boolean = false;

  products: Product[] = [];

  product: Product = {};

  selectedProducts: Product[] = [];

  submitted: boolean = false;

  cols: any[] = [];

  statuses: any[] = [];

  rowsPerPageOptions = [5, 10, 20];
    infosUser:any;
    compte: any=[];
    idrole?:number;
    idstructure:number=0;
    listcompte: any[]=[];
    montant:any;
    somme:number=0; 
    budgetSaved:any; 
   // budget : Budget ={};
    ligneSaved:any;
    suiviSaved:any;
   newbudget =  new Budget();
   newligne = new LigneBudgetaire();
   newSuivi = new SuiviBudget();
  listLigneBudget:any=[];
  listindex:any=[]
  elements:any=[]
  list:any={}
  obj: any;
  inserer=false
   
  constructor(private productService: ProductService,private confirmationService: ConfirmationService, private messageService: MessageService,
    private serviceAuth:AuthServiceService, private serviceDemandeBudget:DemandeBudgetService) { }

  ngOnInit(): void {
    this.getInfosUsername();
    
    // this.onFormSubmit(userForm:NgForm)

    // this.productService.getProducts().then(data => this.products = data);

    //     this.cols = [
    //         { field: 'product', header: 'Product' },
    //         { field: 'price', header: 'Price' },
    //         { field: 'category', header: 'Category' },
    //         { field: 'rating', header: 'Reviews' },
    //         { field: 'inventoryStatus', header: 'Status' }
    //     ];

    //     this.statuses = [
    //         { label: 'INSTOCK', value: 'instock' },
    //         { label: 'LOWSTOCK', value: 'lowstock' },
    //         { label: 'OUTOFSTOCK', value: 'outofstock' }
    //     ];

  }

  
  getInfosUsername(){
    this.serviceAuth.infosUsername().subscribe(
        (data) => {
            this.infosUser = data;
            console.log(this.infosUser)
                console.log(this.infosUser.idrole)
                if (this.infosUser.idrole===1) {
                    this.serviceDemandeBudget.find(1,1).subscribe((data) => {
                         this.compte = data;
                         });
              } else if(this.infosUser.idrole===2) {
                this.serviceDemandeBudget.find(1,0).subscribe((data) => {
                this.compte = data;
                console.log(this.compte)
                this.listcompte.push(this.compte)
               
             });
      }
      this.idrole=this.infosUser.idrole;
      this.idstructure=this.infosUser.id;
      console.log(this.idrole)
      console.log(this.idstructure)
  
    
    
    });
    console.log( this.listcompte)
}


onFormSubmit(userForm:NgForm){
  
    console.log(this.compte)
    for (let index = 0; index < this.compte.length; index++) {
        const element =this.compte[index].value;
        
    
    //    let valu=userForm.controls[this.compte[index].libelle].value;
      
      
      this.montant= userForm.controls[this.compte[index].libelle].value;
      this.somme=this.somme+parseInt(this.montant);
      console.log(this.montant,this.somme)
      
    }
   
   // console.log(newbudget)
   // this.newbudget.montant_execute=0;
    if (this.idrole===2) {
      this.newbudget.montant_propose_drp=this.somme;
    }else if(this.idrole===1){
      //this.newbudget.montant_propose_drp=0;
      this.newbudget.montant_propose_bureau=this.somme;
    }
    //this.newbudget.montant=0;
    console.log(this.newbudget)
   this.newbudget.structure= this.infosUser.structure
    this.serviceDemandeBudget.save(this.newbudget).subscribe(
        (data)=>{
          this.messageService.add({severity: 'success',summary: 'Successful', detail: 'Budget Enregistre avec succes',life: 3000,});
            this.budgetSaved = data;
            console.log(this.budgetSaved)
            
      // for (let index = 0; index < this.compte.length; index++) {
       
      //   this.montant=userForm.controls[this.compte[index].libelle].value;
      //   if (this.idrole===2) {
      //     this.newligne.montantProposeDrp = parseInt(this.montant);
      //   }else if(this.idrole===1){
        //  this.newligne.montantProposeDrp=0;
      //     this.newligne.montantProposeBureau =parseInt(this.montant);
      //   }
        // this.newligne.montantExecute=0;
        //this.newligne.montant=0;
        //this.newligne.id_budget=this.budgetSaved.id;
       
        this.serviceDemandeBudget.saveLigne(this.budgetSaved.id,this.compte).subscribe((data) => {
          this.ligneSaved = data;
          console.log(this.ligneSaved)
        });
        
       
        this.serviceDemandeBudget.saveSuivi(this.newSuivi,this.budgetSaved.id,2).subscribe((data) => {
          this.suiviSaved = data;
          console.log(this.suiviSaved)
          });
       
         
   

        // for (let l of this.listLigneBudget) {
        //   console.log(l)
           
          
        // }

       

     
        // if (this.idrole===2) {
        //     this.serviceDemandeBudget.saveSuivi(this.newSuivi,this.budgetSaved.id,2).subscribe(data => {
        //     this.suiviSaved = data;
        //     });
        // } else if(this.idrole===1)
        // {
        //   this.serviceDemandeBudget.saveSuivi(this.newSuivi,this.budgetSaved.id,1).subscribe(data => {
        //     this.suiviSaved = data;
        //     });
        // }
      
         },(error) => {
         this.messageService.add({
          severity: 'error',
          summary: 'error',
          detail: 'Budget non Enregistrer',
          life: 3000,
      });
      
  }

  )   
    
}



onConfirm() {
  this.inserer=true;
  this.messageService.clear('c');
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
function typeOf() {
    throw new Error('Function not implemented.');
}

