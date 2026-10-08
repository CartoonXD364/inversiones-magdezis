package main.java.com.inversiones.magdezis.vespertina.login.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.java.com.inversiones.magdezis.vespertina.login.controller.LoginController;
import main.java.com.inversiones.magdezis.vespertina.login.controller.RegistroController;
import main.java.com.inversiones.magdezis.vespertina.login.repository.AuthRepository;
import main.java.com.inversiones.magdezis.vespertina.login.service.AuthService;

public class SceneManager {
    
    private final Stage STAGE;

    public SceneManager(Stage STAGE) {
        this.STAGE = STAGE;
    }
    
    public void showLoginView()throws Exception{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/view/login-view.fxml"));
        
        loader.setControllerFactory(
                clazz -> {
                    
                    if(clazz == LoginController.class){
                        
                        AuthRepository authRepository = new AuthRepository();
                        AuthService authService = new AuthService(authRepository);
                        
                        return new LoginController(authService, this);
                    }
                    
                    try{
                        
                        return clazz.getDeclaredConstructor().newInstance();
                        
                    }catch(Exception e){
                        throw new RuntimeException("Error al crear el constructor: " + e.getMessage());
                    }
                    
                }
        );
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        STAGE.setScene(scene);
        STAGE.centerOnScreen();
        STAGE.show();
        
    }
    
    public void showRegistroView()throws Exception{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/view/registro-view.fxml"));
        
        loader.setControllerFactory(
                clazz -> {
                    
                    if(clazz == RegistroController.class){
                        
                        AuthRepository authRepository = new AuthRepository();
                        AuthService authService = new AuthService(authRepository);
                        
                        return new RegistroController(authService, this);
                    }
                    
                    try{
                        
                        return clazz.getDeclaredConstructor().newInstance();
                        
                    }catch(Exception e){
                        throw new RuntimeException("Error al crear el constructor: " + e.getMessage());
                    }
                    
                }
        );
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        STAGE.setScene(scene);
        STAGE.centerOnScreen();
        STAGE.show();       
    }
    
    public void showAlert(AlertType alertType, String title, String message){
        
        Alert alert = new Alert(alertType);
        alert.setAlertType(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
