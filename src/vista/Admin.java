/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import javax.swing.*;

/**
 *
 * @author Luis
 */
public class Admin extends JFrame {
    public Admin() {
        // Configuración básica del JFrame
        setTitle("Sistema de Hospital");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(880, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        // Crear pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Doctores", new DoctorPanel());
        tabbedPane.addTab("Pacientes", new PacientePanel());
        tabbedPane.addTab("Productos", new ProductoPanel());
        // Agregar pestañas al JFrame
        getContentPane().add(tabbedPane);
        // Mostrar el JFrame
//        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Admin());
    }
}
