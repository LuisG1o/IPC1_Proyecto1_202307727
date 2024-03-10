package vista;

import controlador.DoctorDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class DoctorPanel extends JPanel {
    DefaultTableModel model = new DefaultTableModel();

    public DoctorPanel() {
        initComponent();
    }

    private void initComponent() {
        setLayout(null);

        // Panel principal que contiene la tabla y el gráfico
        JPanel productosPanel = new JPanel(null);
        productosPanel.setBounds(10, 10, 800, 400);

        JLabel titleLabel = new JLabel("Lista de Productos");
        titleLabel.setBounds(10, 10, 380, 30);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        productosPanel.add(titleLabel);

        String[] colDoc = {"Codigo", "Nombre", "Apellido", "Genero", "Edad", "Especialidad", "Telefono"};
        JTable productosTable = new JTable(DoctorDAO.convertir(), colDoc);
        JScrollPane tableScrollPane = new JScrollPane(productosTable);
        tableScrollPane.setBounds(10, 50, 380, 200);
        productosPanel.add(tableScrollPane);

        // Botones para acciones relacionadas con productos
        JPanel btnPanelProducto = new JPanel(null);
        btnPanelProducto.setBounds(10, 260, 380, 50);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 10, 80, 30);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(100, 10, 80, 30);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(190, 10, 80, 30);

        btnPanelProducto.add(btnAgregar);
        btnPanelProducto.add(btnModificar);
        btnPanelProducto.add(btnEliminar);
        productosPanel.add(btnPanelProducto);

        // Gráfico de barras de cantidad de productos por nombre
        CategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Docotores", // Título del gráfico
                "Nombre", // Etiqueta del eje X
                "Cantidad", // Etiqueta del eje Y
                dataset // Conjunto de datos
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(420, 10, 400, 300);
        productosPanel.add(chartPanel);

        // Agregar el panel principal al ProductoPanel
        add(productosPanel);

        btnAgregar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(DoctorPanel.this);
            CrearDoctor crearDoctor = new CrearDoctor("", model);
            window.dispose();
        });
        btnModificar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(DoctorPanel.this);
            ActualizarDoctor actualizarDoctor = new ActualizarDoctor("Actualizar Doctor");
            window.dispose();
        });
        btnEliminar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(DoctorPanel.this);
            EliminarDoctor eliminarDoctor = new EliminarDoctor("Eliminar Doctor");
            window.dispose();
        });
    }

    // Método para crear el conjunto de datos para el gráfico de barras
    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Obtener datos de la tabla de doctores
        Object[][] data = DoctorDAO.convertir();

        // Mapa para realizar el recuento de especialidades
        HashMap<String, Integer> countMap = new HashMap<>();

        // Contar la cantidad de doctores por especialidad
        for (Object[] row : data) {
            String especialidad = row[5].toString();

            // Verificar si la especialidad ya está en el mapa
            if (countMap.containsKey(especialidad)) {
                // Incrementar la cantidad existente
                int count = countMap.get(especialidad);
                countMap.put(especialidad, count + 1);
            } else {
                // Agregar nueva especialidad al mapa
                countMap.put(especialidad, 1);
            }
        }

        // Agregar los valores al conjunto de datos
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.addValue(entry.getValue(), "Doctores", entry.getKey());
        }

        return dataset;
    }
}
