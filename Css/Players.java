import java.util.ArrayList;
import java.util.Random;

public class Players {
    Random random = new Random();

    private int X=0;
    private String Y="";

    private int flag=0;

    ArrayList<String> Players_list = new ArrayList<>();
    ArrayList<String> impostorIncluded = new ArrayList<>();
    ArrayList<String> playersGuesses = new ArrayList<>();

    ArrayList<String> playersListCopy = new ArrayList<>();

    private void checkPlayer (String P)
    {
        for (int i = 0; i < Players_list.size(); i++)
        {
            if (P.equals(Players_list.get(i)))
            {
                Players_list.remove(i);
            }
        }
    }
    /**
     * check if the PLayer is already in the Players_list array
     */
    public void addPlayer(String Player)
    {
        checkPlayer(Player);
        Players_list.add(Player);
    }

    /**
     * adds a player to Players_List array
     */
    public void addCopy(String Player)
    {
        playersListCopy.add(Player);
    }
    /**
     * adds a player to playersListCopy array
     */
    public void addGuess(String Player)
    {
        playersGuesses.add(Player);
    }
    /**
     * adds a player to playersGuesses array
     */
    public void removePlayer(String Player)
    {
        for (int i = 0; i < Players_list.size(); i++) {
            if(Player.equals(Players_list.get(i)))
            {
                Players_list.remove(i);
            }
        }
    }
    /**
     * removes a player from Players_list array
     */
    public int impostorPlayer ()
    {
        int bound;
        bound =Players_list.size()-2;
        return random.nextInt(bound);
    }
    /**
     *  selects a random player from Players_list array to be the impostor
     */

    public String displayPlayers ()
    {
        for (String s : Players_list) {
            Y += s + "\n";
        }

        return Y;
    }
    /**
     *  shows all the Players in the Player_List array
     */
    public String clearDisplay()
    {
        Y= "";
        return Y;
    }
    /**
     *  shows null instead of all the Players in the Player_List array
     */
    public boolean checkImpostor()
    {
        boolean B=false;
        for (String s : impostorIncluded) {
            if (s.equals("IMPOSTOR!!!")) {
                flag++;
            }
        }
            if (flag==1) B=true;
            else
            {
                B=false;
            }
        flag=0;
            return B;
    }
    /**
     *  checks if the impostor is duplicated or not
     */
    public void nextPlayer()
    {
        String n = Players_list.get(X);
        X++;
        if (!checkImpostor())
        {
            for (int i = 0; i < Players_list.size(); i++) {
                if (i==impostorPlayer()){
                    if (n.equals(Players_list.get(i)))
                    {
                        n ="IMPOSTOR!!!";
                    }
                }
            }
        }
        impostorIncluded.add(n);
    }
    /**
     * adds a player to Players_List array including a random impostor
     */
    public void addPlayers()
    {
        for (int i = 0; i < Players_list.size(); i++) {
            nextPlayer();
        }
    }
    /**
     * adds all players to Players_List array including a random impostor
     */
}