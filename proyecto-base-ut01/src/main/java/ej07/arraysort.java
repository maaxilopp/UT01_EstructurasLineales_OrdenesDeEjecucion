package ej07;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class arraysort{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner;
        try {
            int n = 0;
            int intercambios = 0;
            int contador = 0;
            scanner = new Scanner(new File("proyecto-base-ut01/src/main/java/ej07/numeros.txt"));
            n = scanner.nextInt(); // el tamaño del array depende del primer elemento de la lista
            int[] arreglo = new int[n]; // creo un array (vacio de longitud del primer elemento del archivo)
            for (int i = 0; i < n; i++) {
                arreglo[i] = scanner.nextInt(); // lleno el array con los elementos  del archivo
            }
            System.out.println("Lista original: " + (Arrays.toString(arreglo)));
            for (int u = 0; u < n - 1; u++) {
                for (int j = n - 1; j >= u + 1; j--) {
                    contador += 1;
                    if (arreglo[j - 1] >= arreglo[j]) { // comparo
                        int variable = arreglo[j]; // variable temporal
                        arreglo[j] = arreglo[j - 1]; //intercambio
                        arreglo[j - 1] = variable;
                        intercambios += 1;
                    }
                }
            }
            System.out.println("Lista ordenada: " + (Arrays.toString(arreglo)));
            System.out.println("El primer elemento del archivo (ósea n) es: " + n);
            System.out.println("Cantidad de veces que el loop es evaluado: " + contador);
            System.out.println("Intercambios realizados: " + intercambios);
            System.out.println("Primer elemento del archivo ya limpio: " + arreglo[0]);
            System.out.println("último elemento del archivo ya limpio: " + arreglo[n - 1]);
        } catch(FileNotFoundException e){
            System.out.println("ERROR: archivo no encontrado :(( ");
        }

    }
}
