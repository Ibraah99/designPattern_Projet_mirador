
import java.util.List;

import architecture.Controleur;
import architecture.Fenetre;
import data.AnimeDAO;
import data.ArmeDAO;
import data.EspaceDAO;
import data.FruitDAO;
import data.VoitureDAO;
import modele.Espace;
import modele.Fruit;
import modele.Voiture;
import vue.VueVoiture;
import vue.VueAnimes;
import vue.VueArme;
import vue.VueFruit;
import vue.VueMirador;
import vue.VueNouvelles;

public class App {

	public static void main(String[] parametres) {
		
		FruitDAO fruitDao = new FruitDAO();
		//List<Fruit> fruits = fruitDao.listerFruits();
		fruitDao.listerFruits();
		
		
		//AnimeDAO animeDao = new AnimeDAO();
		//animeDao.listerAnimes();
		
		//VoitureDAO voitureDao = new VoitureDAO();
		//voitureDao.listerVoitures();
		//List<Voiture> voitures = voitureDao.listerVoitures();
		
		//ArmeDAO armeDao = new ArmeDAO();
		//armeDao.listerArmes();
		
		/*EspaceDAO nouvelleEspacedao = new EspaceDAO();
		List<Espace> nouvelles = nouvelleEspacedao.listerNouvelles();
		
		for(Espace nouvelle : nouvelles) {
			System.out.println(nouvelle.getTitle());
		}*/
		
		//Controleur.choisirVuePrincipale(VueMirador.class);
		Controleur.choisirVuePrincipale(VueFruit.class);
		
		//Controleur.choisirVuePrincipale(VueAnimes.class);
		//Controleur.choisirVuePrincipale(VueArme.class);
		//Controleur.choisirVuePrincipale(VueNouvelles.class);
		//Controleur.choisirVuePrincipale(VueVoiture.class);

		Fenetre.launch(Fenetre.class, parametres);	
	}

}
