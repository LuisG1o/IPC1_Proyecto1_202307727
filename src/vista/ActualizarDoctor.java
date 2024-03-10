package vista;
import controlador.Doctor;
import controlador.DoctorDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import modelo.UsuarioLogic;

public class ActualizarDoctor extends JFrame{
     public ActualizarDoctor (String title) throws HeadlessException{
        super(title);
        setSize(630,250);
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
        
        JLabel Especialidad = new JLabel("Especialidad");
        Especialidad.setBounds(310, 50 ,80,25);
        jPanel.add(Especialidad);
        
        JTextField txtEspecialidad = new JTextField(20);
        txtEspecialidad.setBounds(400 , 50, 165, 25);
        jPanel.add(txtEspecialidad);
        
        JLabel Telefono = new JLabel("Telefono:");
        Telefono.setBounds(310, 80,110,25);
        jPanel.add(Telefono);
        
        JTextField txtTelefono = new JTextField(20);
        txtTelefono.setBounds(400 , 80, 165, 25);
        jPanel.add(txtTelefono);

        JLabel Edad = new JLabel("Edad");
        Edad.setBounds(310, 110, 80, 25);
        jPanel.add(Edad);

        JTextField txtEdad = new JTextField(20);
        txtEdad.setBounds(400, 110, 165, 25);
        jPanel.add(txtEdad);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(400, 150, 110, 25);
        jPanel.add(btnActualizar);
      
        btnActualizar.addActionListener((ActionEvent e) -> {
         String codigoDoctor = txtCodigo.getText();
    
        // Verificar si todos los campos están llenos
    if (codigoDoctor.isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() ||
        txtPass.getPassword().length == 0 || txtEspecialidad.getText().isEmpty() || 
        txtTelefono.getText().isEmpty() || txtEdad.getText().isEmpty()) {
        
        // Mostrar un mensaje de error si algún campo está vacío
        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        
    } else {
        try {
            // Verificar si el código existe en el DoctorDAO
            int index = DoctorDAO.buscarD(codigoDoctor);

            if (index != -1) {
                // Obtener el Doctor existente
                Doctor doctorExistente = DoctorDAO.doctores.get(index);

                // Actualizar los campos con los nuevos valores
                doctorExistente.setNombre(txtNombre.getText());
                doctorExistente.setApellido(txtApellido.getText());
                doctorExistente.setPass(new String(txtPass.getPassword()));
                doctorExistente.setGenero(IGenero.getSelectedItem().toString());
                doctorExistente.setEspecialidad(txtEspecialidad.getText());

                // Verificar si los datos de teléfono y edad son válidos
                int telefono = Integer.parseInt(txtTelefono.getText());
                int edad = Integer.parseInt(txtEdad.getText());

                // Actualizar el Doctor con los datos válidos
                doctorExistente.setTelefono(telefono);
                doctorExistente.setEdad(edad);

                // Notificar la actualización al usuario
                if (UsuarioLogic.actualizarD(doctorExistente)) {
                    JOptionPane.showMessageDialog(null, "Doctor actualizado exitosamente.");
                    Admin admin = new Admin();
                    admin.setVisible(true);
                    dispose(); // Cerrar la ventana actual
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el doctor");
                }

            } else {
                // Si el código no existe, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "El código del doctor no existe. No se puede actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // Capturar excepciones si la entrada no es un número válido
            JOptionPane.showMessageDialog(null, "Ingrese números válidos para Teléfono y Edad.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
        
        setVisible(true);
    }
                
     
       
     
    public static void main(String[] args){
            ActualizarDoctor actualizarDoctor = new ActualizarDoctor("Actualizar Doctor");
    }   
}