import { Drp } from "./drp";

export interface Structure {
     id?: number;
     bureau?:number;
     codeStructure?:number
     nomStructure?: string;
     codepostal?:number;
     zone_id?:number;
     noeud?:boolean;
     noeudct?:boolean;
     longitude?:string;
     latitude?:string;
     drp?:Drp;

}
