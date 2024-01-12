package JavaProjects.GUITrials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trial5 extends JFrame implements ActionListener {
    private JTextField dateField, nameField, modelNumberField;
    private JComboBox<String> gradeDropdown;
    private JLabel totalModelsLabel;
    private int totalModels = 0;

    public Trial5() {
        setTitle("Data Storage GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));

        JLabel dateLabel = new JLabel("Date:");
        add(dateLabel);
        dateField = new JTextField();
        add(dateField);

        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        JLabel gradeLabel = new JLabel("Grade:");
        add(gradeLabel);
        String[] grades = {"9", "10", "11", "12"};
        gradeDropdown = new JComboBox<>(grades);
        add(gradeDropdown);

        JLabel modelNumberLabel = new JLabel("Model Number:");
        add(modelNumberLabel);
        modelNumberField = new JTextField();
        add(modelNumberField);

        JButton addButton = new JButton("Add Data");
        addButton.addActionListener(this);
        add(addButton);

        JLabel totalModelsTextLabel = new JLabel("Total Models:");
        add(totalModelsTextLabel);
        totalModelsLabel = new JLabel(String.valueOf(totalModels));
        add(totalModelsLabel);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Data")) {
            String date = dateField.getText();
            String name = nameField.getText();
            String grade = (String) gradeDropdown.getSelectedItem();
            String modelNumber = modelNumberField.getText();

            // Add your logic to store the data here
            // For example, you could print it for demonstration purposes
            System.out.println("Date: " + date + ", Name: " + name + ", Grade: " + grade + ", Model Number: " + modelNumber);

            // Update total models count and label
            if (!modelNumber.isEmpty()) {
                totalModels++;
                totalModelsLabel.setText(String.valueOf(totalModels));
                modelNumberField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Trial5::new);
    }
}
