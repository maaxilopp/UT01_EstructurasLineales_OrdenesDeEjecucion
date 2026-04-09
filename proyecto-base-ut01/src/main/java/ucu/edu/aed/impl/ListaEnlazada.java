package ucu.edu.aed.impl;
import ucu.edu.aed.tda.TDALista;
import java.util.Comparator;
import java.util.function.Predicate;

public class ListaEnlazada<T> implements TDALista<T> {
    protected Nodo<T> primero;

    public ListaEnlazada() {
        primero = null;

    }


    @Override
    public void agregar(T elem) {
        Nodo<T> nuevo = new Nodo<>(elem);
        if (primero == null) {
            primero = nuevo;
            //  nuevo.setSiguiente(null);
        } else {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }
    }

    @Override
    public void agregar(int index, T elem) {
        Nodo<T> nuevo = new Nodo<>(elem);
        if (index == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);

        }

    }

    @Override
    public T obtener(int index) {
        Nodo<T> actual = primero;
        int contador = 0;
        while (index != contador) {
            contador++;
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    @Override
    public T remover(int index) {
        Nodo<T> actual = primero;
        Nodo<T> anterior = null;
        int contador = 0;

        if (index < 0) {
            throw new IndexOutOfBoundsException("Error, indice a eliminar invalido");
        }
        if (actual == null) {
            throw new IndexOutOfBoundsException("Error, lista vacía ");
        }

        while (contador < index) {
            if (actual.getSiguiente() == null) {
                throw new IndexOutOfBoundsException("Error, indice fuera de rango");
            }
            contador += 1;
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (anterior == null) {
            primero = actual.getSiguiente(); // caso primer elemento
        } else {
            anterior.setSiguiente(actual.getSiguiente());
        }

        return actual.getDato();
    }

    @Override
    public boolean remover(T elem) {

        Nodo<T> actual = primero;
        Nodo<T> anterior = null;

        while (actual != null) { // Mientras no sea el ultimo nodo

            if (actual.getDato().equals(elem)) {

                // Caso es el primero
                if (anterior == null) {
                    primero = actual.getSiguiente();
                }
                // Caso está en el medio o final
                else {
                    anterior.setSiguiente(actual.getSiguiente());
                }

                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    @Override
    public boolean contiene(T elem) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return true;
            }
            actual = actual.getSiguiente();


        }
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        Nodo<T> actual = primero;
        int indice = 0;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return indice; // esta
            }
            actual = actual.getSiguiente();
            indice++;
        }
        return -1; // no esta
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        boolean swap;
        do {
            swap = false;
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                if (comparator.compare(actual.getDato(), actual.getSiguiente().getDato()) > 0) {
                    T temporal = actual.getDato();
                    actual.setDato(actual.getSiguiente().getDato());
                    actual.getSiguiente().setDato(temporal);
                    swap = true;
                }
                actual = actual.getSiguiente();
            }
        } while (swap);

        return this;
    }

    @Override
    public int tamaño() {
        Nodo<T> actual = primero;
        int contador = 0;
        while (actual != null) {
            actual = actual.getSiguiente();
            contador++;
        }
        return contador;
    }


    @Override
    public boolean esVacio() {
        if (primero == null) {
            return true;
        }
        return false;
    }

    @Override
    public void vaciar() {
        primero = null;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (criterio.test(actual.getDato()))
                return actual.getDato();
            actual = actual.getSiguiente();
        }
        return null;
    }
}
