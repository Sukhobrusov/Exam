package model;

import java.util.Map;

public class GameObjects {
    private Map<GameObject,Integer> gameObjects;

    public GameObjects(Map<GameObject,Integer> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Map<GameObject,Integer> getGameObjects() {
        return gameObjects;
    }

    public GameObject getGameObjectByCoordinates(int xy){

        for(GameObject gameObject : gameObjects.keySet()){
            if(gameObjects.get(gameObject)==xy){
                return gameObject;
            }
        }
        return null;
    }

    public void switchCoordinates(GameObject gameObject,GameObject testGameObject){
        int xyOfFirstObject = gameObjects.get(gameObject);
        gameObjects.put(gameObject,gameObjects.get(testGameObject));
        gameObjects.put(testGameObject,xyOfFirstObject);
    }

    public Integer getGameObjectsCoordinates(GameObject gameObject){
        return gameObjects.get(gameObject);
    }

}
