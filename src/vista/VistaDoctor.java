/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Yorch
 */
public class VistaDoctor extends JFrame implements ActionListener{
    private JButton editarPerfilButton;
    private JButton verMasButtom;
    private JButton atenderButton;
    private JButton rechazarButton;
    private JButton asignarrButton; 
    private JTable tablaListaCitas;
    private JTable tablaHorario;
    private JTextField horaTxt;
    
    public VistaDoctor(){
        this.setSize(800,500);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setSize(800, 400);
        
         //Pestaña 1
        JPanel pestaña1 = new JPanel(null);
        tabbedPane.addTab("Citas", pestaña1); 
        
        editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setBounds(600, 10, 140, 35);
        pestaña1.add(editarPerfilButton);
        editarPerfilButton.addActionListener(this);
        
        verMasButtom = new JButton("Ver más");
        verMasButtom.setBounds(600, 150, 140, 35);
        pestaña1.add(verMasButtom);
        
        atenderButton = new JButton("Atender");
        atenderButton.setBounds(600, 250, 140, 35);
        pestaña1.add(atenderButton);
        atenderButton.addActionListener(this);
        
        rechazarButton = new JButton("Rechazar");
        rechazarButton.setBounds(600, 350, 140, 35);
        pestaña1.add(rechazarButton);
        
        String[] columnasListadoCitas = {"Numero Cita","Paciente", "Hora", "Fecha"};
        tablaListaCitas = new JTable(NuevoHorario.convertirDatosHorario(),columnasListadoCitas);
        JScrollPane scrollPane = new JScrollPane(tablaListaCitas);
        scrollPane.setBounds(20, 30, 550, 350);
        pestaña1.add(scrollPane);
            
        
          //Pestaña 2
        JPanel pestaña2 = new JPanel(null);
        tabbedPane.addTab("Asignar Horario", pestaña2); 
        editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setBounds(600, 10, 140, 35);
        pestaña2.add(editarPerfilButton);
        editarPerfilButton.addActionListener(this);
        
        JLabel horario = new JLabel("Horario");
        horario.setBounds(80, 20, 60, 30);
        pestaña2.add(horario);
        
        JLabel horarioDeCitas = new JLabel("Horario de Citas:");
        horarioDeCitas.setBounds(80, 50, 120, 30);
        pestaña2.add(horarioDeCitas);
        
        horaTxt = new JTextField();
        horaTxt.setBounds(200, 50, 150, 30);
        pestaña2.add(horaTxt);
        
        asignarrButton = new JButton("Asignar");
        asignarrButton.setBounds(380, 42, 120, 42);
        pestaña2.add(asignarrButton);
        asignarrButton.addActionListener(this);
        
        JLabel miHoraio = new JLabel("Mi horario disponible para ctias:");
        miHoraio.setBounds(280, 100, 250, 30);
        pestaña2.add(miHoraio);
        
        String[] columnasHorario = {"No. Horario", "Horario de Citas"};
        tablaHorario = new JTable(NuevoHorario.convertirDatosHorario(),columnasHorario);
        JScrollPane scrollPane2 = new JScrollPane(tablaHorario);
        scrollPane2.setBounds(80, 140, 600, 250);
        pestaña2.add(scrollPane2);
        
        getContentPane().add(tabbedPane);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       String hora = horaTxt.getText();
       if(e.getActionCommand().equals("Asignar") ){
           if(!hora.isEmpty()){
               NuevoHorario.registrarHorario(NuevoHorario.codigo, hora);
               NuevoHorario.codigo++;
               JOptionPane.showMessageDialog(null, "Se registró el horario de manera exitosa.");
//               this.setVisible(false);
               VistaDoctor ventanaDoctor = new VistaDoctor();
           }else{
               JOptionPane.showMessageDialog(null, "No ha ingresado un horario.");
           }
       }else if(e.getActionCommand().equals("Atender")){
//           Ventana vent = new Ventana();
       }else if(e.getActionCommand().equals("Editar Perfil")){
            ActualizarPaciente actualizarPaciente = new ActualizarPaciente("Actualizar");           
       }
    }
    
    public static ArrayList<String> citasDoc = new ArrayList<>();  
    
//    static{
//        ArrayList<String> nombresPacientes = NuevoPaciente.filtrarNombrePacientes();
//        ArrayList<String> fechasCitas = NuevaCita.filtrarFecha();
//        ArrayList<String> horasCitas = NuevaCita.filtrarHora();
//        ArrayList<String> numCita = NuevaCita.filtrarNumeroCita();
//        citasDoc.addAll(nombresPacientes);
//        citasDoc.addAll(fechasCitas);
//        citasDoc.addAll(horasCitas);
//        citasDoc.addAll(numCita);
//    }
    
//    public static Object [][] convertirDatosVarios(){
//            int filasDatos = citasDoc.size();
//            Object [][] arregloDatos = new Object[filasDatos][4];
//            
//            for(int i = 0; i < filasDatos; i++){
//                //String nuevosDatos = citasDoc.get(i);
//                arregloDatos[i][0] = NuevaCita.filtrarNumeroCita();
//                arregloDatos[i][1] = NuevoPaciente.filtrarNombrePacientes();
//                arregloDatos[i][2] = NuevaCita.filtrarHora();
//                arregloDatos[i][3] = NuevaCita.filtrarFecha();
//            }
//        return arregloDatos;     
//        }
//     public static void eliminarCita(int numeroC){
//        String eliminarCita = null;
//        for(String datos: citasDoc){
//            if(NuevaCita.filtrarNumeroCita().equals(numeroC)){
//                eliminarCita = datos;
//                break;
//            }
//        }
//        if(eliminarCita !=null){
//            citasDoc.remove(eliminarCita);   
//        }
//    }
    
}

