package gui;

import mainPacket.MainGUI;

import javax.swing.*;
import java.awt.*;

public class GameOverScreenUser extends JPanel {

        public GameOverScreenUser() {
            this.setVisible(true);
            this.setLayout(new BorderLayout(0, 0));
            this.add(createNorthPanel(), BorderLayout.NORTH);
            this.add(createCenterPanel(), BorderLayout.CENTER);
            this.add(createSouthPanel(), BorderLayout.SOUTH);
            this.setBackground(Color.BLACK);
        }

        private JPanel createSouthPanel(){
            JPanel southPanel = new JPanel();
            southPanel.setPreferredSize(new Dimension(200,250));
            southPanel.setLayout(new GridLayout());
            southPanel.setBackground(Color.BLACK);

            JButton button = SpaceFrame.getButton();
            button.addActionListener(e -> {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();
                new MainGUI();
            });
            southPanel.add(button);
            return southPanel;

        }

        private JPanel createNorthPanel(){
            JPanel northPanel = new JPanel();
            northPanel.setPreferredSize(new Dimension(100,250));
            northPanel.setLayout(new GridLayout());
            northPanel.setBackground(Color.BLACK);
            return northPanel;
        }

        private JPanel createCenterPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout());
            panel.setBackground(Color.BLACK);
            JLabel text = SpaceFrame.getText("Congrats! You Won!");
            panel.add(text);


            return panel;
        }


}
