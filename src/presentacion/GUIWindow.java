package presentacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GUIWindow extends JFrame {

    private final SAFacade saFachade;

    private Thread introAnimationThread;

    private JPanel mainPanel;

    private JPanel controlPanel;

    //TODO Hacer un patron que junte todo esto
    private JPanel userPanel;
    private JPanel cestaPanel;
    private JPanel busquedaPanel;

    public GUIWindow(SAFacade saFachade) {
        this.saFachade = saFachade;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        playIntroAnimation();
        initPanels();
        waitForAnimation();
    }

    private void playIntroAnimation() {
        try {
            Random random = new Random();
            int loadingTimeMs = random.nextInt(1000, 3000);

            File img = new File("resources/imgs/trendy_logo.png");
            BufferedImage imgBuffered = ImageIO.read(img);
            ImageAnimation introAnimation = new ImageAnimation(imgBuffered, loadingTimeMs, 1.5);

            introAnimationThread = new Thread(introAnimation::play);

            setContentPane(introAnimation);
            pack();
            setLocationRelativeToMouseAndSetSize();
            setVisible(true);

            try {
                Thread.sleep(random.nextLong(500, 1000));
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "Error al cargar Trendy", JOptionPane.ERROR_MESSAGE);
            }

            introAnimationThread.start();

            Timer animationTimer = new Timer(loadingTimeMs, e -> introAnimation.stop());
            animationTimer.setRepeats(false);
            animationTimer.start();
        } catch (IOException ignored) {

        }
    }

    private void initPanels() {
        mainPanel = new JPanel(new BorderLayout());
        //TODO
    }

    private void waitForAnimation() {
        if (introAnimationThread != null) {
            try {
                introAnimationThread.join();
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "Error al cargar Trendy", JOptionPane.ERROR_MESSAGE);
            }
        }

        setContentPane(mainPanel);
        pack();
    }

    private void setLocationRelativeToMouseAndSetSize() {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point point = pointerInfo.getLocation();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        for (GraphicsDevice g : gs) {
            GraphicsConfiguration[] gc = g.getConfigurations();
            for (GraphicsConfiguration c : gc) {
                Rectangle bounds = c.getBounds();
                if (bounds.contains(point)) {
                    if (bounds.getWidth() > bounds.getHeight()) {
                        //distancia proporcional en ambos ejes segun el eje menor
                        //this.setSize((int) ((bounds.getHeight() * 0.75 / (bounds.getHeight())) * bounds.getWidth()), (int) (bounds.getHeight() * 0.75));

                        //distancia igual en ambos ejes segun el eje menor
                        this.setSize((int) (bounds.getHeight() * 0.75), (int) (bounds.getHeight() * 0.75));
                    } else {
                        //distancia proporcional en ambos ejes segun el eje menor
                        //this.setSize((int) (bounds.getWidth() * 0.75), (int) ((bounds.getWidth() * 0.75 / (bounds.getWidth())) * bounds.getHeight()));

                        //distancia igual en ambos ejes segun el eje menor
                        this.setSize((int) (bounds.getWidth() * 0.75), (int) (bounds.getWidth() * 0.75));
                    }
                    int x = (int) (bounds.getX() + (bounds.getWidth() - this.getWidth()) / 2);
                    int y = (int) (bounds.getY() + (bounds.getHeight() - this.getHeight()) / 2);
                    this.setLocation(x, y);
                    return;
                }
            }
        }
    }
}
