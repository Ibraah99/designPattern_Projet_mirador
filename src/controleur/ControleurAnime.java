package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Anime;
import vue.VueAnimes;
import vue.VueNouvelles;

public class ControleurAnime extends Controleur {

	public ControleurAnime()
	{
		Logger.logMsg(Logger.INFO, "new ControleurAnime()");
	}
	public void initialiser()
	{
		
		Anime anime = new Anime("link","Jujutsu Kaisen", "呪術廻戦", "TV-Shonen", 2020);
		/*Anime anime2 = new Anime();
		Anime anime3 = new Anime();
		
	
		
		List<Anime> animes = new ArrayList<Anime>();
		animes.add(anime1);
		animes.add(anime2);
		animes.add(anime3);*/
		
		VueAnimes.getInstance().afficherAnimes(anime);
	}

	
}
