package ej17;
import ej17.implementaciones.Biblioteca;
import ej17.implementaciones.EnumTipoTramite;
import ej17.implementaciones.Libro;
import ucu.edu.aed.utils.FileUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        cargarAdquisiciones(biblioteca);
        procesarPrestamos(biblioteca);
        mostrarCatalogo(biblioteca);
    }
    private static void cargarAdquisiciones(Biblioteca biblioteca) {
        FileUtils.leerLineas("ej17/adquisiciones.txt", linea -> {
        String[] partes = linea.split(",");
            if (partes.length < 4) return;
            try {
                String codigo = partes[0].trim();
                String titulo = partes[1].trim();
                double precio = Double.parseDouble(partes[2].trim());
                int stock = Integer.parseInt(partes[3].trim());
                biblioteca.agregarLibro(new Libro(titulo, codigo, precio, stock));
            } catch(NumberFormatException e){
                System.out.println("Error al procesar esta linea, el formato es inválido. :((");
            }
        });
    }
    private static void procesarPrestamos(Biblioteca biblioteca) {
        System.out.println("\nTRAMITES QUE FUERON REALIZADOS EN LA BIBLIOTECA RECIENTEMENTE\n");
        FileUtils.leerLineas("ej17/prestamos.txt", linea -> {
            String[] partes = linea.split(",");
            if (partes.length < 3) return;
            try {
                String codigo = partes[0].trim();
                String tipo = partes[1].trim();
                int cantidad = Integer.parseInt(partes[2].trim());
                Libro existente = biblioteca.buscarLibro(codigo);
                if (existente == null) {
                    System.out.println("No encontrado: " + codigo);
                    return;
                }
                EnumTipoTramite tipoTramite = EnumTipoTramite.valueOf(tipo.toUpperCase());

            if (tipoTramite == EnumTipoTramite.PRESTAMO) {

                int stockAntes = existente.getStock();
                boolean ok = biblioteca.prestarLibro(codigo, cantidad); // con la lógica "hasta donde alcance"
                int stockDespues = existente.getStock();

                if (ok) {
                    int prestado = stockAntes - stockDespues;
                    System.out.println("PRESTAMO: " + existente.getTitulo()
                            + " | Solicitado: " + cantidad
                            + " | Prestado: " + prestado
                            + " | Stock restante: " + stockDespues);
                } else {
                    // ok == false => no prestó nada (libro no existe o stock 0 o cantidad <= 0)
                    System.out.println("SIN STOCK: " + existente.getTitulo());
                }

            } else if (tipoTramite == EnumTipoTramite.DEVOLUCION) {
                biblioteca.devolverLibro(codigo, cantidad);
                System.out.println("DEVOLUCION: " + existente.getTitulo()
                        + " | Stock actualizado: " + existente.getStock());
            }
            } catch(NumberFormatException e){
                System.out.println("En esta linea de prestamos hay un error de formato en el texto ingresado:(");
            }catch(IllegalArgumentException e){
                System.out.println("El tramite ingresado en esta linea no existe en la biblioteca :(, solo aceptamos PRESTAMO o DEVOLUCION.");
            }
        });
    }
    private static void mostrarCatalogo(Biblioteca biblioteca) {
        System.out.println("\nCATÁLOGO ACTUALIZADO DE LIBROS EN LA BIBLIOTECA\n");

        List<Libro> libros = new ArrayList<>();
        for (int i = 0; i < biblioteca.getCatalogo().tamaño(); i++) {
            libros.add(biblioteca.getCatalogo().obtener(i));
        }

        libros.sort(Comparator.comparing(Libro::getTitulo, String.CASE_INSENSITIVE_ORDER));

        for (Libro libro : libros) {
            System.out.println("Titulo: " + libro.getTitulo()
                    + " | Codigo: " + libro.getCodigo()
                    + " | Precio: " + libro.getPrecio()
                    + " | Stock: " + libro.getStock());
        }
    }
}