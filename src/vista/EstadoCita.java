/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Luis
 */
public class EstadoCita extends JPanel {
    DefaultTableModel model = new DefaultTableModel();
    public EstadoCita(){
        initComponent();
     
    }
    private void initComponent(){
        setLayout(new BorderLayout()); 
        JPanel  CitasPanel = new JPanel();
        CitasPanel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Historial de Citas");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        CitasPanel.add(titleLabel, BorderLayout.NORTH);
        add(CitasPanel, java.awt.BorderLayout.NORTH);
        
        String[] colEstado = {"N.","Estado", "Fecha", "Hora"};
        
        JTable doctorsTable = new JTable(UsuarioDAO.convertir(),colEstado);
        JScrollPane tableScrollPane = new JScrollPane(doctorsTable);
        CitasPanel.add(tableScrollPane, BorderLayout.CENTER);
        
        // Agrega la tabla a un JScrollPane para permitir el desplazamiento si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(doctorsTable);
        CitasPanel.add(scrollPane, java.awt.BorderLayout.CENTER);      
   }  
}  
