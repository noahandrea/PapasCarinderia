/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.foodkiosk;

/**
 *
 * @author pagba
 */

import my.foodkiosk.FoodKioskUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageSlideshow extends JFrame {
    private JLabel label;
    private int currentIndex;
    private ImageIcon[] images;
    
    public ImageSlideshow() {
        super("Image Slideshow");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        //setPreferredSize(new Dimension(500, 500));
        setSize(500, 500);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        // Create an array of ImageIcons
        images = new ImageIcon[3];
        images[0] = new ImageIcon(getClass().getResource("ssadobo.jpg"));
        images[1] = new ImageIcon(getClass().getResource("sssinigang.jpg"));
        images[2] = new ImageIcon(getClass().getResource("sssisig.jpg"));

        // Create a JLabel to display the images
        label = new JLabel(images[0]);
        add(label, BorderLayout.CENTER);

        // Create a Timer to display each image for 3 seconds
        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % images.length;
                label.setIcon(images[currentIndex]);
            }
          });
          timer.start();

        // Create a JButton to go to the main screen of the application
        JButton continueButton = new JButton("Click to Start");
        continueButton.setBackground(new Color(229,83,35));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusPainted(false);
        continueButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        continueButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                // Code to go to the main screen of the application
                new FoodKioskUI().setVisible(true);
                }
              });
              add(continueButton, BorderLayout.SOUTH);

              pack();
              setVisible(true);
    }
}
