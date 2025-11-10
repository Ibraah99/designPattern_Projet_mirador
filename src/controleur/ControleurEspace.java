package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import data.EspaceDAO;
import modele.Espace;
import vue.VueNouvelles;

public class ControleurEspace extends Controleur { 

	public ControleurEspace()
	{
		Logger.logMsg(Logger.INFO, "new ControleurNouvelles()");
	}
	public void initialiser()
	{
		/*Espace espace1 = new Espace("Terre", "v", " d", "v", "Ibrahim");
		Espace espace2 = new Espace("Mars", "v", " d", "v", "Issa");
		Espace espace3 = new Espace("Jupiterre", "v", " d", "v", "Sogodogo");
		Espace espace4 = new Espace("Venus", "v", " d", "v", "Baba");
		Espace espace5 = new Espace("Neptune", "v", " d", "v", "Bourama");
		Espace espace6 = new Espace("Pluton", "v", " d", "v", "Aminata");*/
		
	
		
		//List<Espace> nouvellesDeEspace = new ArrayList<Espace>();
		//nouvellesDeEspace.add(espace1);
		//nouvellesDeEspace.add(espace2);
		//nouvellesDeEspace.add(espace3);
		//nouvellesDeEspace.add(espace4);
		//nouvellesDeEspace.add(espace5);
		//nouvellesDeEspace.add(espace6);
		  EspaceDAO dao = new EspaceDAO();
		    List<Espace> nouvellesDeEspace = dao.listerNouvelles();

		    VueNouvelles.getInstance().afficherNouvelles(nouvellesDeEspace);
		
		VueNouvelles.getInstance().afficherNouvelles(nouvellesDeEspace);
	}

}
