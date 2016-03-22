package package1.game;

import package1.game.Game;
import package1.game.entity.Entity;
import package1.game.gameUtil.Movement;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Iterator;
import java.util.Vector;

/**********************************************************************
 * GUI class for the asteroid sets up the JPanel and JFrame for the
 * asteroid game and calls on player and asteroid to instantiate the
 * new objects.
 * Created by tyleranson on 2/15/16.
 *********************************************************************/
public class GUI extends JPanel implements ActionListener{
    private Game game;
    /**
     * The size of the world
     */
    public static final int WORLD_SIZE = 600;

    private JPanel gameContainer;
    private CardLayout screens;
    Vector position = new Vector();

    private JFrame gameFrame;

    /** Menu Bar Object **/
    private JMenuBar menuBar;
    private JMenu File;
    private JMenuItem restart, exit;

    // Title Screen
    private JPanel titleScreen;
    private JLabel astroyd;
    private JButton startB,optionB,exitB;

    // Start Screen
    private JPanel startScreen;
    private JButton modeB,backB;

    // Mode Select
    private JPanel modeScreen;
    private JButton timeAttackB,survivalB,insaneB;

    // Time Attack Screen
    private JPanel timeAttackScreen;

    // Dimension of Buttons
    private final Dimension D = new Dimension(200,100);

    /******************************************************************
     * GUI constructor (default)  instantiates a new asteroid and a
     * player
     *****************************************************************
     * @param game*/
    public GUI(Game game) {
        //Player s = new Player();
        //Asteroid a = new Asteroid();
        this.game = game;

        setPreferredSize(new Dimension(WORLD_SIZE, WORLD_SIZE));
        setBackground(Color.GRAY);

        // Initialize Main Screen
        screens = new CardLayout();
        gameContainer = new JPanel();


//        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gameFrame.setVisible(true);
//        gameFrame.setTitle("ASTROYED!");

    }

    public void buttons(){

//        Insets r = new Insets(40,50,60,70);

        //title screen buttons
        startB = new JButton("START");
        startB.addActionListener(this);
        startB.setPreferredSize(D);
        startB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        startB.setBackground(Color.red);
        startB.setFocusPainted(false);
        startB.setForeground(Color.blue);
        startB.setFocusable(true);
        startB.setContentAreaFilled(true);
//        startButton.setMargin(r);


        optionB = new JButton("OPTIONS");
        optionB.addActionListener(this);
        optionB.setPreferredSize(D);
        optionB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        optionB.setBackground(Color.red);
        optionB.setFocusPainted(true);
        optionB.setForeground(Color.blue);
        optionB.setFocusable(true);

        exitB = new JButton("EXIT");
        exitB.addActionListener(this);
        exitB.setPreferredSize(D);
        exitB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        exitB.setBackground(Color.red);
        exitB.setFocusPainted(true);
        exitB.setForeground(Color.blue);
        exitB.setFocusable(true);

        //start screen buttons
        modeB = new JButton("MODE");
        modeB.addActionListener(this);
        modeB.setPreferredSize(D);
        modeB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        modeB.setBackground(Color.red);
        modeB.setFocusPainted(true);
        modeB.setForeground(Color.blue);
        modeB.setFocusable(true);

        backB = new JButton("BACK");
        backB.addActionListener(this);
        backB.setPreferredSize(D);
        backB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        backB.setBackground(Color.red);
        backB.setFocusPainted(true);
        backB.setForeground(Color.blue);
        backB.setFocusable(true);

        //mode screen buttons
        timeAttackB = new JButton("TIME ATTACK");
        timeAttackB.addActionListener(this);
        timeAttackB.setPreferredSize(D);
        timeAttackB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        timeAttackB.setBackground(Color.red);
        timeAttackB.setFocusPainted(true);
        timeAttackB.setForeground(Color.blue);
        timeAttackB.setFocusable(true);

        survivalB = new JButton("SURVIVAL");
        survivalB.addActionListener(this);
        survivalB.setPreferredSize(D);
        survivalB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        survivalB.setBackground(Color.red);
        survivalB.setFocusPainted(true);
        survivalB.setForeground(Color.blue);
        survivalB.setFocusable(true);

        insaneB = new JButton("INSANE-O");
        insaneB.addActionListener(this);
        insaneB.setPreferredSize(D);
        insaneB.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        insaneB.setBackground(Color.red);
        insaneB.setFocusPainted(true);
        insaneB.setForeground(Color.blue);
        insaneB.setFocusable(true);
    }

