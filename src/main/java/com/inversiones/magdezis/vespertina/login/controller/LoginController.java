package main.java.com.inversiones.magdezis.vespertina.login.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.com.inversiones.magdezis.vespertina.login.dto.request.LoginDTORequest;
import main.java.com.inversiones.magdezis.vespertina.login.service.AuthService;
import main.java.com.inversiones.magdezis.vespertina.login.util.SceneManager;

public class LoginController implements Initializable {
    
    private AuthService authService;
    private SceneManager sceneManager;
    
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;
    
    public LoginController(AuthService authService, SceneManager sceneManager){
        this.authService = authService;
        this.sceneManager = sceneManager;
    }
    
    @FXML
    public void handleLogin(){
        
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();
        
        if(email == null || email.isBlank()){
            sceneManager.showAlert(Alert.AlertType.ERROR, "Campo vacio", "Se debe llenar el campo de Correo Electrónico");
            return;
        }
        
        if(password == null || password.isBlank()){
            sceneManager.showAlert(Alert.AlertType.ERROR, "Campo vacio", "Se debe llenar el campo de Contraseña");
            return;
        }
        
        LoginDTORequest request = new LoginDTORequest(email, password);
        
        if(!email.equals(request.getEmail()) || !password.equals(request.getPassword())){
            sceneManager.showAlert(Alert.AlertType.ERROR, "Correo o contraseña incorrectos", "Credenciales invalidas");
            return;
        }
        
        if(authService.login(request) != null){
            sceneManager.showAlert(Alert.AlertType.INFORMATION, "Bienvenido", "Inicio de sesión exitoso");
        }
        
    }
    
    @FXML
    private void handleShowRegistro()throws Exception{
        sceneManager.showRegistroView();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
