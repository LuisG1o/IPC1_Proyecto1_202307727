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
public class Paciente extends JFrame {
    public Paciente() {
        // Configuración básica del JFrame
        setTitle("Sistema de Hospital");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        // Crear pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Solicitar Cita", new SolicitarCita());
        tabbedPane.addTab("Pacientes", new EstadoCita());
        tabbedPane.addTab("Productos", new Farmacia());
        
        // Agregar pestañas al JFrame
        getContentPane().add(tabbedPane);
        // Mostrar el JFrame
//        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Paciente());
    }
}
