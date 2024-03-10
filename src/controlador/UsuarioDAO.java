package controlador;

import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO{
    
    public static ArrayList<Usuario>  usuarios = new ArrayList<>();
    
    public static int buscar(String usuario){
        int n = -1;
        for (int i = 0; i < usuarios.size(); i++ ){
            if(usuarios.get(i).getUsuario().equals(usuario)){
                n = i;
                break;
            }
        }
        return n;
    }
    public Usuario obtener(String usuario){
        if(buscar(usuario) != -1){
            return usuarios.get(buscar(usuario));
        }else{
            return null;
        }
    }
    public boolean insertar(Usuario usuario){
        if(buscar(usuario.getUsuario())== -1){
            usuarios.add(usuario);
            return true;
        }else{
            return false;
        }
    }
    public boolean actualizar(Usuario usuario){
        if(buscar(usuario.getUsuario())!=1){
            Usuario usuarioaux = obtener(usuario.getUsuario());
            usuarioaux.setNombre(usuario.getNombre());
            usuarioaux.setApellido(usuario.getApellido());
            usuarioaux.setPass(usuario.getPass());
            usuarioaux.setEdad(usuario.getEdad());
            return true;
        }else{
            return false;
        }
    }
    public static boolean eliminar(String usuario){
        if(buscar(usuario)!=1){
            usuarios.remove(buscar(usuario));
            return true;
        }else{
            return false;
        }
    }
    public static Object[][] convertir(){
    int filas  =  usuarios.size();
    Object [][] listaUsuarios = new Object[filas][7];
    for(int i = 0; i < filas; i++){
        Usuario usuario = usuarios.get(i);
        listaUsuarios[i][0] = usuario.getCodigo();      
        listaUsuarios[i][1] = usuario.getNombre();
        listaUsuarios[i][2] = usuario.getApellido();      
        listaUsuarios[i][3] = usuario.getGenero();
        listaUsuarios[i][4] = usuario.getEdad();        
    }  
     return listaUsuarios;
    }   
    
    public List<Usuario> getUsuarios() {
    return usuarios;
}
}