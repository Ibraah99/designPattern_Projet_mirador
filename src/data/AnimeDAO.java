package data;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Anime;

public class AnimeDAO {
    public String URL_ANIME = "https://api.jikan.moe/v4/top/anime?type=ova";

    public List<Anime> listerAnimes() {
        System.out.println("animeDao.listerAnimes()");
        String json = "";

        try {
            URL url = new URL(URL_ANIME);
            InputStream flux = url.openConnection().getInputStream();
            Scanner lecteur = new Scanner(flux);
            lecteur.useDelimiter("\\A");
            json = lecteur.hasNext() ? lecteur.next() : "";
            lecteur.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        List<Anime> animes = new ArrayList<>();

        JsonParser parseur = new JsonParser();
        JsonObject document = parseur.parse(json).getAsJsonObject();
        JsonArray listeAnime = document.getAsJsonArray("data");

        for (int i = 0; i < listeAnime.size(); i++) {
            JsonObject animeJson = listeAnime.get(i).getAsJsonObject();

            String title = animeJson.get("title").getAsString();
            String titleJapanese = animeJson.get("title_japanese").getAsString();
            String type = animeJson.get("type").getAsString();
            int year = animeJson.get("year") != null ? animeJson.get("year").getAsInt() : 0;
            String url = animeJson.get("url").getAsString();

            Anime anime = new Anime(url, title, titleJapanese, type, year);
            animes.add(anime);
        }

        return animes;
    }
}
