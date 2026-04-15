package ej23;
import ucu.edu.aed.impl.ListaEnlazada;

public class RegistroCiudades {

    private ListaEnlazada<String> sucursales;

    public RegistroCiudades() {
        sucursales = new ListaEnlazada<>();
    }


    public void agregarUnaSucursal(String sucursal){
        sucursales.agregar(sucursal);
    }

    public boolean buscarSucursal (String sucursal){
        return sucursales.contiene(sucursal);
    }

    public void quitarSucursal(String sucursal){
        sucursales.remover(sucursal);
    }

    public void listarSucursales(){
        for (int i = sucursales.tamaño() - 1; i >= 0; i--) {
            System.out.print(sucursales.obtener(i) + " , ");
        }
    }

    public int indicarCantSucursales(){
        return sucursales.tamaño();

     }
     public boolean estaVacio(){
        return sucursales.esVacio();
     }

     public void imprimir(String separador){
         for (int i = 0; i < sucursales.tamaño(); i++) {
             System.out.print(sucursales.obtener(i) + separador);


         }
     }



}
