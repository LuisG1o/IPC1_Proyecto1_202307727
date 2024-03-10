package controlador;

import java.util.Random;
/**
 *
 * @author Luis
 */
public class Doctor {
    String nombre;
    String apellido;
    String pass;
    String genero;
    String especialidad;
    int telefono;
    int edad;
    String doctor;

    public Doctor() {
    }

    public Doctor(String nombre, String apellido, String pass, String genero, String especialidad, int telefono, int edad, String doctor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.genero = genero;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.edad = edad;
        this.doctor = Gcodigo();
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getCodigo() {
    return doctor;
}
    
}
