package main.java.com.inversiones.magdezis.vespertina.login.dto.response;

import main.java.com.inversiones.magdezis.vespertina.login.model.Rol;
import main.java.com.inversiones.magdezis.vespertina.login.model.Usuario;

public class LoginDTOResponse {
    
    private String idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String email;
    private String password;
    private Rol rol;

    public LoginDTOResponse(String idUsuario, String nombreUsuario, String apellidoUsuario, String email, String password, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @Override
    public String toString(){
        
        return "Email: " + email + ", contraseña: " + password;
    }
    
}
