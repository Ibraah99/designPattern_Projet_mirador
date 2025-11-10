package data;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Voiture;

public class VoitureDAO {
    public String URL_VOITURE = "https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformakeyear/make/honda/vehicleType/truck?format=json";
    String json = "";

    public List<Voiture> listerVoitures() {
        String json = "";
        try {
            URL url = new URL(URL_VOITURE);
            InputStream flux = url.openConnection().getInputStream();
            Scanner lecteur = new Scanner(flux);
            lecteur.useDelimiter("\\A");
            json = lecteur.hasNext() ? lecteur.next() : "";
            lecteur.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        List<Voiture> voitures = new ArrayList<>();

        JsonParser parseur = new JsonParser();
        JsonObject racine = parseur.parse(json).getAsJsonObject();
        JsonArray listeVoitures = racine.getAsJsonArray("Results");

        for (int i = 0; i < listeVoitures.size(); i++) {
            JsonObject v = listeVoitures.get(i).getAsJsonObject();
            String marque = v.get("Make_Name").getAsString();
            String modele = v.get("Model_Name").getAsString();
            voitures.add(new Voiture(modele, marque));
        }

        return voitures;
    }


}
