import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissors extends JFrame {

    private JLabel resultLabel;
    private Random random = new Random();

    private final String[] choices = {"Rock", "Paper", "Scissors"};

    public RockPaperScissors() {
        setTitle("Rock Paper Scissors");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Label hasil
        resultLabel = new JLabel("Choose your move!", SwingConstants.CENTER);
        add(resultLabel, BorderLayout.CENTER);

        // Panel tombol
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        panel.add(createButton("Rock"));
        panel.add(createButton("Paper"));
        panel.add(createButton("Scissors"));

        add(panel, BorderLayout.SOUTH);
    }

    private JButton createButton(String choice) {
        JButton button = new JButton(choice);
        button.addActionListener((ActionEvent e) -> play(choice));
        return button;
    }

    private void play(String userChoice) {
        String computerChoice = choices[random.nextInt(3)];

        String result;
        if (userChoice.equals(computerChoice)) {
            result = "Draw!";
        } else if (
                (userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            result = "You Win!";
        } else {
            result = "You Lose!";
        }

        resultLabel.setText("You: " + userChoice + " | Computer: " + computerChoice + " → " + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RockPaperScissors().setVisible(true);
        });
    }
}