package JavaProjects.GUITrials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Trial3 extends JFrame {
    private JTextField dateField, studentField;
    private JComboBox<String> modelDropdown, gradeDropdown;
    private JButton addButton;
    private Map<String, Integer> modelCounts;

    public Trial3() {
        setTitle("Grade Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        
        // Components for data input
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField();
        JLabel modelLabel = new JLabel("Model:");
        modelDropdown = new JComboBox<>();
        JLabel studentLabel = new JLabel("Student:");
        studentField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        gradeDropdown = new JComboBox<>(new String[]{"9", "10", "11", "12"});
        
        // Button to add data
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addData();
            }
        });
        
        // Adding components to the frame
        add(dateLabel);
        add(dateField);
        add(modelLabel);
        add(modelDropdown);
        add(studentLabel);
        add(studentField);
        add(gradeLabel);
        add(gradeDropdown);
        add(new JLabel());
        add(addButton);

        // Simulated data for model dropdown
        modelDropdown.addItem("Model A");
        modelDropdown.addItem("Model B");
        modelDropdown.addItem("Model C");

        // Initializing model counts
        modelCounts = new HashMap<>();
        modelCounts.put("Model A", 10); // Initial count of Model A
        modelCounts.put("Model B", 15); // Initial count of Model B
        modelCounts.put("Model C", 20); // Initial count of Model C

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addData() {
        String date = dateField.getText();
        String model = modelDropdown.getSelectedItem().toString();
        String student = studentField.getText();
        String grade = gradeDropdown.getSelectedItem().toString();

        // Validation and storing data
        if (!date.isEmpty() && !student.isEmpty()) {
            // Check if the selected model count is greater than zero before adding
            if (modelCounts.getOrDefault(model, 0) > 0) {
                // Decrease the count of the selected model
                modelCounts.put(model, modelCounts.get(model) - 1);

                // Store data or perform any necessary action
                // For demonstration purposes, printing the entered data
                System.out.println("Date: " + date);
                System.out.println("Model: " + model);
                System.out.println("Student: " + student);
                System.out.println("Grade: " + grade);

                // Notify user about successful addition
                JOptionPane.showMessageDialog(this, "Data added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Model " + model + " is out of stock!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Trial3();
            }
        });
    }
}


