package main.java.com.inversiones.magdezis.vespertina.login.repository;

import main.java.com.inversiones.magdezis.vespertina.login.config.DataBaseConnection;
import main.java.com.inversiones.magdezis.vespertina.login.dto.request.LoginDTORequest;
import main.java.com.inversiones.magdezis.vespertina.login.dto.response.LoginDTOResponse;
import main.java.com.inversiones.magdezis.vespertina.login.model.Rol;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.com.inversiones.magdezis.vespertina.login.model.Usuario;

public class AuthRepository {
    
    private LoginDTOResponse response;
    
    public LoginDTOResponse findUserByEmail(LoginDTORequest request){
        
        String sql = "select u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.email, u.password_hash, r.id_rol, r.nombre_rol from usuarios u inner join roles r on u.id_rol = r.id_rol where email = ?;";
        
        try(PreparedStatement pstm = DataBaseConnection.getDBConnection().prepareStatement(sql);){
            
            pstm.setString(1, request.getEmail());
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                
                Rol rol = new Rol(
                        rs.getInt("id_rol"),
                        rs.getString("nombre_rol")
                );
                
                return response = new LoginDTOResponse(
                                rs.getString("id_usuario"),
                                rs.getString("nombre_usuario"),
                                rs.getString("apellido_usuario"),
                                rs.getString("email"),
                                rs.getString("password_hash"),
                                rol 
                );
                
            }
            
            return response;
        }catch(SQLException e){
            throw new RuntimeException("Error al buscar al usuario por el correo: " + e.getMessage());
        }
        
    }
    
    public boolean save(Usuario usuario){
        
        String sql = "insert into usuarios values(UUID(), ? , ?, ? ,? ,?);";
        
        try(PreparedStatement pstm = DataBaseConnection.getDBConnection().prepareStatement(sql);){
        
            pstm.setString(1, usuario.getNombreUsuario());
            pstm.setString(2, usuario.getApellidoUsuario());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getContrasena());
            pstm.setInt(5, usuario.getRol().getIdRol());
            
            return pstm.executeUpdate() > 0;
        }catch(SQLException e){
            throw new RuntimeException("Error al guardar al usuario: " + e.getMessage());
        }
        
    }
    
}
