
package Laboratorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class EmployeeView extends JFrame {
    private JTable table;
    private JComboBox<String> criteriaCombo;
    private JComboBox<String> algorithmCombo;
    private JButton sortButton;

    public EmployeeView() {
        setTitle("Employee Sorting Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Employee List");
        titleLabel.setBounds(20, 10, 200, 25);
        add(titleLabel);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 40, 500, 150);
        add(scrollPane);

        criteriaCombo = new JComboBox<>(new String[]{"Name", "Salary", "Position"});
        criteriaCombo.setBounds(20, 210, 120, 25);
        add(criteriaCombo);

        algorithmCombo = new JComboBox<>(new String[]{"Bubble Sort", "Selection Sort"});
        algorithmCombo.setBounds(150, 210, 150, 25);
        add(algorithmCombo);

        sortButton = new JButton("Sort");
        sortButton.setBounds(320, 210, 100, 25);
        add(sortButton);

        setSize(560, 300);
        setLocationRelativeTo(null);
    }

    public void updateTable(Employee[] employees) {
        String[] columns = {"Name", "Salary", "Position"};
        Object[][] data = new Object[employees.length][3];
        for (int i = 0; i < employees.length; i++) {
            data[i][0] = employees[i].getName();
            data[i][1] = employees[i].getSalary();
            data[i][2] = employees[i].getPosition();
        }
        table.setModel(new DefaultTableModel(data, columns));
    }

    public int getSelectedCriteria() {
        return criteriaCombo.getSelectedIndex();
    }

    public int getSelectedAlgorithm() {
        return algorithmCombo.getSelectedIndex();
    }

    public void addSortButtonListener(ActionListener listener) {
        sortButton.addActionListener(listener);
    }
}
    
