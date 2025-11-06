package vue;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurFruit;
import javafx.scene.control.Label;
import modele.Fruit;

public class VueFruit extends Vue {
	
	protected ControleurFruit controleur;
	protected static VueFruit instance = null; 
	public static VueFruit getInstance() {if(null==instance)instance = new VueFruit();return VueFruit.instance;}; 
	
	private VueFruit()  {
		super("fruit.fxml", VueFruit.class);
		Logger.logMsg(Logger.INFO, "new VueFruit()");
		super.controleur = this.controleur = new ControleurFruit();
	}

	public void afficherFruit(Fruit fruit) {
	
		
			Label vueNomFruit = (Label) lookup("#nomFruit");
			vueNomFruit.setText(fruit.getName());
			
			Label vueFamille = (Label) lookup("#familleFruit");
			vueFamille.setText(fruit.getFamily());
			
			Label vueOrdreFruit = (Label) lookup("#orderFruit");
			vueOrdreFruit.setText(fruit.getOrder());
			
			Label vueGenreFruit = (Label) lookup("#genreFruit");
			vueGenreFruit.setText(fruit.getGenus());
			
		
		
	
	
}
}
