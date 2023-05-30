package proyectomundial.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectomundial.model.Usuario;
import proyectomundial.util.BasedeDatos;
import static proyectomundial.util.BasedeDatos.ejecutarSQL;

/**
 *
 * @author Camilo
 */
public class UsuarioDAO {

    public UsuarioDAO() {
        BasedeDatos.conectar();
    }
    
    public List<Usuario> getUsuarios() {
        
        String sql = "SELECT username, password FROM poo.users";
        List<Usuario> selecciones = new ArrayList<Usuario>();
        
        try {
            ResultSet result = BasedeDatos.ejecutarSQL(sql);
            
            if(result != null) {
            
                while (result.next()) { 
                    Usuario usuario = new Usuario(result.getString("username"), result.getString("password"));
                    selecciones.add(usuario);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error consultando usuarios");
        }
        
        return selecciones;
        
    }
}
