import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductSalesApp extends JFrame {

    private JTextArea txtDisplay;
    private JLabel lblYearsProcessed;
    private ProductSales productSales;

    public ProductSalesApp() {
        setTitle("Product Sales Application");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        productSales = new ProductSales();

        txtDisplay = new JTextArea(15, 30);
        txtDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtDisplay);

        lblYearsProcessed = new JLabel("Years Processed: ");

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");
        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 5)
        );
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(lblYearsProcessed, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Menu - Q2.3
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        btnLoad.addActionListener(e -> loadData());
        btnSave.addActionListener(e -> saveData());
        loadItem.addActionListener(e -> loadData());
        saveItem.addActionListener(e -> saveData());
        exitItem.addActionListener(e -> System.exit(0));
        clearItem.addActionListener(e -> clearFields());

        add(mainPanel);
        setVisible(true);
    }

    private void loadData() {
        int total = productSales.GetTotalSales();
        int average = (int) Math.round(productSales.GetAverageSales());
        int over = productSales.GetSalesOverLimit();
        int under = productSales.GetSalesUnderLimit();
        int years = productSales.GetProductsProcessed();

        txtDisplay.setText("");
        txtDisplay.append("Total Sales: " + total + "\n");
        txtDisplay.append("Average Sales: " + average + "\n");
        txtDisplay.append("Sales over limit: " + over + "\n");
        txtDisplay.append("Sales under limit: " + under + "\n");
        lblYearsProcessed.setText("Years Processed: " + years);
    }

    private void saveData() {
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write("DATA LOG\n");
            writer.write("********************************\n");
            writer.write(txtDisplay.getText());
            writer.write("********************************\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file.");
        }
    }

    private void clearFields() {
        txtDisplay.setText("");
        lblYearsProcessed.setText("Years Processed: ");
    }
}