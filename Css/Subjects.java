import java.util.Random;

public class Subjects {
    Random random = new Random();

    private String[] Clothe ={"Shirt","T-Shirt","Boots","Scarf","jeans","Pyjama","Trouser","Jacket"};
    private int ClothRand = random.nextInt(7);
    public String SelectCloth ()
    {
        return Clothe[ClothRand];
    }

    /**
     * Select a random clothes for clothes array.
     */

    private String[] Foods ={"Pasta","Pizza","Burger","Noodles","Soup","Snacks","Meat","Chicken"};
    private int FoodRand = random.nextInt(7);
    public String SelectFood ()
    {
        return Foods[FoodRand];
    }
    /**
     * Select a random food for foods array.
     */


    private String[] Sweet ={"Abu odi","Cake","Chocolate","Tart","Ice cream","Vanilla","Swiss roll","Gum"};
    private int SweetRand = random.nextInt(7);
    public String SelectSweets ()
    {
        return Sweet[SweetRand];
    }

    /**
     * Select a random sweet for sweet array.
     */

    private String[] Anime ={"Dragonball","Attack on titan","Naruto","One punch man","Ousama ranking","Chainsaw man","Bleach","Black clover"};
    private int AnimeRand = random.nextInt(7);
    public String SelectAnime ()
    {
        return Anime[AnimeRand];
    }

    /**
     * Select a anime clothes for anime array.
     */

    private String[] Animal ={"lion","cow","cat","elephant","mouse","alligator","Crow","eagle"};
    private int AnimalRand = random.nextInt(7);
    public String SelectAnimal ()
    {
        return Animal[AnimalRand];
    }
    /**
     * Select a animal clothes for animal array.
     */
}