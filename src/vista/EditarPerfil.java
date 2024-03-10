package vista;

import controlador.Usuario;
import controlador.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import modelo.UsuarioLogic;

public class EditarPerfil extends JFrame{
     public EditarPerfil (String title) throws HeadlessException{
        super(title);
        setSize(320,300);
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

        JLabel Apellido = new JLabel("Apellido");
        Apellido.setBounds(10, 80, 80, 25);
        jPanel.add(Apellido);

        JTextField txtApellido = new JTextField(20);
        txtApellido.setBounds(100, 80, 165, 25);
        jPanel.add(txtApellido);

        JLabel Pass = new JLabel("Password");
        Pass.setBounds(10, 110, 80, 25);
        jPanel.add(Pass);

        JPasswordField txtPass = new JPasswordField(20);
        txtPass.setBounds(100, 110, 165, 25);
        jPanel.add(txtPass);

        JLabel Genero = new JLabel("Genero");
        Genero.setBounds(10, 140, 80, 25);
        jPanel.add(Genero);

        String[] generos = {"Masculino", "Femenino", "Otro"};
        JComboBox<String> IGenero = new JComboBox<>(generos);
        IGenero.setBounds(100, 140, 165, 25);
        jPanel.add(IGenero);

        JLabel Edad = new JLabel("Edad");
        Edad.setBounds(10, 170, 80, 25);
        jPanel.add(Edad);

        JTextField txtEdad = new JTextField(20);
        txtEdad.setBounds(100, 170, 165, 25);
        jPanel.add(txtEdad);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(100, 200, 110, 25);
        jPanel.add(btnActualizar);
      
        btnActualizar.addActionListener((ActionEvent e) -> {
         String codigoPaciente = txtCodigo.getText();
    
        // Verificar si todos los campos están llenos
    if (codigoPaciente.isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() ||
        txtPass.getPassword().length == 0 ||  txtEdad.getText().isEmpty()) {
        
        // Mostrar un mensaje de error si algún campo está vacío
        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        
    } else {
        try {
            // Verificar si el código existe en el DoctorDAO
            int index = UsuarioDAO.buscar(codigoPaciente);

            if (index != -1) {
                // Obtener el Doctor existente
                Usuario usuarioExistente = UsuarioDAO.usuarios.get(index);

                // Actualizar los campos con los nuevos valores
                usuarioExistente.setNombre(txtNombre.getText());
                usuarioExistente.setApellido(txtApellido.getText());
                usuarioExistente.setPass(new String(txtPass.getPassword()));
                usuarioExistente.setGenero(IGenero.getSelectedItem().toString());

                // Verificar si los datos de teléfono y edad son válidos
                int edad = Integer.parseInt(txtEdad.getText());

                // Actualizar el Doctor con los datos válidos
                usuarioExistente.setEdad(edad);

                // Notificar la actualización al usuario
                if (UsuarioLogic.actualizar(usuarioExistente)) {
                    JOptionPane.showMessageDialog(null, "Paciente actualizado exitosamente.");
                    Paciente paciente = new Paciente();
                    paciente.setVisible(true);
                    dispose(); // Cerrar la ventana actual
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el Paciente");
                }

            } else {
                // Si el código no existe, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "El código del Paciente no existe. No se puede actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // Capturar excepciones si la entrada no es un número válido
            JOptionPane.showMessageDialog(null, "Ingrese números válidos para Edad.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});       
        setVisible(true);
    }
}