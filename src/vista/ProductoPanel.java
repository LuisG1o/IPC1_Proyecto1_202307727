package vista;

import controlador.ProductoDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductoPanel extends JPanel {
    DefaultTableModel model = new DefaultTableModel();

    public ProductoPanel() {
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

        String[] colProduc = {"Codigo", "Nombre", "Cantidad", "Descripcion", "Precio"};
        JTable productosTable = new JTable(ProductoDAO.convertir(), colProduc);
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
                "Productos", // Título del gráfico
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
            Window window = SwingUtilities.getWindowAncestor(ProductoPanel.this);
            CrearProducto crearProducto = new CrearProducto("Agregar Producto", model);
            window.dispose();
        });
        btnModificar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(ProductoPanel.this);
            ActualizarProducto actualizarProducto = new ActualizarProducto("Actualizar Producto");
            window.dispose();
        });
        btnEliminar.addActionListener((ActionEvent e) -> {
            Window window = SwingUtilities.getWindowAncestor(ProductoPanel.this);
            EliminarProducto eliminarProducto = new EliminarProducto("Eliminar Producto");
            window.dispose();
        });
    }

    // Método para crear el conjunto de datos para el gráfico de barras
    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Obtener datos de la tabla de productos
        Object[][] data = ProductoDAO.convertir();

        // Mapa para realizar el recuento de productos por nombre
        for (Object[] row : data) {
            String nombreProducto = row[1].toString(); // Asegúrate de que la columna 1 contenga el nombre del producto
            double cantidadProducto = Double.parseDouble(row[2].toString()); // Asegúrate de que la columna 2 contenga la cantidad

            // Agregar valores al conjunto de datos
            dataset.addValue(cantidadProducto, "Productos", nombreProducto);
        }

        return dataset;
    }
}
