package Games.CookieClicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CookieClicker {

    JLabel counterLabel, perSecLabel;
    JButton button1, button2, button3, button4, cursorUpgradeButton, grandpaUpgradeButton, farmUpgradeButton, factoryUpgradeButton;
    int cookieCounter, timerSpeed, cursorNumber, cursorPrice, grandpaNumber, grandpaPrice, farmNumber, farmPrice, factoryNumber, factoryPrice, cursorUpgradePrice, grandpaUpgradePrice, farmUpgradePrice, factoryUpgradePrice;
    double perSecond;
    boolean timerOn, grandpaUnlocked, farmUnlocked, factoryUnlocked, cursorUpgradeUnlocked, cursorUpgradeActive, grandpaUpgradeUnlocked, grandpaUpgradeActive, farmUpgradeUnlocked, farmUpgradeActive, factoryUpgradeUnlocked, factoryUpgradeActive;
    Font font1, font2;
    CookieHandler cHandler = new CookieHandler();
    Timer timer;
    JTextArea messageText;
    MouseHandler mHandler = new MouseHandler();

    public static void main(String[] args) {
        new CookieClicker();
    }

    public CookieClicker() {
        timerOn = false;
        perSecond = 0;
        cookieCounter = 0;
        cursorNumber = 0;
        cursorPrice = 20;
        grandpaNumber = 0;
        grandpaPrice = 100;
        grandpaUnlocked = false;
        farmNumber = 0;
        farmPrice = 1000;
        farmUnlocked = false;
        factoryNumber = 0;
        factoryPrice = 10000;
        factoryUnlocked = false;
        cursorUpgradePrice = 250;
        cursorUpgradeActive = false;
        grandpaUpgradePrice = 2500;
        grandpaUpgradeActive = false;
        farmUpgradePrice = 7500;
        farmUpgradeActive = false;
        factoryUpgradePrice = 50000;
        factoryUpgradeActive = false;

        createFont();
        createUI();
    }

    public void createFont() {
        font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
        font2 = new Font("Comic Sans MS", Font.PLAIN, 15);
    }

    public void createUI() {
        JFrame window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        ImageIcon cookie = new ImageIcon("src/resources/cookie.png");
        ImageIcon cursor = new ImageIcon("src/resources/cursor.jpg");
        ImageIcon grandpa = new ImageIcon("src/resources/grandpa.jpg");
        ImageIcon farm = new ImageIcon("src/resources/farm.jpg");
        ImageIcon factory = new ImageIcon("src/resources/factory.jpg");

        JPanel cookiePanel = new JPanel();
        cookiePanel.setBounds(100,220,200,200);
        cookiePanel.setBackground(Color.black);
        window.add(cookiePanel);

        JButton cookieButton = new JButton();
        cookieButton.setBackground(Color.black);
        cookieButton.setFocusPainted(false);
        cookieButton.setBorder(null);
        cookieButton.setIcon(cookie);
        cookieButton.addActionListener(cHandler);
        cookieButton.setActionCommand("cookie");
        cookiePanel.add(cookieButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100,100,200,100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);



        window.setVisible(true);
    }

    public void setTimer() {
        timer = new Timer(timerSpeed, e -> {

            cookieCounter++;
            counterLabel.setText(cookieCounter + " cookies");


        });
    }

    public void timerUpdate() {
        if(!timerOn) {
            timerOn = true;
        } else {
            timer.stop();
        }

        double speed = 1/perSecond*1000;
        timerSpeed = (int)Math.round(speed);

        String s = String.format("%.1f", perSecond);
        perSecLabel.setText("per second: " + s);

        setTimer();;
        timer.start();
    }

    public class CookieHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String action = event.getActionCommand();
            ImageIcon cursorCheck = new ImageIcon("src/resources/cursorCheck.jpg");
            ImageIcon grandpaCheck = new ImageIcon("src/resources/grandpaCheck.jpg");
            ImageIcon farmCheck = new ImageIcon("src/resources/farmCheck.jpg");
            ImageIcon factoryCheck = new ImageIcon("src/resources/factoryCheck.jpg");

            switch (action) {

            }
        }
    }

    public class MouseHandler implements MouseListener {


        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            JButton button = (JButton)e.getSource();


        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            JButton button = (JButton)e.getSource();


        }
    }
}