    public void screenViews(){

        //GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 20;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.weighty = 1;
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridy = 50;
        gbc1.gridx = 0;
        gbc1.anchor = GridBagConstraints.CENTER;
//        gbc1.weighty = 1;
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridy = 80;
        gbc2.gridx = 0;
        gbc2.anchor = GridBagConstraints.CENTER;
//        gbc2.weighty = 1;
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.anchor = GridBagConstraints.NORTH;
//        gbc3.gridx = 0;
//        gbc3.gridx = 0;
//        gbc3.weighty = 0;



        //title screen view
        titleScreen = new JPanel(new GridBagLayout());
        titleScreen.setBackground(Color.black);

        astroyd  = new JLabel();
        astroyd.setText("ASTROYED");
        astroyd.setFont(new Font("Serif", 5 , 60));
        astroyd.setSize(200,200);
        astroyd.setForeground(Color.red);

        titleScreen.add(astroyd);
        titleScreen.add(startB, gbc);
        titleScreen.add(optionB, gbc1);
        titleScreen.add(exitB, gbc2);


        //start screen view
        startScreen = new JPanel(new GridBagLayout());
        startScreen.setBackground(Color.black);
        startScreen.add(modeB, gbc);
        startScreen.add(backB, gbc1);

        //mode screen view
        modeScreen = new JPanel(new GridBagLayout());
        modeScreen.setBackground(Color.BLACK);
        modeScreen.add(timeAttackB, gbc);
        modeScreen.add(survivalB, gbc1);
        modeScreen.add(insaneB, gbc2);

        //time attack screen view
        timeAttackScreen = new JPanel(new BorderLayout());
//        Player s = new Player();
//        Asteroid a = new Asteroid();
//        Entity e = new Entity() {
//            @Override
//            public void handleCollision(Game game, Entity other) {
//
//            }
//
//            @Override
//            public void draw(Graphics2D g, Game game) {
//
//            }
//        };
//        timeAttackScreen.add(a);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK); //Set the draw color to white.

        AffineTransform identity = g2d.getTransform();

        Iterator<Entity> iter = game.getEntities().iterator();
        while(iter.hasNext()) {
            Entity entity = iter.next();

            Movement position = entity.getPosition();

            drawEntity(g2d, entity, position.x, position.y);

            g2d.setTransform(identity);
        }
    }
//    /******************************************************************
//    Add any GUI options to be built in setupGUI (buttons,menus,othe panels)
//     *****************************************************************/
//    public void setupGUI(){
//        File = new JMenu("File");
//        menuBar = new JMenuBar();
//        restart = new JMenuItem("Restart");
//        exit = new JMenuItem("Exit");
//        restart.addActionListener(this);
//        exit.addActionListener(this);
//
//        menuBar.add(File);
//        File.add(restart);
//        File.add(exit);
//    }
//
//    /******************************************************************
//     *
//     * @param e
//     *****************************************************************/
//    public void actionPerformed(ActionEvent e){
//        if(exit == e.getSource()){
//            System.exit(0);
//        }
//    }


    private void drawEntity(Graphics2D g2d, Entity entity, double x, double y) {
        g2d.translate(x, y);
        double rotation = entity.getRotation();
        if(rotation != 0.0f) {
            g2d.rotate(entity.getRotation());
        }
        entity.draw(g2d, game);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clickTarget = e.getSource();

        if(exit == clickTarget){
            System.exit(0);
        }
        if(startB == clickTarget){
            screens.show(gameContainer, "start");
        }
        if(exitB == clickTarget){
            System.exit(0);
        }
        if(modeB == clickTarget){
            screens.show(gameContainer, "mode");
        }
        if(backB == clickTarget){
            screens.show(gameContainer, "title");
        }
        if(timeAttackB == clickTarget){
            screens.show(gameContainer, "time");
        }
        if(restart == clickTarget){
            screens.show(gameContainer, "title");
        }
    }
}


