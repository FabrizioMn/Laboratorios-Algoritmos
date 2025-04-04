
package Laboratorio;


    public class EmployeeModel {
    private Employee[] employees;

    public EmployeeModel() {
        employees = new Employee[] {
            new Employee("Alice", 5000, "Analyst"),
            new Employee("Bob", 4000, "Developer"),
            new Employee("Charlie", 6000, "Manager"),
            new Employee("Diana", 4500, "Support"),
            new Employee("Edward", 5500, "Tester")
        };
    }

    public Employee[] getEmployees() {
        return employees;
    }

    // TODO: Implementar los métodos de ordenamiento
    public void sortByNameBubble() {
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length - 1; j++) {
                if (employees[j].getName().compareTo(employees[j + 1].getName())>0) {

                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
        }
    }
    }
    public void sortBySalaryBubble() {
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length - 1; j++) {
                if (employees[j].getSalary() > employees[j + 1].getSalary()) {
                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
            }
        }
        
    
    }
    public void sortByPositionBubble() {
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length - 1; j++) {
                if (employees[j].getPosition().compareTo(employees[j + 1].getPosition())>0) {

                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
        }
    }

    }

    
    
    
    
    
    public void sortByNameSelection() {
        for (int i = 0; i < employees.length -1; i++) {
            int indexMin=i;
            for (int j = i+1; j < employees.length; j++) {
                if(employees[j].getName().compareTo(employees[indexMin].getName())< 0){
                    indexMin= j;
                }
                
            }
            
        Employee temp = employees[indexMin];
        employees[indexMin] = employees[i];
        employees[i] = temp;;   
        } 
    }
    public void sortBySalarySelection() {
        
        for (int i = 0; i < employees.length -1; i++) {
            int indexMin=i;
            for (int j = i+1; j < employees.length; j++) {
                if(employees[j].getSalary()< employees[indexMin].getSalary()){
                    indexMin= j;
                }
                
            }
            
        Employee temp = employees[indexMin];
        employees[indexMin] = employees[i];
        employees[i] = temp;;   
        } 
   
    }
    
    
    
   
    public void sortByPositionSelection() {
        
            for (int i = 0; i < employees.length -1; i++) {
            int indexMin=i;
            for (int j = i+1; j < employees.length; j++) {
                if(employees[j].getPosition().compareTo(employees[indexMin].getPosition())< 0){
                    indexMin= j;
                }
                
            }
            
        Employee temp = employees[indexMin];
        employees[indexMin] = employees[i];
        employees[i] = temp;;   
        }
        
    
    
    
    
    }
}
    

