package Games.Minesweeper;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
//            subclass          superclass
public class Minesweeper extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    public Minesweeper() {
        initUI();
    }

    private void initUI() {

        JLabel statusBar = new JLabel("");
        add(statusBar, BorderLayout.SOUTH);

        add(new BoardMS(statusBar));

        setResizable(false);
        pack();

        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            Minesweeper ex = new Minesweeper();
            ex.setVisible(true);
        });
    }
}