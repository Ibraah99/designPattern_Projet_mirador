
import java.util.ArrayList;
import java.util.List;

import architecture.Controleur;
import architecture.Fenetre;
import controleur.selecteur.MixeurDonnees;
import controleur.selecteur.SelecteurNouvellesParMotsCles;
import controleur.selecteur.SelecteurNouvellesRecentes;
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
		
		//FruitDAO fruitDao = new FruitDAO();
		//List<Fruit> fruits = fruitDao.listerFruits();
		//fruitDao.listerFruits();
		
		
		//AnimeDAO animeDao = new AnimeDAO();
		//animeDao.listerAnimes();
		
		//VoitureDAO voitureDao = new VoitureDAO();
		//voitureDao.listerVoitures();
		//List<Voiture> voitures = voitureDao.listerVoitures();
		
		//ArmeDAO armeDao = new ArmeDAO();
		//armeDao.listerArmes();
		
		EspaceDAO nouvelleEspacedao = new EspaceDAO();
		List<Espace> nouvelles = nouvelleEspacedao.listerNouvelles();
		
		/*for(Espace nouvelle : nouvelles) {
			System.out.println(nouvelle.getAuthor());
			System.out.println(nouvelle.getPubDate());
		}*/
		//MixeurDonnees selecteurNouvelles = new SelecteurNouvellesInterdites(nouvelles);
		/*MixeurDonnees selecteurNouvelles = new SelecteurNouvellesRecentes(nouvelles);
		selecteurNouvelles.executer();
		
		List<Espace> nouvellesRecentes = selecteurNouvelles.getNouvellesRecentes();
		for(Espace nouvelle : nouvellesRecentes) {
			System.out.println(nouvelle.getAuthor());
			System.out.println(nouvelle.getPubDate());
		}*/
		
		
		List<String> mots = new ArrayList<String>();
		mots.add("moon");
		mots.add("Adam");
		mots.add("China");

		SelecteurNouvellesParMotsCles nouvellesRecherchees =
		    new SelecteurNouvellesParMotsCles(nouvelles, mots);

		nouvellesRecherchees.executer();

		List<Espace> resultat = nouvellesRecherchees.getNouvellesRecentes(); 

		for(Espace e : resultat) {
			System.out.println("***************************************************************************************************************************************");
			System.out.println(e.getAuthor());
			System.out.println(e.getPubDate());
		    System.out.println(e.getDescription()); 
			System.out.println("***************************************************************************************************************************************");

		}

		
		
		
		//Controleur.choisirVuePrincipale(VueMirador.class);
		//Controleur.choisirVuePrincipale(VueFruit.class);
		//Controleur.choisirVuePrincipale(VueAnimes.class);
		//Controleur.choisirVuePrincipale(VueArme.class);
		//Controleur.choisirVuePrincipale(VueNouvelles.class);
		//Controleur.choisirVuePrincipale(VueVoiture.class);

		//Fenetre.launch(Fenetre.class, parametres);	
	}

}
