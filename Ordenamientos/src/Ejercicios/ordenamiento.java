
package Ejercicios;


public class ordenamiento {
    
     public void ordenarAscendente(int a[]){
        
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
     
      public void ordenarDescendente(int a[]){
        
        for (int i = 0; i < a.length -1; i++) {
            int indexMax=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j]> a[indexMax]){
                    indexMax= j;
                }
                
            }
            
            int aux = a[indexMax];
            a[indexMax]=a[i];
            a[i]=aux;   
        } 
        
    }
      
      
      public void imprimir(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+"\n");
            
        }
        
    }
    
}
