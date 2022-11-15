import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImpostorReveal extends JFrame{
    private JButton nextButton;
    private JPanel Reveal;
    private JTextArea Dialog;
    private String impostor;
    Players P = new Players();
    GuessTheSalifa GS;


    public ImpostorReveal(JFrame parent) {
        super(String.valueOf(parent));
        setTitle("Impostor Reveal");
        setContentPane(Reveal);
        setSize(500, 250);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        BufferedReader PR;
        {
            try {
                PR = new BufferedReader(new FileReader("PlayersWithImpostor.txt"));
                String impInclude;
                while((impInclude=PR.readLine()) != null) {
                    P.addPlayer(impInclude);
                }
                PR.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        BufferedReader copy;
        {
            try {
                copy = new BufferedReader(new FileReader("AddedPlayers.txt"));
                String nextPlayer;
                while((nextPlayer=copy.readLine()) != null) {
                    P.addCopy(nextPlayer);
                }
                copy.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        P.addPlayer("null");

        for (int i = 0; i < P.Players_list.size(); i++) {
            if (P.Players_list.get(i).equals("IMPOSTOR!!!"))
            {
                impostor=P.playersListCopy.get(i);
            }
        }
        Dialog.setText(impostor+" is the IMPOSTOR!");
        nextButton.addActionListener(e -> {
            setVisible(false);
            GS = new GuessTheSalifa(null);
        });
    }
}
