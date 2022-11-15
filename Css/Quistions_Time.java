import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Quistions_Time  extends JFrame{
    private JPanel quizTime;
    private JButton nextButton;
    private JTextArea dialogArea;
    private int flag=0;
    private int flag2=0;
    Players P = new Players();
    GuessTheImpostor GI;

    public Quistions_Time(JFrame parent){
        super(String.valueOf(parent));
        setTitle("Questions Time");
        setContentPane(quizTime);
        setSize(800, 400);
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
        setVisible(true);
        dialogArea.setText("Its questions time! Tap next to see who starts.");
        nextButton.addActionListener(e -> {
            if (flag>=P.Players_list.size())
            {
                if (flag2<P.Players_list.size())
                {
                    dialogArea.setText(P.Players_list.get(flag2)+" ask a player of your choice");
                    flag2++;
                }
                else
                {
                    setVisible(false);
                    GI = new GuessTheImpostor(null);
                }
            }
            else
            {
                if (flag<P.Players_list.size()-1)
                {
                    dialogArea.setText(P.Players_list.get(flag)+" ask "+P.Players_list.get(flag+1)+" a question about the subject");
                    flag++;
                }
                else if (flag==P.Players_list.size()-1)
                {
                    dialogArea.setText(P.Players_list.get(flag)+" ask "+P.Players_list.get(0)+" a question about the subject");
                    flag++;
                }
            }
        });
    }
}
