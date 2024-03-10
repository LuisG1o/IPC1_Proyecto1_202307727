package vista;
import controlador.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import modelo.UsuarioLogic;

public class Registro extends JFrame{
       
     public Registro (String title) throws HeadlessException{
        super(title);
        setSize(320,250);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JLabel Edad = new JLabel("Edad");
        Edad.setBounds(10, 140, 80, 25);
        jPanel.add(Edad);

        JTextField txtEdad = new JTextField(20);
        txtEdad.setBounds(100, 140, 165, 25);
        jPanel.add(txtEdad);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 170, 110, 25);
        jPanel.add(btnRegistrar);
        //funcionalidad del boton para autentificar
        btnRegistrar.addActionListener((ActionEvent e) -> {
            //verifica que no haya campos vacios:
            if (!txtNombre.getText().isEmpty()
                    && !txtApellido.getText().isEmpty()
                    && !new String(txtPass.getPassword()).isEmpty()
                    && !txtEdad.getText().isEmpty()) {
                //asigna los valores a varibales:
                String nombre1 = txtNombre.getText();
                String apellido = txtApellido.getText();
                String pass = new String(txtPass.getPassword());
                String genero = (String) IGenero.getSelectedItem();
                int edad = Integer.parseInt(txtEdad.getText());
                //crea un usuario
                Usuario usuario = new Usuario(nombre1, apellido, pass, genero, edad, "");
                usuario.setUsuario(usuario.Gcodigo());
                JOptionPane.showMessageDialog(null, "Código generado: " + usuario.getUsuario());
                setVisible(false);
                //ingresa el usuario creado:
                if(UsuarioLogic.insertar(usuario)){
                    JOptionPane.showInternalMessageDialog(null, "Usuario Registrado Exitosamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario Existente");                    
                }
            } else {            
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            }
        });        
        setVisible(true);
    }  
}