package Laboratorio04.Controlador;

import Laboratorio04.Modelo.Libro;

public class Ordenador {

    public static void burbuja(Libro[] libros) {
        for (int i = 0; i < libros.length - 1; i++) {
            for (int j = 0; j < libros.length - 1 - i; j++) {

                if (libros[j].getCodigo().compareTo(libros[j + 1].getCodigo()) > 0) {
                    Libro temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }

        }
    }

    public static void quickSort(Libro[] libros, int low, int high) {
        if (low < high) {
        int pi = partition(libros, low, high);
        
        quickSort(libros, low, pi - 1);
        quickSort(libros, pi + 1, high);
    }
    }

    private static int partition(Libro[] libros, int low, int high) {
        String pivot = libros[high].getCodigo();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (libros[j].getCodigo().compareTo(pivot) <= 0) {
                i++;

                Libro temp = libros[i];
                libros[i] = libros[j];
                libros[j] = temp;
            }
        }

        Libro temp = libros[i + 1];
        libros[i + 1] = libros[high];
        libros[high] = temp;
        return -1;
    }
}
