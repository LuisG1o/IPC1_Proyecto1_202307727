package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import modelo.UsuarioLogic;

public class Login extends JFrame{
     public Login (String title) throws HeadlessException{
        super(title);
        setSize(300,200);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);    
        this.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(123, 211, 234));
        add(jPanel);

        jPanel.setLayout(null);
        
        JLabel Codigo = new JLabel("Codigo:");
        Codigo.setBounds(10, 20, 80, 25);
        jPanel.add(Codigo);

        JTextField txtCodigo  = new JTextField(20);
        txtCodigo.setBounds(100, 20, 165, 25);
        jPanel.add(txtCodigo);

        JLabel Pass = new JLabel("Password:");
        Pass.setBounds(10, 50, 80, 25);
        jPanel.add(Pass);

        JPasswordField txtPass = new JPasswordField(20);
        txtPass.setBounds(100, 50, 165, 25);
        jPanel.add(txtPass);

        JCheckBox chkMostrar = new JCheckBox("Mostrar Contraseña");
        chkMostrar.setBounds(10, 80, 165, 25);
        chkMostrar.setBackground(new Color(123, 211, 234));
        jPanel.add(chkMostrar);

        JButton BtnIngresar = new JButton("Ingresar");
        BtnIngresar.setBounds(150, 110, 120, 25);
        BtnIngresar.setBackground(new Color(161, 238, 189));
        jPanel.add(BtnIngresar);
        
        JButton BtnRegistrar = new JButton("Registrar");
        BtnRegistrar.setBounds(10, 110, 120, 25);
        BtnRegistrar.setBackground(new Color(56, 122, 223));
        jPanel.add(BtnRegistrar);
        
        setVisible(true); 
        
        chkMostrar.addActionListener((ActionEvent e) -> {
            //verifica si el chk esta seleccionado:
            if(chkMostrar.isSelected()){
                txtPass.setEchoChar((char)0);
            }else{
                txtPass.setEchoChar('*');
            }
        });
        
        BtnIngresar.addActionListener((ActionEvent e) -> {
            //verifica si no hay campos vacios:
            if (!txtCodigo.getText().isEmpty() && !txtPass.getText().isEmpty()) {
                String codigo = txtCodigo.getText();
                String contrasena = txtPass.getText();
                //verifica si el codigo pertenence al administrador:
                if(codigo.equals("1") && contrasena.equals("1")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido al Administrador");
                    // Muestra la ventana de Administrador
                    Admin admin = new Admin();
                    admin.setVisible(true);
//                      Paciente paciente = new Paciente();
//                      paciente.setVisible(true);
                    //verifca si el codigo ingresado pertenece a pacientes:
                }else if (UsuarioLogic.autentificar(codigo, contrasena)){
                    JOptionPane.showMessageDialog(null, "Bienvenido a la Vista de Pacientes");
                    //Muestra la ventana de pacientes
                    Paciente paciente = new Paciente();
                    paciente.setVisible(true);
                    //verifica si el codigo ingresa pertece a un doctor:
                }else if(UsuarioLogic.autorizar(codigo, contrasena)){
                    JOptionPane.showMessageDialog(null, "Bienvenido Doctor");
                    //Muestra la ventana de Doctores:
                    VistaDoctor doctores = new VistaDoctor();
                    doctores.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Falta usuario o contraseña");
            }
        });
        BtnRegistrar.addActionListener((ActionEvent e) -> {
            // Muestra el formulario de registro:
            Registro registroFrame = new Registro("Registro de Usuario");
        });
     }
}