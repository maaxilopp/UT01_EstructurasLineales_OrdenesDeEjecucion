package ej20;
import java.util.LinkedList;


public class RegistroCiudades {
    LinkedList<String> sucursales = new LinkedList<>();

    public void agregarUnaSucursal(String sucursal){
        sucursales.add(sucursal);
    }

    public boolean buscarSucursal (String sucursal){
        return sucursales.contains(sucursal);
    }

    public void quitarSucursal(String sucursal){
        sucursales.remove(sucursal);
    }

    public LinkedList<String> listarSucursales(LinkedList<String> sucursales){
        return sucursales;
    }
    public int indicarCantSucursales(){
        return sucursales.size();

     }
     public boolean estaVacio(){
        return sucursales.isEmpty();
     }



}
