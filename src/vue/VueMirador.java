package vue;
import com.sun.media.jfxmedia.logging.Logger;

import java.util.List;

import architecture.Vue;
import controleur.ControleurMirador;
import javafx.scene.control.TextArea;
import modele.Espace;
public class VueMirador extends Vue {

	protected ControleurMirador controleur;
	protected static VueMirador instance = null; 
	public static VueMirador getInstance() {if(null==instance)instance = new VueMirador();return VueMirador.instance;}; 
	
	private VueMirador() 
	{
		super("mirador.fxml", VueMirador.class);
		super.controleur = this.controleur = new ControleurMirador();
		Logger.logMsg(Logger.INFO, "new VueMirador()");
	}
		
	public void activerControles()
	{
		super.activerControles();
	}
	
	public void afficherNouvelles (List<Espace> epaces) {
		TextArea vueNouvelles = (TextArea)lookup("#nouvelles-spacex");
		for(Espace espace:epaces) {
			vueNouvelles.appendText(espace.getTitle());
		}
	}
	
	public void afficherNouvelle (Espace espace) {
		
		TextArea vueNouvelles = (TextArea)lookup("#nouvelles-spacex");
		vueNouvelles.setText(espace.getTitle());
		
	}
}
