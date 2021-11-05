package Games.BattleshipWithGUI;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board {
    final Color MISS = new Color(77, 147, 218, 255);
    final Color OCEAN = new Color(44, 44, 115);
    final Color HIT = new Color(189, 37, 37);
    final Color SHIP = new Color(0, 128, 0);
    final String[] SHIP_NAMES = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
    ActionHandler handler = new ActionHandler();


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

        JPanel playerOneGridPanel = new JPanel();
        playerOneGridPanel.setBounds(0,0,520,500);
        playerOneGridPanel.setBackground(Color.GRAY);
        playerOneGridPanel.setLayout(new GridLayout(11,11));
        playerOneGridPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        fillGrid(playerOneGridPanel);

        window.add(playerOneGridPanel);


        JPanel playerTwoGridPanel = new JPanel();
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

    @NotNull
    private JPanel createShipPanel() {
        JPanel shipPanel = new JPanel();
        shipPanel.setBounds(15,510,490,50);
        shipPanel.setBackground(null);
        shipPanel.setLayout(new BoxLayout(shipPanel,BoxLayout.PAGE_AXIS));
        shipPanel.setBorder(BorderFactory.createTitledBorder("Ships"));

        JPanel shipPanelShips = new JPanel(new FlowLayout(FlowLayout.LEADING));
        shipPanel.add(shipPanelShips);

        ButtonGroup shipsBG = new ButtonGroup();
        JToggleButton[] shipsButton = new JToggleButton[5];
        for (int i = 0; i < 5; i++) {
            shipsButton[i] = new JToggleButton(SHIP_NAMES[i]);
            shipsBG.add(shipsButton[i]);
            shipPanelShips.add(shipsButton[i]);
        }
        return shipPanel;
    }

    private void fillGrid(JPanel panel) {
        panel.add(new JButton());
        for (int i = 1; i <= 10; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }
        for (char c = 'A'; c <= 'J'; c++) {
            panel.add(new JButton(String.valueOf(c)));
            addOcean(panel);
        }
    }

    private void addOcean(JPanel panel) {
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton();
            button.setBackground(OCEAN);
            button.addActionListener(handler);
            button.setActionCommand("OCEAN");
            panel.add(button);

        }
    }


    public class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch (action) {
                case "OCEAN" -> {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(MISS);
                }
            }
        }
    }
}
