package controlador;

import java.util.Random;
/**
 *
 * @author Luis
 */
public class Producto {
    String nombre;
    double precio;
    String descripcion;
    int cantidad;
    String producto;

    public Producto() {
    }

    public Producto(String nombre, double precio, String descripcion, int cantidad, String producto) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.producto = Gcodigo();
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    public String getCodigo() {
    return producto;
    }   
}
