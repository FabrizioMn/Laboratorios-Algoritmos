
package Ejercicio2;


public class ordenBurbuja {
    
        public void orden(String[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j].compareTo(a[j + 1])>0) {

                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
        }
    }
    }
        
         public void imprimir(String a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+"\n");
            
        }
        
    }
        
        
    
    
    
}
