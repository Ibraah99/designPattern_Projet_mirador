package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurArme;
import javafx.scene.control.Label;
import modele.Arme;

public class VueArme extends Vue {
	
	protected ControleurArme controleur;
	protected static VueArme instance = null; 
	public static VueArme getInstance() {if(null==instance)instance = new VueArme();return VueArme.instance;}; 

	private VueArme() {
		super("arme.fxml", VueArme.class);
		Logger.logMsg(Logger.INFO, "new VueArme()");
		super.controleur = this.controleur = new ControleurArme();
	}

	public void afficherArme(Arme arme) {
		Label vueNomArme = (Label) lookup("#nomArme");
		vueNomArme.setText(arme.getNom());
		
		Label vueTypeArme = (Label) lookup("#typeArme");
		vueTypeArme.setText(arme.getType());
		
		Label vueCalibre = (Label) lookup("#calibreArme");
		vueCalibre.setText(arme.getCalibre());
		
		Label vueOrigine = (Label) lookup("#origineArme");
		vueOrigine.setText(arme.getPaysOrigine());
		
		Label vueAnnee = (Label) lookup("#anneeArme");
		vueAnnee.setText(Integer.toString(arme.getAnnee()));
		
		Label vuePoids = (Label) lookup("#poidsArme");
		vuePoids.setText(String.valueOf(arme.getPoidsKg()));
	}
}
