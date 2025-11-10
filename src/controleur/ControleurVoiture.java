package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import data.VoitureDAO;
import modele.Voiture;

import vue.VueNouvelles;
import vue.VueVoiture;

public class ControleurVoiture extends Controleur {

	public ControleurVoiture()
	{
		Logger.logMsg(Logger.INFO, "new ControleurVoiture()");
	}

	public void initialiser()
	{
		/*Voiture voiture1 = new Voiture("Corolla", "Toyota");
		Voiture voiture2 = new Voiture("Civic", "Honda");
		Voiture voiture3 = new Voiture("Mustang", "Ford");
		Voiture voiture4 = new Voiture("Camaro", "Chevrolet");
		Voiture voiture5 = new Voiture("M3", "BMW");
		Voiture voiture6 = new Voiture("Classe C", "Mercedes-Benz");
	
		
		List<Voiture> voitures = new ArrayList<Voiture>();
		voitures.add(voiture1);
		voitures.add(voiture2);
		voitures.add(voiture3);
		voitures.add(voiture4);
		voitures.add(voiture5);
		voitures.add(voiture6);*/
	    VoitureDAO dao = new VoitureDAO();
	    List<Voiture> voitures = dao.listerVoitures();
	    VueVoiture.getInstance().afficherVoiture(voitures);
		//VueVoiture.getInstance().afficherVoiture(voitures);
	}

	
	public void notifierActionConvertir()
	{
		Logger.logMsg(Logger.INFO, "ControleurAmis.notifierActionConvertir()");
	}
	
}
