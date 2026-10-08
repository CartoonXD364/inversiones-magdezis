package main.java.com.inversiones.magdezis.vespertina.login.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import main.java.com.inversiones.magdezis.vespertina.login.service.AuthService;
import main.java.com.inversiones.magdezis.vespertina.login.util.SceneManager;

public class RegistroController implements Initializable {
    
    private AuthService authService;
    private SceneManager sceneManager;

    public RegistroController(AuthService authService, SceneManager sceneManager) {
        this.authService = authService;
        this.sceneManager = sceneManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
