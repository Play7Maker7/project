import javax.swing.*;
import java.io.*;

public class ImpostorSelection extends JFrame{
    private JButton nextButton;
    private JTextArea Dialog;
    private JPanel gameStart;

    private boolean flag=false;
    private int next=0;
    private int bound=0;
    private final String secretSubject;
    Players P = new Players();
    Quistions_Time QT;

    public ImpostorSelection (JFrame parent){
        super(String.valueOf(parent));
        setTitle("Impostor selected");
        setContentPane(gameStart);
        setSize(900, 450);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dialog.setText("Tab next to start.");

        BufferedReader R;
        {
            try {
                R = new BufferedReader(new FileReader("SecretSubject.txt"));
                secretSubject = R.readLine();
                R.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
        P.addPlayers();
        P.addPlayer("null");
        BufferedWriter W;
        {
            try {
                W = new BufferedWriter(new FileWriter("PlayersWithImpostor.txt"));
                W.flush();
                for (int i = 0; i < P.impostorIncluded.size(); i++)
                {
                    W.write(P.impostorIncluded.get(i)+"\n");
                    if (i==P.impostorIncluded.size()-1) {
                        W.close();
                    }
                }
                W.close();

            } catch (IOException a) {
                throw new RuntimeException(a);
            }
        }
        nextButton.addActionListener(e -> {
            if (P.Players_list.get(next).equals("null"))
            {
                QT = new Quistions_Time(null);
                setVisible(false);
            }
            else if (bound<P.Players_list.size())
            {
                if (!flag)
                {
                    Dialog.setText(null);
                    Dialog.setText("Only "+ P.Players_list.get(next) +" can see the screen \ntab Next to see if you're in the Salifa or not!");
                    flag = true;
                }
                else {
                    if (P.impostorIncluded.get(next).equals("IMPOSTOR!!!"))
                    {
                        Dialog.setText(null);
                        Dialog.setText("You're the IMPOSTOR! \ntry to know what subject the others are talking about.");
                        flag = false;
                        bound++;
                        next++;
                    }
                    else
                    {
                        Dialog.setText(null);
                        Dialog.setText("You're inside the salifa, and the subject is "+secretSubject+" \ntry to know who is the impostor...");
                        flag = false;
                        bound++;
                        next++;
                    }
                }
            }
        });
        setVisible(true);
    }
}

