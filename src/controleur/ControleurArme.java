package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import data.ArmeDAO;
import modele.Arme;
import modele.Espace;
import vue.VueArme;
import vue.VueNouvelles;

public class ControleurArme extends Controleur {

	public ControleurArme()
	{
		Logger.logMsg(Logger.INFO, "new ControleurArme()");
	}
	public void initialiser()
	{

		//Arme arme = new Arme("Katana", "Sabre", "Japon", 1600, "N/A", 0 , 1.1);
		/*Arme arme2 = new Arme();
		Arme arme3 = new Arme();
		
	
		
		List<Arme> armes = new ArrayList<Arme>();
		armes.add(arme1);
		armes.add(arme2);
		armes.add(arme3);*/
		 ArmeDAO dao = new ArmeDAO();
	        List<Arme> armes = dao.listerArmes();

	        if(armes.isEmpty()) {
	            System.out.println(" Aucune arme trouvée !");
	            return;
	        }

	        VueArme.getInstance().afficherArme(armes.get(2)); 
	}

}


