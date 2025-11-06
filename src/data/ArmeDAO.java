package data;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ArmeDAO {
	public String URL_ARME="https://api.npoint.io/11da8cc6fe9af6d12427";
	String json = "";
	
	public void listerArmes() {
		// TODO : Retourner une liste d'objets armes
		System.out.println("armeDao.listerArmes()");
		try {
			URL url = new URL(URL_ARME);
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
		JsonArray listeArmes = parseur.parse(json).getAsJsonArray();
        
        for (int position = 0; position < listeArmes.size(); position++) {
			JsonObject armeJson = listeArmes.get(position).getAsJsonObject();
		    //int id = armeJson.get("id").getAsInt();
		    String nom = armeJson.get("nom").getAsString();
		    String type = armeJson.get("type").getAsString();
		    //int annee = armeJson.get("annee").getAsInt();
		    String calibre = armeJson.get("calibre").getAsString();
		   // float poidsKg = armeJson.get("calibre").getAsFloat();
		    String pays = armeJson.get("paysOrigine").getAsString();
		   // int capaciteChargeur = armeJson.get("capaciteChargeur").getAsInt();
			System.out.println(nom);
			System.out.println(type);
			//System.out.println(annee);
			System.out.println(calibre);
			System.out.println(pays);
			}

	}}
