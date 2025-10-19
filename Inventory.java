package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Inventory extends JFrame {
    private ArrayList<String> items = new ArrayList<>();
    private JTextField itemField;
    private JTextArea displayArea;

    public Inventory() {
        // Window title
        setTitle("Simple Inventory Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel label = new JLabel("Enter Item:");
        itemField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton clearButton = new JButton("Clear");
        displayArea = new JTextArea(300, 100);
        displayArea.setEditable(false);

        // Panel to hold input + buttons
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(itemField);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(clearButton);

        // Scroll pane for display
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add panel and text area to frame
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(e -> addItem());
        viewButton.addActionListener(e -> viewItems());
        clearButton.addActionListener(e -> clearItems());
    }

    // Add item to list
    private void addItem() {
        String item = itemField.getText().trim();
        if (!item.isEmpty()) {
            items.add(item);
            displayArea.append("Added: " + item + "\n");
            itemField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter an item!");
        }
    }

    // View all items
    private void viewItems() {
        displayArea.setText("Inventory List:\n");
        for (String item : items) {
            displayArea.append("- " + item + "\n");
        }
    }

    // Clear all items
    private void clearItems() {
        items.clear();
        displayArea.setText("Inventory cleared.\n");
    }

    // Main method to run
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Inventory().setVisible(true));
    }
}
