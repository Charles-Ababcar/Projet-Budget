import { Budget } from "./budget";
import { CompteBudget } from "./compteBudget";

export class LigneBudgetaire {
	 id?: number;
	 montant?: number;
	 montantProposeBureau?: number;
	 montantProposeDrp?: number;
	 montantExecute?: number;
	 budget?: Budget;
	 compteBudget?: CompteBudget;
	 version =1;
} 