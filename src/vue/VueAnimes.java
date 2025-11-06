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

	public void afficherAnimes(Anime anime) {
		Label vueNomAnime = (Label) lookup("#nomAnimeFr");
		vueNomAnime.setText(anime.getTitle());
		Label vueNomAnime2 = (Label) lookup("#nomAnimeJp");
		vueNomAnime2.setText(anime.getTitleJapanese());
		
		Label vueGenre = (Label) lookup("#typeAnime");
		vueGenre.setText(anime.getType());
		
		Label vueAnneeAnime = (Label) lookup("#anneeAnime");
		vueAnneeAnime.setText(Integer.toString(anime.getYear()));
		
		Label vueUrl = (Label) lookup("#urlAnime");
		vueUrl.setText(anime.getUrl());
		
		
		
	}
	
}
