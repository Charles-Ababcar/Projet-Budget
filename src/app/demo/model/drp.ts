import { Budget } from "./budget";
import { Structure } from "./structure";

export interface Drp {
    id?: number;   
    nomdrp?: string;
    budget?:Budget;
    structure:Structure[];
}
