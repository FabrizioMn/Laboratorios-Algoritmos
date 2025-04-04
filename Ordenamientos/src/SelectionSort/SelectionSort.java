
package SelectionSort;


public class SelectionSort {
    
    
    
    public void ordenar(int a[]){
        
        for (int i = 0; i < a.length -1; i++) {
            int indexMin=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j]< a[indexMin]){
                    indexMin= j;
                }
                
            }
            
            int aux = a[indexMin];
            a[indexMin]=a[i];
            a[i]=aux;   
        } 
        
    }
    
    
    public void imprimir(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+"\n");
            
        }
        
    }
    
    
    
    
    
    
}
