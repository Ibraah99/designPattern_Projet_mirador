package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Espace;
import vue.VueMirador;

public class ControleurMirador extends Controleur{

	public ControleurMirador()
	{
		Logger.logMsg(Logger.INFO, "new ControleurMirador()");
	}
	
	public void initialiser()
	{
		Espace espace1 = new Espace("Terre", "v", " d", "v", "vvv");
		Espace espace2 = new Espace("Mars", "v", " d", "v", "vvv");
		Espace espace3 = new Espace("Jupiterre", "v", " d", "v", "vvv");
		
		//VueMirador.getInstance().afficherNouvelle(espace2);
		
		List<Espace> nouvelleDeEspace = new ArrayList<Espace>();
		nouvelleDeEspace.add(espace1);
		nouvelleDeEspace.add(espace2);
		nouvelleDeEspace.add(espace3);
		VueMirador.getInstance().afficherNouvelles(nouvelleDeEspace);


		
	}

}
