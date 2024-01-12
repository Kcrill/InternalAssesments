package JavaProjects.GUITrials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class DataEntry {
    private String date;
    private String model;
    private String student;
    private String grade;

    public DataEntry(String date, String model, String student, String grade) {
        this.date = date;
        this.model = model;
        this.student = student;
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public String getModel() {
        return model;
    }

    public String getStudent() {
        return student;
    }

    public String getGrade() {
        return grade;
    }
}

public class Trial4 extends JFrame {
    private ArrayList<DataEntry> dataList;
    private JTextField dateField, modelField, studentField;
    private JComboBox<String> gradeDropdown;
    private JTextArea displayArea;

    public Trial4() {
        super("Data Storage Application");

        dataList = new ArrayList<>();

        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField(15);

        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField(15);

        JLabel studentLabel = new JLabel("Student:");
        studentField = new JTextField(15);

        JLabel gradeLabel = new JLabel("Grade:");
        String[] gradeOptions = {"9", "10", "11", "12"};
        gradeDropdown = new JComboBox<>(gradeOptions);

        JButton addButton = new JButton("Add Data");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText();
                String model = modelField.getText();
                String student = studentField.getText();
                String selectedGrade = (String) gradeDropdown.getSelectedItem();

                DataEntry newEntry = new DataEntry(date, model, student, selectedGrade);
                dataList.add(newEntry);

                displayData();
            }
        });

        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField(15);
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                searchAndDisplay(searchText);
            }
        });

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(dateLabel, gbc);

        gbc.gridx = 1;
        panel.add(dateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(modelLabel, gbc);

        gbc.gridx = 1;
        panel.add(modelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(studentLabel, gbc);

        gbc.gridx = 1;
        panel.add(studentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(gradeLabel, gbc);

        gbc.gridx = 1;
        panel.add(gradeDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(searchLabel, gbc);

        gbc.gridx = 1;
        panel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayData() {
        displayArea.setText("");
        for (DataEntry entry : dataList) {
            displayArea.append("Date: " + entry.getDate() + ", Model: " + entry.getModel() + ", Student: " + entry.getStudent() + ", Grade: " + entry.getGrade() + "\n");
        }
    }

    private void searchAndDisplay(String searchText) {
        displayArea.setText("");
        for (DataEntry entry : dataList) {
            if (entry.getDate().toLowerCase().contains(searchText.toLowerCase()) ||
                entry.getModel().toLowerCase().contains(searchText.toLowerCase()) ||
                entry.getStudent().toLowerCase().contains(searchText.toLowerCase()) ||
                entry.getGrade().toLowerCase().contains(searchText.toLowerCase())) {
                displayArea.append("Date: " + entry.getDate() + ", Model: " + entry.getModel() + ", Student: " + entry.getStudent() + ", Grade: " + entry.getGrade() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Trial2();
            }
        });
    }
}

