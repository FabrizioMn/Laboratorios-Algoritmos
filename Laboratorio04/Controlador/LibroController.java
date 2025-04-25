package Laboratorio04.Controlador;

import Laboratorio04.Modelo.Libro;

public class LibroController {

    public Libro buscarPorTitulo(Libro[] libros, String titulo) {
        
        for (int i = 0; i < libros.length; i++) {
            
            if(libros[i].getTitulo().equalsIgnoreCase(titulo)){
                return libros[i];
            }
            
        }
        
        
        
        return null;
    }


    public Libro buscarPorCodigo(Libro[] libros, String codigo) {
        int min=0;
        int max=libros.length -1;
        int mitad;
        
        while(min<=max){
            
            mitad= (min+max)/2;
            
            if(libros[mitad].getCodigo().equalsIgnoreCase(codigo)){
                return libros[mitad];
            } else if (libros[mitad].getCodigo().compareTo(codigo) <0){
                min= mitad +1;
                
            } else {
                max= mitad-1;
            }
            
            
        }
        
        
        
        return null;
    }
}
