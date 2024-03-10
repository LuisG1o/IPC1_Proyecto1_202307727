package controlador;
import java.util.Random;

public class Usuario {
    private String nombre;
    private String apellido;
    private String pass;
    private String genero;
    private int edad;
    private String usuario;
    
      public Usuario() {
    }
    public Usuario(String nombre, String apellido, String pass, String genero, int edad, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.genero = genero;
        this.edad = edad;
        this.usuario = Gcodigo();
    }    
    public String Gcodigo() {
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder codigoAleatorio = new StringBuilder();

    Random rand = new Random();

    for (int i = 0; i < 4; i++) {
        int indice = rand.nextInt(caracteres.length());
        codigoAleatorio.append(caracteres.charAt(indice));
    }
    return codigoAleatorio.toString();
}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }  
    public String getCodigo() {
    return usuario;
}
}
