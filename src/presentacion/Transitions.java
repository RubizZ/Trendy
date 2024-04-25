package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;

public class Transitions {

    /**
     * Makes a transition between two components
     *
     * @param from        Component to transition from
     * @param to          Component to transition to
     * @param delay       delay between each step of the transition
     * @param panelSetter params: (Component from, Component to), used to changes panels where the transition is happening
     */
    public static void makeWhiteFadeTransition(Component from, Component to, int delay, BiConsumer<Component, Component> panelSetter) {
        JPanel printPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        printPanel.setOpaque(false);
        printPanel.setLayout(new OverlayLayout(printPanel));
        panelSetter.accept(from, printPanel);

        printPanel.add(from);

        for (int i = 0; i <= 200; i++) {
            printPanel.setBackground(new Color(255, 255, 255, i));
            try {
                Thread.sleep(delay * 2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printPanel.revalidate();
            printPanel.repaint();
        }

        printPanel.remove(from);
        printPanel.add(to);

        for (int i = 200; i >= 0; i--) {
            printPanel.setBackground(new Color(255, 255, 255, i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printPanel.revalidate();
            printPanel.repaint();
        }

        panelSetter.accept(printPanel, to);
    }
}
