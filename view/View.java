package view;

import controller.Controller;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

public class View extends JPanel {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        init();
    }

    public void init() {
        JFrame frame = new JFrame();
        frame.getContentPane().add(this);

        frame.addKeyListener(new KeyHandler());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }


    public void update(){
        repaint();
        if(controller.isGameLost())
            JOptionPane.showMessageDialog(this,"Baboon is around one of your Capucins","Info",JOptionPane.INFORMATION_MESSAGE);
    }

    public void paintComponent(Graphics g) {
        GameObjects gameObjects = controller.getGameObjects();

        for(GameObject gameObject : gameObjects.getGameObjects().keySet()){
            gameObject.draw(g);
        }
    }


    public GameObjects getGameObjects(){
        return controller.getGameObjects();
    }


    /**
     * КЛАВИШИ -
     * Q - Двинуться всем объектам влемо вверх
     * W - Всем вверх
     * E - Всем вправо вверх
     * Y - Перезагрузить уровень
     * Z - Всем влево вниз
     * X - Всем вниз
     * C - Всем вправо вниз
     * P - Ход в случайном напрвлении всех существ
     */
    public class KeyHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_Q:
                    for(GameObject gameObject : controller.getGameObjects().getGameObjects().keySet()){
                        if(gameObject instanceof Capucin||gameObject instanceof Baboon)
                            controller.move(gameObject, Direction.LEFT_UP);
                    }
                    update();
                    break;
                case KeyEvent.VK_W:
                    for(GameObject gameObject : controller.getGameObjects().getGameObjects().keySet()){
                        if(gameObject instanceof Capucin||gameObject instanceof Baboon)
                            controller.move(gameObject, Direction.UP);
                    }
                    update();
                    break;
                case KeyEvent.VK_E:
                    for(GameObject gameObject : controller.getGameObjects().getGameObjects().keySet()){
                        if(gameObject instanceof Capucin||gameObject instanceof Baboon)
                            controller.move(gameObject, Direction.RIGHT_UP);
                    }
                    update();
                    break;
                case KeyEvent.VK_Z:
                    for(GameObject gameObject : controller.getGameObjects().getGameObjects().keySet()){
                        if(gameObject instanceof Capucin||gameObject instanceof Baboon)
                            controller.move(gameObject, Direction.LEFT_DOWN);
                    }
                    update();
                    break;
                case KeyEvent.VK_X:
                    for(GameObject gameObject : controller.getGameObjects().getGameObjects().keySet()){
                        if(gameObject instanceof Capucin||gameObject instanceof Baboon)
                            controller.move(gameObject, Direction.DOWN);
                    }
                    update();
                    break;
                case KeyEvent.VK_C:
                    for(GameObject gameObject : controller.getGameObjects().getGameObjects().keySet()){
                        if(gameObject instanceof Capucin||gameObject instanceof Baboon)
                            controller.move(gameObject, Direction.RIGHT_DOWN);
                    }
                    update();
                    break;
                case KeyEvent.VK_P:
                    for(GameObject gameObject : controller.getGameObjects().getGameObjects().keySet()){
                        if(gameObject instanceof Capucin||gameObject instanceof Baboon)
                            controller.move(gameObject, Direction.values()[ThreadLocalRandom.current().nextInt(6)]);
                    }
                    update();
                    break;

                case KeyEvent.VK_Y:
                    controller.restart();
                    update();
                    break;
            }
        }
    }
}
