package ej20;
import java.util.LinkedList;


public class RegistroCiudades {

    private LinkedList<String> sucursales;

    public RegistroCiudades() {
        sucursales = new LinkedList<>();
    }


    public void agregarUnaSucursal(String sucursal){
        sucursales.add(sucursal);
    }

    public boolean buscarSucursal (String sucursal){
        return sucursales.contains(sucursal);
    }

    public void quitarSucursal(String sucursal){
        sucursales.remove(sucursal);
    }

    public LinkedList<String> listarSucursales(){
        return sucursales;
    }

    public int indicarCantSucursales(){
        return sucursales.size();

     }
     public boolean estaVacio(){
        return sucursales.isEmpty();
     }

     public void imprimir(String separador){
         for (String sucursale : sucursales) {
             System.out.print(sucursale + separador);


         }
     }



}
