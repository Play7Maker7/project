import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerScreen extends JFrame{
    private JButton RemovePlayer;
    private JButton addButton;
    private JPanel PlayerConfiguration;
    private JButton displayPlayersButton;
    private JTextArea addedPlayersTextArea;
    private JButton clearDisplayAreaButton;
    private JButton gameStartButton;

    Players P = new Players();

    ImpostorSelection imp;

    public PlayerScreen (JFrame parent) {
        super(String.valueOf(parent));
        setTitle("Add / Remove Players");
        setContentPane(PlayerConfiguration);
        setSize(600, 700);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addButton.addActionListener(e -> {
            String player = JOptionPane.showInputDialog("Player Name: ");
            P.addPlayer(player);
        });
        RemovePlayer.addActionListener(e -> {
            String player = JOptionPane.showInputDialog("Player Name: ");
            P.removePlayer(player);
        });
        setVisible(true);
        displayPlayersButton.addActionListener(e -> {
            addedPlayersTextArea.setText(P.clearDisplay());
            addedPlayersTextArea.setText(P.displayPlayers());
        });
        clearDisplayAreaButton.addActionListener(e -> addedPlayersTextArea.setText(P.clearDisplay()));
        gameStartButton.addActionListener(e -> {

            if(P.Players_list.size()>=2){
                setVisible(false);
                BufferedWriter W;
                {
                    try {
                        W = new BufferedWriter(new FileWriter("AddedPlayers.txt"));
                        W.flush();
                        for (int i = 0; i < P.Players_list.size(); i++)
                        {
                            W.write(P.Players_list.get(i)+"\n");
                            if (i==P.Players_list.size()-1) {
                                W.close();
                            }
                        }
                        W.close();

                    } catch (IOException a) {
                        throw new RuntimeException(a);
                    }
                }
                imp = new ImpostorSelection(null);
            }

            else JOptionPane.showMessageDialog(null , "You need three players at least to start the game.");
        });
    }
}
