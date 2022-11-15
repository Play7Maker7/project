import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinalScore extends JFrame{
    private JButton exitButton;
    private JPanel ScoreTable;
    private JTextArea displayArea;
    private JButton playAgainButton;
    private String secretSubject;
    private String slifaGuess;
    private boolean flag=true;
    private int empty=0;
    Players P = new Players();
    Salifa SA;

    public FinalScore(JFrame parent) {
        super(String.valueOf(parent));
        setTitle("Impostor Guess The Salifa");
        setContentPane(ScoreTable);
        setSize(600, 700);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BufferedReader Salifa;
        {
            try {
                Salifa = new BufferedReader(new FileReader("SecretSubject.txt"));
                secretSubject = Salifa.readLine();
                Salifa.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        BufferedReader impGuess;
        {
            try {
                impGuess = new BufferedReader(new FileReader("SalifaGuess.txt"));
                slifaGuess = impGuess.readLine();
                impGuess.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        BufferedReader players;
        {
            try {
                players = new BufferedReader(new FileReader("AddedPlayers.txt"));
                String nextLine;
                while((nextLine=players.readLine()) != null) {
                    P.addPlayer(nextLine);
                }
                players.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        BufferedReader impostorIncluded;
        {
            try {
                impostorIncluded = new BufferedReader(new FileReader("PlayersWithImpostor.txt"));
                String nextLine;
                while((nextLine=impostorIncluded.readLine()) != null) {
                    P.addCopy(nextLine);
                }
                impostorIncluded.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        BufferedReader guess;
        {
            try {
                guess = new BufferedReader(new FileReader("PlayersWithImpostor.txt"));
                String nextLine;
                while((nextLine=guess.readLine()) != null) {
                    P.addGuess(nextLine);
                }
                guess.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        displayArea.append("Name                                  Score\n");
        for (int i = 0; i < P.Players_list.size(); i++)
        {
            if (P.playersListCopy.get(i).equals("IMPOSTOR!!!"))
            {
                if(impGuess.equals(secretSubject))
                {

                    if (P.impostorIncluded.get(i).equals("IMPOSTOR!!!"))
                    {
                        displayArea.append(P.impostorIncluded.get(i)+"                                                100\n");
                    }
                    else if (!P.impostorIncluded.get(i).equals("IMPOSTOR!!!"))
                    {
                        if (flag==true)
                        {
                            displayArea.append(P.impostorIncluded.get(i)+"                                                0\n");
                            flag = false;
                        }
                        else
                        {
                            empty++;
                        }
                    }
                }
            }
            else
            {
                {
                    if (P.playersGuesses.get(i).equals("IMPOSTOR!!!"))
                    {
                        displayArea.append(P.Players_list.get(i)+"                                                100\n");
                    }
                    else
                    {
                        displayArea.append(P.Players_list.get(i)+"                                                  0\n");
                    }
                }
            }

        }
        setVisible(true);
        playAgainButton.addActionListener(e -> {
            setVisible(false);
            SA = new Salifa(null);
        });
        exitButton.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
    }

    public static void main(String[] args) {
        FinalScore FS = new FinalScore(null);
    }
}