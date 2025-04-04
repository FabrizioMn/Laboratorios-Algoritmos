
package Laboratorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {
    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view) {
        this.model = model;
        this.view = view;
        view.updateTable(model.getEmployees());

        view.addSortButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortEmployees();
            }
        });
    }

    private void sortEmployees() {
        int criteria = view.getSelectedCriteria();
        int algorithm = view.getSelectedAlgorithm();

        if (criteria == 0 && algorithm == 0) model.sortByNameBubble();
        else if (criteria == 0) model.sortByNameSelection();
        else if (criteria == 1 && algorithm == 0) model.sortBySalaryBubble();
        else if (criteria == 1) model.sortBySalarySelection();
        else if (criteria == 2 && algorithm == 0) model.sortByPositionBubble();
        else model.sortByPositionSelection();

        view.updateTable(model.getEmployees());
    }
}
