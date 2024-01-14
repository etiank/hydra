import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        int count = 2;
        JFrame frame = new JFrame("HYDRA");
        ImageIcon icon = new ImageIcon("hydra.png");
        frame.setIconImage(icon.getImage());
        frame.setSize(285, 120);

        JLabel label = new JLabel("     Cut off a head, two more will take its place.");
        JButton button = new JButton("Ok");
        JButton button2 = new JButton("Close");
        JPanel panel = new JPanel();

        /*BufferedImage image = null;
        try {
            image = ImageIO.read(new File("hydra.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel imagePreview = new JLabel(new ImageIcon(image));
        panel.add(imagePreview);
        */
        // Set layout manager to BorderLayout
        frame.setLayout(new BorderLayout());

        // Add label to the frame at the top
        frame.add(label, BorderLayout.NORTH);

        panel.add(button);
        panel.add(button2);

        frame.add(panel, BorderLayout.CENTER);

        Random rand = new Random();
        int x = rand.nextInt(800);
        int y = rand.nextInt(600);
        frame.setLocation(x, y);
        frame.setVisible(true);
        UIManager.put("swing.boldMetal", Boolean.FALSE);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAndShowGUI();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createAndShowGUI();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                createAndShowGUI();
                createAndShowGUI();
                createAndShowGUI();

            }
        });

    }
}
