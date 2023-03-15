import { EtatBudget } from "./EtatBudget";
import { Structure } from "./structure";

export class Budget {
	public id?: number;
	public montant?: number;
	public version=1;
	public anne?: Date;
	public montant_execute?: number;
	public montant_propose_bureau?: number=0;
	public montant_propose_drp?: number;
	public structure?: Structure;
	public etatBudget?: EtatBudget;
   
}
