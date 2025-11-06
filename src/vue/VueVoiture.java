package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurVoiture;
import javafx.scene.control.Label;
import modele.Voiture;

public class VueVoiture extends Vue {
	
	protected ControleurVoiture controleur;
	
	protected static VueVoiture instance = null; 
	public static VueVoiture getInstance()  { if(null==instance) instance = new VueVoiture(); return VueVoiture.instance;}; 
	
	private VueVoiture()  {
		super("voiture.fxml", VueVoiture.class);
		Logger.logMsg(Logger.INFO, "new VueVoiture()");
		super.controleur = this.controleur = new ControleurVoiture();
	}

	public void afficherVoiture(List<Voiture> voitures) {
		int position = 0;
		for(Voiture voiture : voitures) {
			position++;
			if(position > 6)break;
			
			String idNom = "#nom-voiture" + position;
			Label vueNom = (Label) lookup(idNom);
			vueNom.setText(voiture.getMake_Name());
			
			String idModel = "#marque-voiture" + position;
			Label vueModel = (Label) lookup(idModel);
			vueModel.setText(voiture.getModel_Name());
			
		}
		
	}
	
	//void afficherAmis(List<Amis> listeAmis)
	//{
	//}
}
