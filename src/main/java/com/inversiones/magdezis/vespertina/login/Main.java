package main.java.com.inversiones.magdezis.vespertina.login;

import javafx.application.Application;
import javafx.stage.Stage;

import main.java.com.inversiones.magdezis.vespertina.login.util.SceneManager;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.showLoginView();
        
    }

    public static void main(String[] args) {

        launch(args);
        
        
    }
    
}
