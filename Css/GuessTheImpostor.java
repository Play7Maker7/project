import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GuessTheImpostor extends JFrame{
    private JPanel GIT;
    private JTextArea dialogArea;
    private JButton guessButton;
    Players P = new Players();
    private int flag=0;
    ImpostorReveal IR;

    ArrayList<String> guessLog = new ArrayList<>();

    public void impostorLog()
    {
        BufferedWriter W;
        {
            try {
                W = new BufferedWriter(new FileWriter("ImpostorGuessLog.txt"));
                W.flush();
                for (int i = 0; i < guessLog.size(); i++)
                {
                    W.write(guessLog.get(i)+"\n");
                    if (i==guessLog.size()-1) {
                        W.close();
                    }
                }
                W.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void addGuess(String guess)
    {
        guessLog.add(guess);
    }
    public GuessTheImpostor(JFrame parent) {
        super(String.valueOf(parent));
        setTitle("Guess the impostor");
        setContentPane(GIT);
        setSize(600, 700);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BufferedReader PR;
        {
            try {
                PR = new BufferedReader(new FileReader("AddedPlayers.txt"));
                String nextLine;
                while((nextLine=PR.readLine()) != null) {
                    P.addPlayer(nextLine);
                }
                PR.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        dialogArea.setText(P.Players_list.get(flag)+" Can you guess the impostor?");
        setVisible(true);
        guessButton.addActionListener(e -> {
            if (flag<P.Players_list.size())
            {
                String impostor = JOptionPane.showInputDialog("Impostor Name: ");
                addGuess(impostor);
                    flag++;
                    if (flag<P.Players_list.size())
                    {
                        dialogArea.setText(P.Players_list.get(flag)+" Can you guess the impostor?");
                    }
                    else
                    {
                        impostorLog();
                        setVisible(false);
                        IR = new ImpostorReveal(null);
                    }
            }
        });
    }
}
