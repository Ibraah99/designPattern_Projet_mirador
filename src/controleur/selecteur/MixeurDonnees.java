package controleur.selecteur;

import java.util.ArrayList;
import java.util.List;

import modele.Espace;

public abstract class MixeurDonnees {
	
	
	protected List<Espace> nouvellesOriginales = null;
	protected List<Espace> nouvellesFiltrees = null;
	
	public MixeurDonnees ( List<Espace> nouvelles) {
		this.nouvellesOriginales = nouvelles;
		this.nouvellesFiltrees = new ArrayList<Espace>();
		
	}
	
	
	//Decide de l'ordre des opérations 
	public void executer () {
		this.filtrer();
		this.trier();
		this.transformer();
	}
	
	public abstract void  filtrer();
	
	public  abstract void trier();
	
	public  abstract void transformer();
	
	public List<Espace> getNouvellesRecentes() {
	    return nouvellesFiltrees;
	}


}
