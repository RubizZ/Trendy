package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiConsumer;

public class Transitions {

    private static volatile Queue<Runnable> transitionQueue = new LinkedList<>();

    private static final Thread transitionThread = new Thread(() -> {
        while (true) {
            if (!transitionQueue.isEmpty()) {
                transitionQueue.poll().run();
            }
        }
    });

    static {
        transitionThread.setName("Transition Thread");
        transitionThread.start();
    }

    /**
     * Makes a transition between two components
     *
     * @param from        Component to transition from
     * @param to          Component to transition to
     * @param delay       delay between each step of the transition
     * @param panelSetter params: (Component from, Component to), used to changes panels where the transition is happening
     */
    public static void makeWhiteFadeTransition(Component from, Component to, int delay, BiConsumer<Component, Component> panelSetter) {
        transitionQueue.add(() -> whiteFadeRun(from, to, delay, panelSetter));
    }

    private static void whiteFadeRun(Component from, Component to, int delay, BiConsumer<Component, Component> panelSetter) {
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

        for (int i = 0; i <= 150; i++) {
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

        for (int i = 150; i >= 0; i--) {
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
