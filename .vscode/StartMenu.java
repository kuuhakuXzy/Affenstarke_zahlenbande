import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu extends JFrame {
    public StartMenu() {
        // Create a button to start the game
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to start the game goes here
                System.out.println("Game started");
            }
        });

        // Create a button to exit the game
        JButton exitButton = new JButton("Exit Game");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add the buttons to the frame
        this.setLayout(new FlowLayout());
        this.add(startButton);
        this.add(exitButton);

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}