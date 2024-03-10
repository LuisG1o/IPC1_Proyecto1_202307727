package vista;

import controlador.Doctor;
import controlador.DoctorDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;

public class SolicitarCita extends JPanel {
    private JLabel motivoLabel, especialidadLabel, doctorLabel, horarioLabel;
    private JTextField motivoTextField;
    private JComboBox<String> especialidadComboBox, doctorComboBox, fechaComboBox, horaComboBox;
    private JButton generarCitaButton;

    public SolicitarCita() {
        initComponent();
    }

    private void initComponent() {
        setLayout(null); // Utilizando null layout
         
        // Motivo de la cita
        JLabel motivoLabel = new JLabel("Motivo de la cita:");
        motivoLabel.setBounds(10, 20, 165, 25);
        
        JTextField motivoTextField = new JTextField();
        motivoTextField.setBounds(10, 50, 750, 150); // Establecer tamaño y posición

        // Especialidad
        JLabel especialidadLabel = new JLabel("Especialidad:");
        especialidadLabel.setBounds(10, 230, 200, 25);
        especialidadComboBox = new JComboBox();
        especialidadComboBox.setBounds(150, 230, 150, 25);
        
//        JComboBox<String> especialidadComboBox = new JComboBox<>();
//        especialidadComboBox.setBounds(150, 230, 150, 25);
                
        HashSet<String> especialidadDoctor = DoctorDAO.ObtenerEspecialidad();
        for(String especialidadString: especialidadDoctor){
        especialidadComboBox.addItem(especialidadString);
        }
        // Doctor
        JLabel doctorLabel = new JLabel("Doctor:");
        doctorLabel.setBounds(10,270, 150, 25);
        
        doctorComboBox = new JComboBox();
        doctorComboBox.setBounds(150, 270, 150, 25);
        
        especialidadComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        String especialidadSeleccionada = (String) especialidadComboBox.getSelectedItem();
        ArrayList<Doctor> doctoresFiltrados = DoctorDAO.filtrarPorEspecialidad(especialidadSeleccionada);
        doctorComboBox.removeAllItems();      
        for (Doctor doctor : doctoresFiltrados) {
            doctorComboBox.addItem(doctor.getNombre() + " " + doctor.getApellido());
        }
    }
});
        // Horario
        JLabel horarioLabel = new JLabel("Horario de Citas Disponibles:");
        horarioLabel.setBounds(10, 320, 200, 25);

        // Fecha
        JLabel Fecha = new JLabel("Fecha:");
        Fecha.setBounds(10, 360, 100, 25);
        add(Fecha);
        
        JComboBox<String> fechaComboBox = new JComboBox<>();
        fechaComboBox.setBounds(70, 360, 100, 25);

        // Hora
        JLabel Hora = new JLabel("Hora:");
        Hora.setBounds(190, 360, 80, 25);
        add(Hora);
        JComboBox<String> horaComboBox = new JComboBox<>();
        horaComboBox.setBounds(250, 360, 100, 25);

        // Botón Generar Cita
        JButton generarCitaButton = new JButton("Generar Cita");
        generarCitaButton.setBounds(550, 360, 150, 30);
        
        JButton BtnEditarPerfil = new JButton("Editar Perfil");
        BtnEditarPerfil.setBounds(550, 10, 150, 25);
        
        BtnEditarPerfil.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(SolicitarCita.this);            
            // Muestra el formulario de registro:
            EditarPerfil editarPerfil = new EditarPerfil("Editar Perfil");
            window.dispose();
        });
        
        // Agregar componentes al panel
        add(motivoLabel);
        add(motivoTextField);
        add(especialidadLabel);
        add(especialidadComboBox);
        add(doctorLabel);
        add(doctorComboBox);
        add(horarioLabel);
        add(fechaComboBox);
        add(horaComboBox);
        add(generarCitaButton);
        add(BtnEditarPerfil);

    }
    
    
}
