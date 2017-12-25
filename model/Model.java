package model;

import java.awt.*;

public class Model {

    private LevelLoader levelLoader = new LevelLoader();
    private GameObjects gameObjects = levelLoader.getLevel();
    private boolean isGameLost = false;

    public GameObjects getGameObjects() {
        return gameObjects;
    }
    
    public void setGameLost(boolest flag){
        isGameLost = flag;
    }

    public void doARandomMove(GameObject gameObject, Direction direction) {
        if (canMove(gameObject, direction)) {
            int xy = gameObjects.getGameObjectsCoordinates(gameObject);
            int x = xy / 10;
            int y = xy % 10;
            boolean oddX = x % 2 == 0;
            GameObject testGameObject;

            switch (direction) {
                case UP:
                    if ((testGameObject = gameObjects.getGameObjectByCoordinates(x * 10 + (y - 1))) instanceof EmptyBoard) {
                        switchPolygons(gameObject, testGameObject);
                        gameObjects.switchCoordinates(gameObject, testGameObject);
                    }
                    break;
                case DOWN:
                    if ((testGameObject = gameObjects.getGameObjectByCoordinates(x * 10 + (y + 1))) instanceof EmptyBoard) {
                        switchPolygons(gameObject, testGameObject);
                        gameObjects.switchCoordinates(gameObject, testGameObject);
                    }
                    break;
                case LEFT_DOWN:
                    if (oddX) {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x - 1) * 10 + (y + 1))) instanceof EmptyBoard) {
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject, testGameObject);
                        }
                    } else {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x - 1) * 10 + y)) instanceof EmptyBoard){
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject,testGameObject);
                        }
                    }
                    break;
                case LEFT_UP:
                    if (oddX) {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x - 1) * 10 + y)) instanceof EmptyBoard) {
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject,testGameObject);
                        }
                    } else {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x - 1) * 10 + y - 1)) instanceof EmptyBoard) {
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject, testGameObject);
                        }
                    }
                    break;
                case RIGHT_UP:
                    if (oddX) {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x + 1) * 10 + y)) instanceof EmptyBoard) {
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject, testGameObject);
                        }
                    } else {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x + 1) * 10 + y - 1)) instanceof EmptyBoard){
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject,testGameObject);
                        }
                    }
                    break;
                case RIGHT_DOWN:
                    if (oddX) {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x + 1) * 10 + y + 1)) instanceof EmptyBoard){
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject,testGameObject);
                        }
                    } else {
                        if ((testGameObject = gameObjects.getGameObjectByCoordinates((x + 1) * 10 + y)) instanceof EmptyBoard){
                            switchPolygons(gameObject, testGameObject);
                            gameObjects.switchCoordinates(gameObject,testGameObject);
                        }
                    }
                    break;
            }
        }
    }

    public void switchPolygons(GameObject gameObject, GameObject testGameObject) {
        Polygon p = testGameObject.getPolygon();
        testGameObject.setPolygon(gameObject.getPolygon());
        gameObject.setPolygon(p);
    }


    // Может ли объект двинуться в выбранном направлении
    public boolean canMove(GameObject gameObject, Direction direction) {
        if(isEnemyAround(gameObject))
            return false;
        int xy = gameObjects.getGameObjectsCoordinates(gameObject);
        int x = xy / 10;
        int y = xy % 10;
        int[] UP_ = {x,y-1};
        int[] DOWN_ = {x,y+1};
        int[] LEFTUP = {x-1,y};
        int[] LEFTDOWN = {x-1,y+1};
        int[] RIGHTUP = {x+1,y};
        int[] RIGHTDOWN = {x+1,y+1};
        if(x%2!=0) {
            LEFTUP[1] = y-1;
            RIGHTUP[1] = y-1;
            LEFTDOWN[1] = y;
            RIGHTDOWN[1] = y;
        }

        switch (direction){
            case RIGHT_DOWN:
                if(!(gameObjects.getGameObjectByCoordinates(RIGHTDOWN[0]*10+RIGHTDOWN[1]) instanceof EmptyBoard))
                    return false;
                break;
            case RIGHT_UP:
                if(!(gameObjects.getGameObjectByCoordinates(RIGHTUP[0]*10+RIGHTUP[1]) instanceof EmptyBoard))
                    return false;
                break;
            case LEFT_UP:
                if(!(gameObjects.getGameObjectByCoordinates(LEFTUP[0]*10+LEFTUP[1]) instanceof EmptyBoard))
                    return false;
                break;
            case UP:
                if(!(gameObjects.getGameObjectByCoordinates(UP_[0]*10+UP_[1]) instanceof EmptyBoard))
                    return false;
                break;
            case DOWN:
                if(!(gameObjects.getGameObjectByCoordinates(DOWN_[0]*10+DOWN_[1]) instanceof EmptyBoard))
                    return false;
                break;
            case LEFT_DOWN:
                if(!(gameObjects.getGameObjectByCoordinates(LEFTDOWN[0]*10+LEFTDOWN[1]) instanceof EmptyBoard))
                    return false;
                break;
        }
        return true;
    }

    public boolean isGameLost() {
        return isGameLost;
    }

    public boolean isEnemyAround(GameObject gameObject) {
        boolean flag = false;
        int xy = gameObjects.getGameObjectsCoordinates(gameObject);
        int x = xy / 10;
        int y = xy % 10;
        int[] UP = {x,y-1};
        int[] DOWN = {x,y+1};
        int[] LEFTUP = {x-1,y};
        int[] LEFTDOWN = {x-1,y+1};
        int[] RIGHTUP = {x+1,y};
        int[] RIGHTDOWN = {x+1,y+1};
        if(x%2!=0) {
            LEFTUP[1] = y-1;
            RIGHTUP[1] = y-1;
            LEFTDOWN[1] = y;
            RIGHTDOWN[1] = y;
        }

        GameObject gameObject1 = gameObjects.getGameObjectByCoordinates(UP[0]*10+UP[1]);
        GameObject gameObject2 = gameObjects.getGameObjectByCoordinates(LEFTUP[0]*10+LEFTUP[1]);
        GameObject gameObject3 = gameObjects.getGameObjectByCoordinates(RIGHTUP[0]*10+RIGHTUP[1]);
        GameObject gameObject4 = gameObjects.getGameObjectByCoordinates(DOWN[0]*10+ DOWN[1]);
        GameObject gameObject5 = gameObjects.getGameObjectByCoordinates(LEFTDOWN[0]*10+ LEFTDOWN[1]);
        GameObject gameObject6 = gameObjects.getGameObjectByCoordinates(RIGHTDOWN[0]*10+ RIGHTDOWN[1]);

        if(gameObject instanceof Capucin) {
            if(isBaboon(gameObject1)||isBaboon(gameObject2)||isBaboon(gameObject3)||isBaboon(gameObject4)||isBaboon(gameObject5)||isBaboon(gameObject6))
                flag = true;

        }
        else if(gameObject instanceof Baboon){
            if(isCapucin(gameObject1)||isCapucin(gameObject2)||isCapucin(gameObject3)||isCapucin(gameObject4)||isCapucin(gameObject5)||isCapucin(gameObject6))
                flag = true;
        }
        if(flag)
            isGameLost = true;
        return flag;
    }

    public boolean isCapucin(GameObject gameObject) {
        return gameObject instanceof Capucin;
    }

    public boolean isBaboon(GameObject gameObject){
        return gameObject instanceof Baboon;
    }

    public void restart(){
        gameObjects = levelLoader.getLevel();
    }

}
