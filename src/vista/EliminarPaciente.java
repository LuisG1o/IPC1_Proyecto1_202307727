package vista;
import controlador.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EliminarPaciente extends JFrame{   

     public EliminarPaciente (String title) throws HeadlessException{
         
        super(title);
        setSize(300,135);
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

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(100, 50, 110, 25);
        jPanel.add(btnEliminar);
        
        btnEliminar.addActionListener((ActionEvent e) -> {
            String codigoEliminar = txtCodigo.getText();

        if (codigoEliminar != null) {
        // Buscar el índice del doctor con el código ingresado
        int indiceEliminar = UsuarioDAO.buscar(codigoEliminar);

        if (indiceEliminar != -1) {
            // Eliminar al doctor y actualizar la tabla
            UsuarioDAO.eliminar(codigoEliminar);
            JOptionPane.showMessageDialog(null, "Paciente eliminado exitosamente.");
                    Admin admin = new Admin();
                    admin.setVisible(true);
                    dispose(); // Cerrar la ventana actual
            } else {
                JOptionPane.showMessageDialog(null, "No existe un doctor con ese código.");
            }
        }
        });  
        setVisible(true);
    }
}

    

