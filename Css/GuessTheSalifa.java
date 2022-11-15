import javax.swing.*;
import java.io.*;

public class GuessTheSalifa extends JFrame{
    private JButton guessButton;
    private JPanel impostorTurn;
    private JTextArea choicesArea;
    private final String secretSubject;

    FinalScore FS;
    public GuessTheSalifa(JFrame parent) {
        super(String.valueOf(parent));
        setTitle("Impostor Guess The Salifa");
        setContentPane(impostorTurn);
        setSize(600, 700);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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
        BufferedReader CH;
        String salifaCode;
        {
            try {
                CH = new BufferedReader(new FileReader("Choice.txt"));
                salifaCode = CH.readLine();
                CH.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        switch (salifaCode) {
            case "a" -> choicesArea.setText("-Choices:\n-lion\n-cow\n-cat\n-elephant\n-mouse\n-alligator\n-Crow\n-eagle");
            case "b" ->
                    choicesArea.setText("-Choices:\n-Dragonball\n-Attack on titan\n-Naruto\n-One punch man\n-Ousama ranking\n-Chainsaw man\n-Bleach\n-Black clover");
            case "c" -> choicesArea.setText("-Choices:\n-Pasta\n-Pizza\n-Burger\n-Noodles\n-Soup\n-Snacks\n-Meat\n-Chicken");
            case "d" ->
                    choicesArea.setText("-Choices:\n-Abu odi\n-Cake\n-Chocolate\n-Tart\n-Ice cream\n-Vanilla\n-Swiss roll\n-Gum");
            case "e" -> choicesArea.setText("-Choices:\n-Shirt\n-T-Shirt\n-Boots\n-Scarf\n-jeans\n-Pyjama\n-Trouser\n-Jacket");
        }

        guessButton.addActionListener(e -> {
            String guess = JOptionPane.showInputDialog("Your Choice: ");
            try {
                BufferedWriter W = new BufferedWriter(new FileWriter("SalifaGuess.txt"));
                W.flush();
                W.write(guess);
                W.close();
            } catch (IOException a) {
                throw new RuntimeException(a);
            }
            if (guess.equals(secretSubject))
            {
                JOptionPane.showMessageDialog(null, "That's right!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, secretSubject+" is the right answer");
            }
            setVisible(false);
            FS = new FinalScore(null);
        });
    }
}