package Games.BattleshipWithGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame implements ActionListener{
    final Color MISS = new Color(77, 147, 218, 255);
    final Color OCEAN = new Color(44, 44, 115);
    final Color HIT = new Color(189, 37, 37);
    final Color SHIP = new Color(0, 128, 0);
    final String[] SHIP_NAMES = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
    public JButton[][] buttonGrid = new JButton[10][10];
    boolean horizontal = false;
    boolean vertical = false;
    char currentShip = ' ';
    public JPanel playerOneGridPanel;
    public JPanel playerTwoGridPanel;


    public static void main(String[] args) {
        new Board();
    }

    public Board() {
        createUI();
    }

    private void createUI() {
        JFrame window = new JFrame();
        window.setSize(1155,625);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.WHITE);
        window.setLayout(null);

        playerOneGridPanel = new JPanel();
        playerOneGridPanel.setBounds(0,0,520,500);
        playerOneGridPanel.setBackground(Color.GRAY);
        playerOneGridPanel.setLayout(new GridLayout(11,11));
        playerOneGridPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        fillGrid(playerOneGridPanel);

        window.add(playerOneGridPanel);


        playerTwoGridPanel = new JPanel();
        playerTwoGridPanel.setBounds(620,0,520,500);
        playerTwoGridPanel.setBackground(Color.GRAY);
        playerTwoGridPanel.setLayout(new GridLayout(11,11));
        playerTwoGridPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        fillGrid(playerTwoGridPanel);

        window.add(playerTwoGridPanel);


        JPanel shipPanel = createShipPanel();

        window.add(shipPanel);

        window.setVisible(true);
    }

    private JPanel createShipPanel() {
        JPanel shipPanel = new JPanel();
        shipPanel.setBounds(15,510,490,50);
        shipPanel.setBackground(null);
        shipPanel.setLayout(new BoxLayout(shipPanel,BoxLayout.PAGE_AXIS));
        shipPanel.setBorder(BorderFactory.createTitledBorder("Ships"));

        JPanel shipsTogglePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        shipPanel.add(shipsTogglePanel);

        ButtonGroup shipsBG = new ButtonGroup();
        JToggleButton[] shipsButton = new JToggleButton[5];
        for (int i = 0; i < 5; i++) {
            shipsButton[i] = new JToggleButton(SHIP_NAMES[i]);
            shipsButton[i].addActionListener(this);
            shipsButton[i].setActionCommand("SHIP");
            shipsBG.add(shipsButton[i]);
            shipsTogglePanel.add(shipsButton[i]);
        }
        return shipPanel;
    }

    private void fillGrid(JPanel panel) {
        panel.add(new JButton("_"));
        for (int i = 1; i <= 10; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
        for (char c = 'A'; c <= 'J'; c++) {
            panel.add(new JButton(String.valueOf(c)));
            addOcean(panel);
        }
        addOceanToGrid();
    }

    private void addOcean(JPanel panel) {
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton();
            button.setBackground(OCEAN);
            button.addActionListener(this);
            button.setActionCommand("OCEAN");
            panel.add(button);
        }
    }

    private void addOceanToGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton button = new JButton();
                button.setBackground(OCEAN);
                button.addActionListener(this);
                button.setActionCommand("OCEAN");
                buttonGrid[i][j] = button;
            }

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        String[] options = {"Vertical", "Horizontal"};
        char[] shipsArray = {'C', 'B', 'D', 'S', 'P'};


        switch (action) {
            case "OCEAN" -> {
                JButton jButton = (JButton) e.getSource();

//                jButton.setBackground(MISS);
                int x = jButton.getX(); //starts at 48 then +47 up to 471
                int y = jButton.getY(); //starts at 47 the +45 up to 452
                if (currentShip == 'C') {
                    if (vertical) {
                        if (
                                y+(45*4) > 452 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+45).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+(45*2)).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+(45*3)).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+(45*4)).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+45).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+(45*2)).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+(45*3)).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+(45*4)).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    } else if (horizontal) {
                        if (
                                x+(47*4) > 471 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+47,y).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+(47*2),y).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+(47*3),y).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+(47*4),y).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+47,y).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+(47*2),y).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+(47*3),y).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+(47*4),y).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    }
                }
                else if (currentShip == 'B') {
                    if (vertical) {
                        if (
                                y+(45*3) > 452 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+45).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+(45*2)).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+(45*3)).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+45).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+(45*2)).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+(45*3)).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    } else if (horizontal) {
                        if (
                                x+(47*3) > 471 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+47,y).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+(47*2),y).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+(47*3),y).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+47,y).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+(47*2),y).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+(47*3),y).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    }
                }
                else if (currentShip == 'D') {
                    if (vertical) {
                        if (
                                y+(45*2) > 452 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+45).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+(45*2)).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+45).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+(45*2)).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    } else if (horizontal) {
                        if (
                                x+(47*2) > 471 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+47,y).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+(47*2),y).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+47,y).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+(47*2),y).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    }
                }
                else if (currentShip == 'S') {
                    if (vertical) {
                        if (
                                y+(45*2) > 452 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+45).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+(45*2)).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+45).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+(45*2)).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    } else if (horizontal) {
                        if (
                                x+(47*2) > 471 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+47,y).getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+(47*2),y).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+47,y).setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+(47*2),y).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    }
                }
                else if (currentShip == 'P') {
                    if (vertical) {
                        if (
                                y+45 > 452 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x,y+45).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x,y+45).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    } else if (horizontal) {
                        if (
                                x+47 > 471 ||
                                jButton.getBackground() == SHIP ||
                                playerOneGridPanel.getComponentAt(x+47,y).getBackground() == SHIP
                        ) {
                            //don't place ship
                        } else {
                            jButton.setBackground(SHIP);
                            playerOneGridPanel.getComponentAt(x+47,y).setBackground(SHIP);
                            currentShip = ' ';
                        }
                    }
                }
            }
            case "SHIP" -> {
                JToggleButton jToggleButton = (JToggleButton) e.getSource();
                if (jToggleButton.getText().equalsIgnoreCase("Carrier")) {
                    int n = JOptionPane.showOptionDialog(new JFrame(),"Do you want this ship to be placed horizontally or vertically?","Placement",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (n == 0) {
                        horizontal = false;
                        vertical = true;
                    } else {
                        vertical = false;
                        horizontal = true;
                    }
                    currentShip = shipsArray[0];
                    jToggleButton.setEnabled(false);
                }
                else if (jToggleButton.getText().equalsIgnoreCase("Battleship")) {
                    int n = JOptionPane.showOptionDialog(new JFrame(),"Do you want this ship to be placed horizontally or vertically?","Placement",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (n == 0) {
                        horizontal = false;
                        vertical = true;
                    } else {
                        vertical = false;
                        horizontal = true;
                    }
                    currentShip = shipsArray[1];
                    jToggleButton.setEnabled(false);
                }
                else if (jToggleButton.getText().equalsIgnoreCase("Destroyer")) {
                    int n = JOptionPane.showOptionDialog(new JFrame(),"Do you want this ship to be placed horizontally or vertically?","Placement",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (n == 0) {
                        horizontal = false;
                        vertical = true;
                    } else {
                        vertical = false;
                        horizontal = true;
                    }
                    currentShip = shipsArray[2];
                    jToggleButton.setEnabled(false);
                }
                else if (jToggleButton.getText().equalsIgnoreCase("Submarine")) {
                    int n = JOptionPane.showOptionDialog(new JFrame(),"Do you want this ship to be placed horizontally or vertically?","Placement",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (n == 0) {
                        horizontal = false;
                        vertical = true;
                    } else {
                        vertical = false;
                        horizontal = true;
                    }
                    currentShip = shipsArray[3];
                    jToggleButton.setEnabled(false);
                }
                else if (jToggleButton.getText().equalsIgnoreCase("Patrol Boat")) {
                    int n = JOptionPane.showOptionDialog(new JFrame(),"Do you want this ship to be placed horizontally or vertically?","Placement",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (n == 0) {
                        horizontal = false;
                        vertical = true;
                    } else {
                        vertical = false;
                        horizontal = true;
                    }
                    currentShip = shipsArray[4];
                    jToggleButton.setEnabled(false);
                }
            }
        }
    }
}
