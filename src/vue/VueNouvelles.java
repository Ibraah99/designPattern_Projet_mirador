package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurEspace;
import javafx.scene.control.Label;
import modele.Espace;

public class VueNouvelles extends Vue {

	protected ControleurEspace controleur = null;
	protected static VueNouvelles instance = null; 
	public static VueNouvelles getInstance() {if(null==instance)instance = new VueNouvelles();return VueNouvelles.instance;}; 

	private VueNouvelles() {
		super("nouvelles.fxml", VueNouvelles.class);
		Logger.logMsg(Logger.INFO, "new VueNouvelles()");
		super.controleur = this.controleur = new ControleurEspace();
	}

	public void afficherNouvelles(List<Espace> nouvellesDeEspace) {
		int position = 0;
		for (Espace espace : nouvellesDeEspace) {
			position++;
			if(position > 6) break;
			
			String idTitre = "#nouvelle-titre-" + position;
			Label vueTitre = (Label) lookup(idTitre);
			vueTitre.setText(espace.getTitle());
			
			String idAuteur = "#nouvelle-auteur-" + position;
			Label vueAuteur = (Label) lookup(idAuteur);
			vueAuteur.setText(espace.getAuthor());
			
			String idDescription = "#nouvelle-desc-" + position;
			Label vueDescription = (Label) lookup(idDescription);
			vueDescription.setText(espace.getDescription());
			
			String idDate = "#nouvelle-date-" + position;
			Label vueDate = (Label) lookup(idDate);
			vueDate.setText(espace.getPubDate());
		}
		}
		
	}
	


