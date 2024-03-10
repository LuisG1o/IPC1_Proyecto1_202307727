package vista;
import controlador.Doctor;
import controlador.Producto;
import controlador.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioLogic;

public class CrearProducto extends JFrame{   

    private final DefaultTableModel model ;

     public CrearProducto (String title,DefaultTableModel model) throws HeadlessException{
         
        super(title);
        this.model = model;
        setSize(320,250);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);  
        this.setLocationRelativeTo(null);
        
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(123, 211, 234));
        add(jPanel);
        jPanel.setLayout(null);
        
        JLabel nombre = new JLabel("Nombre");
        nombre.setBounds(10, 20, 80, 25);
        jPanel.add(nombre);

        JTextField txtNombre = new JTextField(20);
        txtNombre.setBounds(100, 20, 165, 25);
        jPanel.add(txtNombre);

        JLabel Precio = new JLabel("Precio");
        Precio.setBounds(10, 50, 80, 25);
        jPanel.add(Precio);
        
        JTextField txtPrecio = new JTextField(20);
        txtPrecio.setBounds(100, 50, 165, 25);
        jPanel.add(txtPrecio);

        JLabel Descripcion = new JLabel("Descripcion");
        Descripcion.setBounds(10, 80, 80, 25);
        jPanel.add(Descripcion);

        JTextField txtDescripcion = new JTextField(20);
        txtDescripcion.setBounds(100,80, 165, 50);
        jPanel.add(txtDescripcion);
        
        JLabel Cantidad = new JLabel("Cantidad");
        Cantidad.setBounds(10, 135, 80, 25);
        jPanel.add(Cantidad);

        JTextField txtCantidad = new JTextField(20);
        txtCantidad.setBounds(100, 135, 165, 25);
        jPanel.add(txtCantidad);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 165, 110, 25);
        jPanel.add(btnRegistrar);
 
        btnRegistrar.addActionListener((ActionEvent e) -> {
            if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Sale del ActionListener si algún campo está vacío
        }

        // Asigna valores a las variables
        String nombre1 = txtNombre.getText();
        String precio = txtPrecio.getText();
        String descripcion = txtDescripcion.getText();
        String cantidad = txtCantidad.getText();
         // Añade el código para parsear telefono y edad
        int cantidadA;
        double precioA;
        try {
            cantidadA = Integer.parseInt(txtCantidad.getText());
            precioA = Double.parseDouble(txtPrecio.getText());
               
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos para Cantidad y Precio.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Sale del ActionListener si hay un error al parsear teléfono o edad
        }
             // Crea un Producto
            Producto producto = new Producto();
            producto.setProducto(producto.Gcodigo());
            producto.setNombre(nombre1);
            producto.setPrecio(precioA);
            producto.setDescripcion(descripcion);
            producto.setCantidad(cantidadA);

    
            JOptionPane.showMessageDialog(null, "Código generado: " + producto.getProducto());
    
         // Agrega al doctor a la tabla
         model.addRow(new String[]{
            producto.getProducto(),
            producto.getNombre(),
            String.valueOf(producto.getPrecio()),
            producto.getDescripcion(),
            String.valueOf(producto.getCantidad()),
    });

        // Verifica si el doctor fue guardado correctamente
        if (UsuarioLogic.insertarP(producto)) {
             JOptionPane.showMessageDialog(null, "Producto Registrado exitosamente");
            // Muestra la ventana Admin
            Admin admin = new Admin();
            admin.setVisible(true);
            dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Usuario Existente");
    }
        });  
        setVisible(true);
    }
}

    

