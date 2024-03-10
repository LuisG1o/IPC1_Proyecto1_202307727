package modelo;
import controlador.Usuario;
import controlador.UsuarioDAO;
import controlador.Doctor;
import controlador.DoctorDAO;
import controlador.Producto;
import controlador.ProductoDAO;
import vista.*;



public class UsuarioLogic {  
    private static ProductoDAO productodao = new ProductoDAO();
    private static DoctorDAO doctordao = new DoctorDAO();

    private static UsuarioDAO usuariodao = new UsuarioDAO();    
    public static boolean autentificar(String usuario, String pass){ 
        if(obtener(usuario)!=null){
            Usuario usuarioConsulta = obtener(usuario); 
            if(usuarioConsulta.getUsuario().equals(usuario)&&usuarioConsulta.getPass().equals(pass)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    public static boolean autorizar(String doctor, String pass){ 
        if(obtenerD(doctor)!=null){
            Doctor doctorConsulta = obtenerD(doctor); 
            if(doctorConsulta.getDoctor().equals(doctor)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    //metodos de los pacientes
    public static Usuario obtener(String usuario){
         return usuariodao.obtener(usuario);
    }
    public static  boolean insertar(Usuario usuario){
        return usuariodao.insertar(usuario);
    }
    public static boolean  actualizar(Usuario usuario){
        return usuariodao.actualizar(usuario);   
    }
    public static boolean  eliminar(String usuario){
        return usuariodao.eliminar(usuario);
    }
    
    
    //metodos de los doctores
    public static Doctor obtenerD(String doctor){
         return doctordao.obtenerD(doctor);
    }
    public static  boolean insertarD(Doctor doctor){
        return doctordao.insertarD(doctor);
    }
    public static boolean  actualizarD(Doctor doctor){
        return doctordao.actualizarD(doctor);
        
    }
        public static boolean  eliminarD (String producto){
        return doctordao.eliminarD(producto);
    }
    //metodos de los productos

    public static Producto obtenerP(String producto){
         return productodao.obtenerP(producto);
    }
    public static  boolean insertarP(Producto producto){
        return productodao.insertarP (producto );
    }
    public static boolean  actualizarP(Producto producto){
        return productodao.actualizarP(producto);
        
    }
    public static boolean  eliminarP(String producto){
        return productodao.eliminarP(producto);
    }
    public static void main(String[] args){
            Login loginFrame = new Login("Inicio de sesion");
    }       
}
