package main.java.com.inversiones.magdezis.vespertina.login.service;

import main.java.com.inversiones.magdezis.vespertina.login.dto.request.LoginDTORequest;
import main.java.com.inversiones.magdezis.vespertina.login.dto.response.LoginDTOResponse;
import main.java.com.inversiones.magdezis.vespertina.login.repository.AuthRepository;

public class AuthService {
    
    private AuthRepository authRepository;
    
    private LoginDTOResponse response;
    
    public AuthService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }
    
    public LoginDTOResponse login(LoginDTORequest request){
        
        if(request.getEmail() == null){
            throw new RuntimeException("Error: se debe ingresar el correo.");
        }
        
        if(request.getPassword() == null){
            throw new RuntimeException("Error: se debe ingresar la contraseña");
        }
        
        /*if(!response.getEmail().equals(request.getEmail()) && !response.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Error: se debe ingresar la contraseña");
        }*/
        
        return authRepository.findUserByEmail(request);
    }
    
}
