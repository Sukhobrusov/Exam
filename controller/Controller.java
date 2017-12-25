package controller;

import model.*;
import view.View;

public class Controller {
    Model model;
    View view;

    public Controller() {
        model = new Model();
        view = new View(this);

    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }

    public void move(GameObject gameObject, Direction direction){
        model.doARandomMove(gameObject,direction);
    }

    public boolean isGameLost(){
        return model.isGameLost();
    }

    public void restart(){
        model.restart();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}
