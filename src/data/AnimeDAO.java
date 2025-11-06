package data;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AnimeDAO {
	public String URL_ANIME="https://api.jikan.moe/v4/top/anime?type=ova";
	String json = "";
	
	public void listerAnimes() {
		// TODO : Retourner une liste d'objets animes
		System.out.println("animeDao.listerAnimes()");
		try {
			URL url = new URL(URL_ANIME);
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
          JsonObject document = parseur.parse(json).getAsJsonObject();

          JsonArray listeAnime = document.get("data").getAsJsonArray();
          for (int position = 0; position < listeAnime.size(); position++) {
        	  JsonObject animeJson = listeAnime.get(position).getAsJsonObject();
        	  String title = animeJson.get("title").getAsString();
        	  String type = animeJson.get("type").getAsString();
        	 // String year = animeJson.get("year").getAsString();
        	  String titleJapanese = animeJson.get("title_japanese").getAsString();
        	 // String url = animeJson.get("url").getAsString();
        	  System.out.println(title);
        	  System.out.println(titleJapanese);
        	  System.out.println(type);
        	  //System.out.println(year);
        	  //System.out.println(url);
        	 
        	  
        	  
          }

	}
}
