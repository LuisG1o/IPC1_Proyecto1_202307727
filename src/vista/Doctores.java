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
public class Doctores extends JFrame {
    public Doctores() {
        // Configuración básica del JFrame
        setTitle("Sistema de Hospital");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(770, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        // Crear pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
//        tabbedPane.addTab("Pacientes", new Citas());
//        tabbedPane.addTab("Asignar Cita", new AsignarCita());

        // Agregar pestañas al JFrame
        getContentPane().add(tabbedPane);
        // Mostrar el JFrame
//        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Doctores());
    }
}
