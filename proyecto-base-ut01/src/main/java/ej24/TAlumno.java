package ej24;


public class TAlumno implements Comparable<TAlumno>{
    private String nombre;
    private String apellido;
    private int cedula4digitos;


    public TAlumno(int cedula4digitos, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula4digitos = cedula4digitos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCedula4digitos() {
        return cedula4digitos;
    }

    @Override
    public int compareTo(TAlumno otra) {
        return Integer.compare(this.cedula4digitos, otra.cedula4digitos);
    }

    public String toString() {
        return cedula4digitos + " - " + nombre + " " + apellido;
    }

}
