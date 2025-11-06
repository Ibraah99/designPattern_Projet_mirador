package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Espace;
import modele.Fruit;
import vue.VueFruit;
import vue.VueNouvelles;

public class ControleurFruit extends Controleur {

	public ControleurFruit()
	{
		Logger.logMsg(Logger.INFO, "new ControleurFruit()");
	}
	public void initialiser()
	{
		Fruit fruit = new Fruit("Pomme", "Rosaceae", "Rosales", "Malus");
		Fruit fruit2 = new Fruit("Banane", "Musaceae", "Zingiberales", "Musa");
		Fruit fruit3 = new Fruit("Orange", "Rutaceae", "Sapindales", "Citrus");
		
	
		
		/*List<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(fruit1);
		fruits.add(fruit2);
		fruits.add(fruit3);List<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(fruit1);
		fruits.add(fruit2);
		fruits.add(fruit3);*/
		
		//VueFruit.getInstance().afficherFruit(fruit);
	}

}
