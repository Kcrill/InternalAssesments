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

public class Trial8 extends JFrame {
    private ArrayList<DataEntry> dataList;
    private JTextField dateField, modelField, studentField;
    private JComboBox<String> gradeComboBox;
    private JTextArea displayArea;

    // New components for sorting and displaying data
    private JLabel modelSortLabel, totalCountLabel, usedCountLabel, unusedCountLabel;
    private int totalCount = 0;
    private int usedCount = 0;

    public Trial8() {
        dataList = new ArrayList<>();

        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField(15);

        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField(15);

        JLabel studentLabel = new JLabel("Student:");
        studentField = new JTextField(15);

        JLabel gradeLabel = new JLabel("Grade:");
        String[] grades = {"9", "10", "11", "12"};
        gradeComboBox = new JComboBox<>(grades);

        JButton addButton = new JButton("Add Data");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText();
                String model = modelField.getText();
                String student = studentField.getText();
                String selectedGrade = (String) gradeComboBox.getSelectedItem();

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

        JScrollPane scrollPane = new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        modelSortLabel = new JLabel("Model");
        totalCountLabel = new JLabel("Total Count: 0");
        usedCountLabel = new JLabel("Used: 0");
        unusedCountLabel = new JLabel("Unused: 0");

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
        panel.add(gradeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
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

        JPanel sortingPanel = new JPanel(new GridLayout(0, 1));
        sortingPanel.setBorder(BorderFactory.createTitledBorder("Data Sorting & Display"));

        sortingPanel.add(modelSortLabel);
        sortingPanel.add(totalCountLabel);
        sortingPanel.add(usedCountLabel);
        sortingPanel.add(unusedCountLabel);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        panel.add(sortingPanel, gbc);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateCounts() {
        totalCount = dataList.size();
        usedCount = dataList.size();
        totalCountLabel.setText("Total Count: " + totalCount);
        usedCountLabel.setText("Used: " + usedCount);
        unusedCountLabel.setText("Unused: " + (totalCount - usedCount));
    }

    private void displayData() {
        displayArea.setText("");
        for (DataEntry entry : dataList) {
            displayArea.append("Date: " + entry.getDate() + ", Model: " + entry.getModel() + ", Student: " + entry.getStudent() + ", Grade: " + entry.getGrade() + "\n");
        }
        updateCounts();
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
        updateCounts();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Trial8();
            }
        });
    }
}



