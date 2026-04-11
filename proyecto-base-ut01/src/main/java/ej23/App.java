package ej23;
import ucu.edu.aed.utils.FileUtils;



public class App {
    public static void main(String[] args) {
        pruebaUno();
        pruebaDos();
        pruebaTres();
        pruebaCuatro();
    }
    private static void pruebaUno(){
        RegistroCiudades registro = new RegistroCiudades();
        FileUtils.leerLineas("ej23/suc1.txt", registro::agregarUnaSucursal);
        System.out.println("Resultados de prueba uno: " + registro.indicarCantSucursales()+"\n");

    }

    private static void pruebaDos(){
        RegistroCiudades registro = new RegistroCiudades();
        FileUtils.leerLineas("ej23/suc1.txt", registro::agregarUnaSucursal);
        registro.quitarSucursal("Chicago");
        System.out.print("Resultado de prueba dos: Shenzhen, aca esta el listado: ");
        registro.listarSucursales();
        System.out.println();
        System.out.println("\n");
    }
     private static void pruebaTres (){
         RegistroCiudades registro = new RegistroCiudades();
         FileUtils.leerLineas("ej23/suc2.txt", registro::agregarUnaSucursal);
         registro.quitarSucursal("Shenzhen");
         registro.quitarSucursal("Tokio");
         System.out.println("Resultado de la prueba 3: Queda vacía y no da error de ejecución (respuesta d: ninguna de las anteriores)");
         System.out.println("Cantidad de ciudades: " + registro.indicarCantSucursales() + "\n");

     }

    private static void pruebaCuatro (){
        RegistroCiudades registro = new RegistroCiudades();
        FileUtils.leerLineas("ej23/suc3.txt", linea -> registro.agregarUnaSucursal(linea));
        System.out.print("Resultado de la prueba 4: ");
        registro.imprimir(";");

    }


}
