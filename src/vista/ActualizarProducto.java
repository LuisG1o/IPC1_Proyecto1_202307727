package vista;
import controlador.Producto;
import controlador.ProductoDAO;
import controlador.Usuario;
import controlador.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import modelo.UsuarioLogic;

public class ActualizarProducto extends JFrame{
     public ActualizarProducto (String title) throws HeadlessException{
        super(title);
        setSize(320,290);
        setResizable(false);  
        this.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(123, 211, 234));
        add(jPanel);
        jPanel.setLayout(null);
        
        JLabel codigo = new JLabel("Codigo");
        codigo.setBounds(10, 20, 80, 25);
        jPanel.add(codigo);

        JTextField txtCodigo = new JTextField(20);
        txtCodigo.setBounds(100, 20, 165, 25);
        jPanel.add(txtCodigo);
        
        JLabel nombre = new JLabel("Nombre");
        nombre.setBounds(10, 50, 80, 25);
        jPanel.add(nombre);

        JTextField txtNombre = new JTextField(20);
        txtNombre.setBounds(100, 50, 165, 25);
        jPanel.add(txtNombre);

        JLabel Precio = new JLabel("Precio");
        Precio.setBounds(10, 80, 80, 25);
        jPanel.add(Precio);
        
        JTextField txtPrecio = new JTextField(20);
        txtPrecio.setBounds(100, 80, 165, 25);
        jPanel.add(txtPrecio);

        JLabel Descripcion = new JLabel("Descripcion");
        Descripcion.setBounds(10, 110, 80, 25);
        jPanel.add(Descripcion);

        JTextField txtDescripcion = new JTextField(20);
        txtDescripcion.setBounds(100, 110, 165, 50);
        jPanel.add(txtDescripcion);
        
        JLabel Cantidad = new JLabel("Cantidad");
        Cantidad.setBounds(10, 165, 80, 25);
        jPanel.add(Cantidad);

        JTextField txtCantidad = new JTextField(20);
        txtCantidad.setBounds(100, 165, 165, 25);
        jPanel.add(txtCantidad);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(100, 210, 110, 25);
        jPanel.add(btnActualizar);
      
        btnActualizar.addActionListener((ActionEvent e) -> {
         String codigoProducto = txtCodigo.getText();
    
        // Verificar si todos los campos están llenos
    if (codigoProducto.isEmpty() || txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() ||
        txtCantidad.getText().isEmpty()) {
        
        // Mostrar un mensaje de error si algún campo está vacío
        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        
    } else {
        try {
            // Verificar si el código existe en el DoctorDAO
            int index = ProductoDAO.buscarP(codigoProducto);

            if (index != -1) {
                // Obtener el Doctor existente
                Producto productoExistente = ProductoDAO.productos.get(index);

                // Actualizar los campos con los nuevos valores
                productoExistente.setNombre(txtNombre.getText());
                productoExistente.setPrecio(Double.parseDouble(txtPrecio.getText()));
                productoExistente.setDescripcion(txtDescripcion.getText());
                productoExistente.setCantidad(Integer.parseInt(txtCantidad.getText()));

                // Verificar si los datos de teléfono y edad son válidos
                double precio = Double.parseDouble(txtPrecio.getText());
                int cantidad = Integer.parseInt(txtCantidad.getText());

                // Actualizar el Doctor con los datos válidos
                productoExistente.setPrecio(precio);
                productoExistente.setCantidad(cantidad);


                // Notificar la actualización al usuario
                if (UsuarioLogic.actualizarP(productoExistente)) {
                    JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.");
                    Admin admin = new Admin();
                    admin.setVisible(true);
                    dispose(); // Cerrar la ventana actual
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el Producto");
                }
            } else {
                // Si el código no existe, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "El código del Producto no existe. No se puede actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // Capturar excepciones si la entrada no es un número válido
            JOptionPane.showMessageDialog(null, "Ingrese números válidos para Cantidad y Precio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
        
        setVisible(true);
    }
                
     
       
     
    public static void main(String[] args){
            ActualizarProducto actualizarProducto = new ActualizarProducto("Actualizar Producto");
    }   
}