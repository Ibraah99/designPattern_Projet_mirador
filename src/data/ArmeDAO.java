package data;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Arme;

public class ArmeDAO {
    public String URL_ARME = "https://api.npoint.io/11da8cc6fe9af6d12427";

    public List<Arme> listerArmes() {

        System.out.println("armeDao.listerArmes()");
        String json = "";

        try {
            URL url = new URL(URL_ARME);
            InputStream flux = url.openConnection().getInputStream();
            Scanner lecteur = new Scanner(flux);
            lecteur.useDelimiter("\\A");
            json = lecteur.hasNext() ? lecteur.next() : "";
            lecteur.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        List<Arme> armes = new ArrayList<>();

        JsonParser parseur = new JsonParser();
        JsonArray listeArmes = parseur.parse(json).getAsJsonArray();

        for (int i = 0; i < listeArmes.size(); i++) {
            JsonObject armeJson = listeArmes.get(i).getAsJsonObject();

            String nom = armeJson.get("nom").getAsString();
            String type = armeJson.get("type").getAsString();
            String calibre = armeJson.get("calibre").getAsString();
            String pays = armeJson.get("paysOrigine").getAsString();
            int annee = armeJson.get("annee").getAsInt();
            float poids = armeJson.get("poidsKg").getAsFloat();

            Arme arme = new Arme(nom, type, pays, annee, calibre, 0, poids);
            armes.add(arme);
        }

        return armes;
    }
}
