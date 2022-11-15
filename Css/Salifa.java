import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Salifa extends JFrame {
    PlayerScreen PS;
    Subjects S = new Subjects();
    private JButton Animals;
    private JButton Anime;
    private JButton Food;
    private JButton Sweets;
    private JButton Cancel;
    private JButton Clothes;
    private JPanel salifaSelection;
    public void writeSecretSubject(String SS)
    {
        try {
            BufferedWriter W = new BufferedWriter(new FileWriter("SecretSubject.txt"));
            W.write(SS);
            W.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void choicesNumber(String Ch)
    {
        try {
            BufferedWriter choose = new BufferedWriter(new FileWriter("Choice.txt"));
            choose.write(Ch);
            choose.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Salifa (JFrame parent)
    {
        super(String.valueOf(parent));
        setTitle("Salifa Selection");
        setContentPane(salifaSelection);
        setSize(450 , 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(parent);
        Animals.addActionListener(e -> {
            writeSecretSubject(S.SelectAnimal());
            choicesNumber("a");
            setVisible(false);
            PS = new PlayerScreen(null);
        });
        Anime.addActionListener(e -> {
            writeSecretSubject(S.SelectAnime());
            choicesNumber("b");
            setVisible(false);
            PS = new PlayerScreen(null);
        });
        Food.addActionListener(e -> {
            writeSecretSubject(S.SelectFood());
            choicesNumber("c");
            setVisible(false);
            PS = new PlayerScreen(null);
        });
        Sweets.addActionListener(e -> {
            writeSecretSubject(S.SelectSweets());
            choicesNumber("d");
            setVisible(false);
            PS = new PlayerScreen(null);
        });
        Clothes.addActionListener(e -> {
            writeSecretSubject(S.SelectCloth());
            choicesNumber("e");
            setVisible(false);
            PS = new PlayerScreen(null);
        });
        Cancel.addActionListener(e -> {
            dispose();
            setVisible(false);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        Salifa Sa = new Salifa(null);
    }

}