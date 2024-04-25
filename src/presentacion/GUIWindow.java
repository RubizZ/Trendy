package presentacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GUIWindow extends JFrame {

    private final SAFacade saFachade;

    private Thread introAnimationThread;

    private JPanel mainPanel;

    private JPanel controlPanel;

    private JButton lastPressedButton;
    private JPanel lastPanel;

    private JButton homeButton;
    private JButton searchButton;
    private JButton cestaButton;
    private JButton userButton;

    //TODO Hacer un patron que junte todo esto
    private GoBackPanel homePanel;
    private GoBackPanel searchPanel;
    private GoBackPanel cestaPanel;
    private GoBackPanel userPanel;
    private JDialog authDialog;

    public GUIWindow(SAFacade saFachade) {
        this.saFachade = saFachade;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

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

        controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)
        homeButton = new JButton("Home");
        homeButton.addActionListener(e -> {
            if (homeButton == lastPressedButton) {
                homePanel.reset();
            } else {
                lastPressedButton = homeButton;
                mainPanel.remove(lastPanel);
                lastPanel = homePanel;
                mainPanel.add(homePanel, BorderLayout.CENTER); //TODO Revisar si hay que eliminar el panel anterior
                mainPanel.revalidate();
                mainPanel.repaint();
            }

        });
        controlPanel.add(homeButton);
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            if (searchButton == lastPressedButton) {
                searchPanel.reset();
            } else {
                lastPressedButton = searchButton;
                mainPanel.remove(lastPanel);
                lastPanel = searchPanel;
                mainPanel.add(searchPanel, BorderLayout.CENTER); //TODO Revisar si hay que eliminar el panel anterior
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        controlPanel.add(searchButton);
        cestaButton = new JButton("Cesta");
        cestaButton.addActionListener(e -> {
            if (cestaButton == lastPressedButton) {
                cestaPanel.reset();
            } else {
                lastPressedButton = cestaButton;
                mainPanel.remove(lastPanel);
                lastPanel = cestaPanel;
                mainPanel.add(cestaPanel, BorderLayout.CENTER); //TODO Revisar si hay que eliminar el panel anterior
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        controlPanel.add(cestaButton);
        userButton = new JButton("User");
        userButton.addActionListener(e -> {
            if (!saFachade.isLogged()) {
                authDialog.open(this);
            } else {
                if (userButton == lastPressedButton) {
                    userPanel.reset();
                } else {
                    lastPressedButton = userButton;
                    mainPanel.remove(lastPanel);
                    lastPanel = userPanel;
                    mainPanel.add(userPanel, BorderLayout.CENTER); //TODO Revisar si hay que eliminar el panel anterior
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            }
        });
        controlPanel.add(userButton);

        homePanel = new HomePanel(saFachade);
        userPanel = new GUIPerfil(saFachade);
        cestaPanel = new GUICesta(saFachade);
        searchPanel = new GUIPpalCategorias(saFachade);
        authDialog = new GUILogin(saFachade);

        lastPressedButton = homeButton;

        mainPanel.add(homePanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
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
