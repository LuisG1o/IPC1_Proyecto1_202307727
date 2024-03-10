package vista;

import controlador.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class PacientePanel extends JPanel {
    DefaultTableModel model = new DefaultTableModel();

    public PacientePanel() {
        initComponent();
    }

    private void initComponent() {
        setLayout(new BorderLayout());

        // Panel principal que contiene la tabla y los botones
        JPanel pacientesPanel = new JPanel(null);
        pacientesPanel.setPreferredSize(new Dimension(800, 400));

        JLabel titleLabel = new JLabel("Pacientes");
        titleLabel.setBounds(250, 10, 380, 30);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        pacientesPanel.add(titleLabel);

        String[] colPac = {"Codigo", "Nombre", "Apellido", "Genero", "Edad"};
        JTable pacientesTable = new JTable(UsuarioDAO.convertir(), colPac);
        JScrollPane tableScrollPane = new JScrollPane(pacientesTable);
        tableScrollPane.setBounds(250, 50, 380, 200);
        pacientesPanel.add(tableScrollPane);

        // Botones para acciones relacionadas con pacientes
        JPanel btnPanelPaciente = new JPanel(null);
        btnPanelPaciente.setBounds(300, 260, 380, 50);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 10, 80, 30);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(100, 10, 80, 30);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(190, 10, 80, 30);

        btnPanelPaciente.add(btnAgregar);
        btnPanelPaciente.add(btnModificar);
        btnPanelPaciente.add(btnEliminar);
        pacientesPanel.add(btnPanelPaciente);

        // Agregar el panel principal al centro del PacientePanel
        add(pacientesPanel, BorderLayout.CENTER);

        btnAgregar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(PacientePanel.this);
            CrearPaciente crearPaciente = new CrearPaciente("", model);
            window.dispose();
        });
        btnModificar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(PacientePanel.this);
            ActualizarPaciente actualizarPaciente = new ActualizarPaciente("Actualizar Paciente");
            window.dispose();
        });
        btnEliminar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(PacientePanel.this);
            EliminarPaciente eliminarPaciente = new EliminarPaciente("Eliminar Paciente");
            window.dispose();
        });
    }
}
