package controlador;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luis
 */
public class ProductoDAO {
    
    public static ArrayList<Producto> productos = new ArrayList<>();
   
    public static int buscarP (String producto){
        int n = -1;
        for (int i = 0; i < productos.size(); i++ ){
            if(productos.get(i).getProducto().equals(producto)){
                n = i;
                break;
            }
        }
        return n;
    }
    public Producto obtenerP (String producto){
        if(buscarP(producto) != -1){
            return productos.get(buscarP(producto));
        }else{
            return null;
        }
    }
    public boolean insertarP(Producto producto){
        if(buscarP(producto.getProducto())== -1){
            productos.add(producto);
            return true;
        }else{
            return false;
        }
    }
    public boolean actualizarP (Producto producto){
        if(buscarP(producto.getProducto())!=1){
            Producto productoaux = obtenerP(producto.getProducto());
            productoaux.setNombre(producto.getNombre());
            productoaux.setPrecio(producto.getPrecio());
            productoaux.setDescripcion(producto.getDescripcion());
            productoaux.setCantidad(producto.getCantidad());
            return true;
        }else{
            return false;
        }
    }
    public static boolean eliminarP(String producto){
        if(buscarP(producto)!=1){
            productos.remove(buscarP(producto));
            return true;
        }else{
            return false;
        }
    }
    public static Object[][] convertir(){
    int filas  =  productos.size();
    Object [][] listaProductos = new Object[filas][7];
    for(int i = 0; i < filas; i++){
        Producto producto = productos.get(i);
        listaProductos[i][0] = producto.getCodigo();      
        listaProductos[i][1] = producto.getNombre();
        listaProductos[i][2] = producto.getPrecio();      
        listaProductos[i][3] = producto.getDescripcion();
        listaProductos[i][4] = producto.getCantidad();        
    }  
     return listaProductos;
    }  
        public static Object[][] Farmacia(){
    int filas  =  productos.size();
    Object [][] listaProductos = new Object[filas][7];
    for(int i = 0; i < filas; i++){
        Producto producto = productos.get(i);  
        listaProductos[i][0] = producto.getNombre(); 
        listaProductos[i][1] = producto.getDescripcion();
        listaProductos[i][2] = producto.getPrecio();   
      
    }  
     return listaProductos;
    }  
    
    public List<Producto> getProductos() {
    return productos;
}  
}
