package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurAnime;
import javafx.scene.control.Label;
import modele.Anime;

public class VueAnimes extends Vue {
	
	protected ControleurAnime controleur = null;
	protected static VueAnimes instance = null; 
	public static VueAnimes getInstance() {if(null==instance)instance = new VueAnimes();return VueAnimes.instance;}; 
	
	private VueAnimes()  {
		super("anime.fxml", VueAnimes.class);
		Logger.logMsg(Logger.INFO, "new VueAnimes()");
		super.controleur = this.controleur = new ControleurAnime();
	}

	public void afficherAnimes(Anime a) {

	    
	  /*  int position=0;
	    for (Anime a : animes) {
	    	
	    	
			position++;
			if(position >= 1)break;
	    }*/
			
	    	//Anime a = animes.get(0);

		    Label vueNomAnime = (Label) lookup("#nomAnimeFr");
		    vueNomAnime.setText(a.getTitle());

		    Label vueNomAnime2 = (Label) lookup("#nomAnimeJp");
		    vueNomAnime2.setText(a.getTitleJapanese());

		    Label vueGenre = (Label) lookup("#typeAnime");
		    vueGenre.setText(a.getType());

		    Label vueAnneeAnime = (Label) lookup("#anneeAnime");
		    vueAnneeAnime.setText(Integer.toString(a.getYear()));

		    Label vueUrl = (Label) lookup("#urlAnime");
		    vueUrl.setText(a.getUrl());
	    	
	    

	    
	}

	
}
