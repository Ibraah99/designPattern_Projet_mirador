package data;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Fruit;

public class FruitDAO {

    public String URL_FRUIT = "https://www.fruityvice.com/api/fruit/all";

    public List<Fruit> listerFruits() {
        System.out.println("fruitDao.listerFruits()");
        String json = "";

        try {
            URL url = new URL(URL_FRUIT);
            InputStream flux = url.openConnection().getInputStream();
            Scanner lecteur = new Scanner(flux);
            lecteur.useDelimiter("\\A");
            json = lecteur.hasNext() ? lecteur.next() : "";
            lecteur.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        List<Fruit> fruits = new ArrayList<>();

        JsonParser parseur = new JsonParser();
        JsonArray listeFruits = parseur.parse(json).getAsJsonArray();

        for (int i = 0; i < listeFruits.size(); i++) {
            JsonObject fruitJson = listeFruits.get(i).getAsJsonObject();

            String nom = fruitJson.get("name").getAsString();
            String family = fruitJson.get("family").getAsString();
            String order = fruitJson.get("order").getAsString();
            String genus = fruitJson.get("genus").getAsString();

            Fruit fruit = new Fruit(nom, family, order, genus);
            fruits.add(fruit);
        }

        return fruits;
    }
}