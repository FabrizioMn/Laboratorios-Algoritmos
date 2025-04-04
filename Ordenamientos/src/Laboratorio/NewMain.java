
package Laboratorio;

import Laboratorio.EmployeeModel;
import javax.swing.SwingUtilities;


public class NewMain {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            EmployeeModel model = new EmployeeModel();
            EmployeeView view = new EmployeeView();
            new EmployeeController(model, view);
            view.setVisible(true);
        });
 
    }
    
}
