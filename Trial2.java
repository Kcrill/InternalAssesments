package JavaProjects.GUITrials;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// Trial2 class extending JFrame for creating GUI application
public class Trial2 extends JFrame {
    private db dbInstance;
    private ArrayList<DataEntryCsv> dataList;
    private JTextField dateField, modelField, nmbrField, studentField;
    private JComboBox<String> gradeComboBox;
    private JTextArea displayArea;

    // Constructor to initialize the GUI components and set up the application
    public Trial2() {

        super("Data Storage Application");
        dbInstance = new db();
        // Initialize ArrayList to store data entries
        try {
            dataList = dbInstance.read();
        } catch (Exception e) {
            dataList = new ArrayList<>();
            e.printStackTrace();
        }

        // Create components
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField(15);

        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField(15);

        JLabel nmbrLabel = new JLabel("#:");
        nmbrField = new JTextField(15);

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
                String nmbr = nmbrField.getText();
                String student = studentField.getText();
                String selectedGrade = (String) gradeComboBox.getSelectedItem();

                DataEntryCsv newEntry = new DataEntryCsv(date, model, nmbr, student, selectedGrade);
                dataList.add(newEntry);
                try {
                    dbInstance.write(dataList);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
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
        displayData();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Create layout
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
        panel.add(nmbrLabel, gbc);

        gbc.gridx = 1;
        panel.add(nmbrField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(studentLabel, gbc);

        gbc.gridx = 1;
        panel.add(studentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(gradeLabel, gbc);

        gbc.gridx = 1;
        panel.add(gradeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(searchLabel, gbc);

        gbc.gridx = 1;
        panel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
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
        for (DataEntryCsv entry : dataList) {
            displayArea.append("Date: " + entry.getDate() + ", Model: " + entry.getModel() + ", #: " + entry.getNmbr() + ", Student: " + entry.getStudent() + "\n");
        }
    }

    private void searchAndDisplay(String searchText) {
        displayArea.setText("");
        for (DataEntryCsv entry : dataList) {
            if (entry.getDate().toLowerCase().contains(searchText.toLowerCase()) ||
                entry.getModel().toLowerCase().contains(searchText.toLowerCase()) ||
                entry.getStudent().toLowerCase().contains(searchText.toLowerCase())) {
                displayArea.append("Date: " + entry.getDate() + ", Model: " + entry.getModel() + ",#: "+ entry.getNmbr() + " ,Student: " + entry.getStudent() + "\n");
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
