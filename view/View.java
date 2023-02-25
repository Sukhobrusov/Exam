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
            Direction direction;
            switch (e.getKeyCode()){
                case KeyEvent.VK_Q:
                    direction = Direction.LEFT_UP;
                    break;
                case KeyEvent.VK_W: direction = Direction.UP;
                    break;
                case KeyEvent.VK_E: direction = Direction.RIGHT_UP;
                    break;
                case KeyEvent.VK_Z: direction = Direction.LEFT_DOWN;
                    break;
                case KeyEvent.VK_X: direction = Direction.DOWN;
                    break;
                case KeyEvent.VK_C: direction = Direction.RIGHT_DOWN;
                    break;
                case KeyEvent.VK_P: direction = Direction.values()[ThreadLocalRandom.current().nextInt(6);
                    break;
                case KeyEvent.VK_Y:
                    controller.restart();
                    update();
                    return;
            }
            if (direction == null) {
                System.out.println("direction is null, press another button"); //logger preff
                return;
            }
            Function isAllowed = new Function<Boolean, GameObject>() {
                // might need to replace this with Boolean (capital letter B)
                @Override
                public boolean apply(GameObject testSubject) {
                    return testSubject instanceof Capucin ||
                            testSubject instanceof Baboon;
                }
            };
                                                                   
                                                                  
            for(GameObject animal : controller.getGameObjects().getGameObjects().keySet()) {
                if(isAllowed.apply(animal))
                    controller.move(animal, direction);
            }

        }
    }
}
