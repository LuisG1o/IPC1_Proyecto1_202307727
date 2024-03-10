package vista;
import controlador.Doctor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioLogic;

public class CrearDoctor extends JFrame{   

    private final DefaultTableModel model ;

     public CrearDoctor (String title,DefaultTableModel model) throws HeadlessException{
         
        super(title);
        this.model = model;
        setSize(630,220);
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

        JLabel Apellido = new JLabel("Apellido");
        Apellido.setBounds(10, 50, 80, 25);
        jPanel.add(Apellido);

        JTextField txtApellido = new JTextField(20);
        txtApellido.setBounds(100, 50, 165, 25);
        jPanel.add(txtApellido);

        JLabel Pass = new JLabel("Password");
        Pass.setBounds(10, 80, 80, 25);
        jPanel.add(Pass);

        JPasswordField txtPass = new JPasswordField(20);
        txtPass.setBounds(100, 80, 165, 25);
        jPanel.add(txtPass);

        JLabel Genero = new JLabel("Genero");
        Genero.setBounds(10, 110, 80, 25);
        jPanel.add(Genero);

        String[] generos = {"Masculino", "Femenino", "Otro"};
        JComboBox<String> IGenero = new JComboBox<>(generos);
        IGenero.setBounds(100, 110, 165, 25);
        jPanel.add(IGenero);
        
        JLabel Especialidad = new JLabel("Especialidad");
        Especialidad.setBounds(310, 20,80,25);
        jPanel.add(Especialidad);
        
        JTextField txtEspecialidad = new JTextField(20);
        txtEspecialidad.setBounds(400 , 20, 165, 25);
        jPanel.add(txtEspecialidad);
        
        JLabel Telefono = new JLabel("Telefono:");
        Telefono.setBounds(310, 50,80,25);
        jPanel.add(Telefono);
        
        JTextField txtTelefono = new JTextField(20);
        txtTelefono.setBounds(400 , 50, 165, 25);
        jPanel.add(txtTelefono);

        JLabel Edad = new JLabel("Edad");
        Edad.setBounds(310, 80, 80, 25);
        jPanel.add(Edad);

        JTextField txtEdad = new JTextField(20);
        txtEdad.setBounds(400, 80, 165, 25);
        jPanel.add(txtEdad);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(400, 130, 110, 25);
        jPanel.add(btnRegistrar);
 
        btnRegistrar.addActionListener((ActionEvent e) -> {
if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtPass.getPassword().length == 0 ||
        txtEspecialidad.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtEdad.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Sale del ActionListener si algún campo está vacío
    }

    // Asigna valores a las variables
    String nombre1 = txtNombre.getText();
    String apellido = txtApellido.getText();
    String pass = new String(txtPass.getPassword());
    String genero = (String) IGenero.getSelectedItem();
    String especialidad = txtEspecialidad.getText();
    
    // Añade el código para parsear telefono y edad
    int telefono, edad;
    try {
        telefono = Integer.parseInt(txtTelefono.getText());
        edad = Integer.parseInt(txtEdad.getText());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos para Teléfono y Edad.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Sale del ActionListener si hay un error al parsear teléfono o edad
    }

    // Crea un doctor
    Doctor doctor = new Doctor();
    doctor.setDoctor(doctor.Gcodigo());
    doctor.setNombre(nombre1);
    doctor.setApellido(apellido);
    doctor.setGenero(genero);
    doctor.setEdad(edad);
    doctor.setEspecialidad(especialidad);
    doctor.setTelefono(telefono);
    
    JOptionPane.showMessageDialog(null, "Código generado: " + doctor.getDoctor());
    
    // Agrega al doctor a la tabla
    model.addRow(new String[]{
            doctor.getDoctor(),
            doctor.getNombre(),
            doctor.getApellido(),
            doctor.getGenero(),
            String.valueOf(doctor.getEdad()),
            doctor.getEspecialidad(),
            String.valueOf(doctor.getTelefono()),
    });

    // Verifica si el doctor fue guardado correctamente
    if (UsuarioLogic.insertarD(doctor)) {
        JOptionPane.showMessageDialog(null, "Doctor Registrado exitosamente");
        // Muestra la ventana Admin
        Admin admin = new Admin();
        admin.setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Doctor Existente");
    }
        });  
        setVisible(true);
    }
}

    

