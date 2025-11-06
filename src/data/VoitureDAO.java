package data;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class VoitureDAO {
    public String URL_VOITURE = "https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformakeyear/make/honda/vehicleType/truck?format=json";
    String json = "";

    public void listerVoitures() {
        System.out.println("voitureDao.listerVoitures()");
        try {
            URL url = new URL(URL_VOITURE);
            InputStream flux = url.openConnection().getInputStream();
            Scanner lecteur = new Scanner(flux);
            lecteur.useDelimiter("\\A");
            json = lecteur.hasNext() ? lecteur.next() : "";
            lecteur.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        JsonParser parseur = new JsonParser();
        JsonObject racine = parseur.parse(json).getAsJsonObject();
        JsonArray listeVoitures = racine.getAsJsonArray("Results");

        for (int position = 0; position < listeVoitures.size(); position++) {
            JsonObject voitureJson = listeVoitures.get(position).getAsJsonObject();
            int id = voitureJson.get("Make_ID").getAsInt();
            String nom = voitureJson.get("Make_Name").getAsString();
            String model = voitureJson.get("Model_Name").getAsString();
            String type = voitureJson.get("VehicleTypeName").getAsString();

            System.out.println(nom);
            System.out.println(model);
            System.out.println(type);
        }
    }
}
