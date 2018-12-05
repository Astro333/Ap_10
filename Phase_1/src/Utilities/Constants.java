package Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Constants {

    private static HashMap<String, Float> productsDepotSize;
    private static HashMap<String, Integer> productsBuyCost;
    private static HashMap<String, Integer> productsSaleCost;

    private static HashMap<Byte, Pair<Integer, Integer>> workshopsDropZoneAfrica; // from continent
    private static HashMap<Byte, Pair<Integer, Integer>> workshopsDropZoneAntarctica; // from continent
    private static HashMap<Byte, Pair<Integer, Integer>> workshopsDropZoneSouthAmerica; // from continent
    private static HashMap<Byte, Pair<Integer, Integer>> workshopsDropZonePrairie; // from continent
    private static HashMap<Byte, Pair<Integer, Integer>> workshopsDropZoneRussia; // from continent
    private static boolean isInitiated = false;

    // MUST INITIATE THIS CLASS AT LOADING MENU
    public static boolean initiate() {
        if(!isInitiated){
            Gson gson = new GsonBuilder().create();
            Reader reader;
            Type type = new TypeToken<Map<String, Float>>(){}.getType();

            reader = new InputStreamReader(JsonParser.class.getResourceAsStream(
                    "../DefaultGameData/productsDepotSize.json"),
                    StandardCharsets.UTF_8);
            productsDepotSize = gson.fromJson(reader, type);

            type = new TypeToken<Map<String, Integer>>(){}.getType();

            reader = new InputStreamReader(JsonParser.class.getResourceAsStream(
                    "../DefaultGameData/productsSaleCost.json"));

            productsSaleCost = gson.fromJson(reader, type);

            reader = new InputStreamReader(JsonParser.class.getResourceAsStream(
                    "../DefaultGameData/productsBuyCost.json"));
            productsBuyCost = gson.fromJson(reader, type);



            isInitiated = true;
            return true;
        }
        return false;
    }

    public static Float getProductSize(String product){
        return productsDepotSize.getOrDefault(product, null);
    }
    public static Integer getProductSaleCost(String product){return productsBuyCost.getOrDefault(product, null);}
    public static Integer getProductBuyCost(String product){
        return productsBuyCost.getOrDefault(product, null);
    }
    public static Pair<Integer, Integer> getWorkshopDropZone(String continent, byte position){
        switch (continent){
            case "prairie":
                return workshopsDropZonePrairie.get(position);
            case "southAmerica":
                return workshopsDropZoneSouthAmerica.get(position);
            case "russia":
                return workshopsDropZoneRussia.get(position);
            case "antarctica":
                return workshopsDropZoneAntarctica.get(position);
            case "africa":
                return workshopsDropZoneAfrica.get(position);
            default:
                return null;
        }
    }
}
