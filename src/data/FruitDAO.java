package data;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Fruit;

public class FruitDAO {
	
	public String URL_FRUIT="https://www.fruityvice.com/api/fruit/all";
	String json = "";
	
	public void listerFruits() {
		// TODO : Retourner une liste d'objets fruits
		System.out.println("fruitDao.listerFruits()");
		try {
			URL url = new URL(URL_FRUIT);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			json = lecteur.next();
			//System.out.println(json);
			lecteur.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			return ;
		}
		JsonParser parseur = new JsonParser();
		JsonArray listeFruits = parseur.parse(json).getAsJsonArray();
        
        for (int position = 0; position < listeFruits.size(); position++) {
			JsonObject fruitJson = listeFruits.get(position).getAsJsonObject();
		    //int id = fruitJson.get("id").getAsInt();
		    String nom = fruitJson.get("name").getAsString();
		    String family = fruitJson.get("family").getAsString();
		    String order = fruitJson.get("order").getAsString();
		    String genus = fruitJson.get("genus").getAsString();
			System.out.println(nom);
			System.out.println(family);
			System.out.println(order);
			System.out.println(genus);
		}
	

	}
	}
