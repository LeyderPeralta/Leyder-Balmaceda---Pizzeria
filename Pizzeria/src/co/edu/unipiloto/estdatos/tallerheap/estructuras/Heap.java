package co.edu.unipiloto.estdatos.tallerheap.estructuras;
 import java.util.ArrayList;

public interface Heap<T> {
    void insertar(T elemento);
    T eliminar();
    T obtener();
    boolean estaVacio();
    int tamano();
    ArrayList<T> aLista();
}