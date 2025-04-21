package co.edu.unipiloto.estdatos.tallerheap.estructuras;
import co.edu.unipiloto.estdatos.tallerheap.mundo.Pedido;
import java.util.ArrayList;
import java.util.Collections;

public class MinHeap implements Heap<Pedido> {
    private ArrayList<Pedido> elementos;

    public MinHeap() {
        elementos = new ArrayList<>();
    }

    @Override
    public void insertar(Pedido p) {
        elementos.add(p);
        int i = elementos.size() - 1;
        while (i > 0 && elementos.get((i - 1) / 2).getCercania() > elementos.get(i).getCercania()) {
            Collections.swap(elementos, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    @Override
    public Pedido eliminar() {
        if (estaVacio()) return null;
        Pedido raiz = elementos.get(0);
        Pedido ultimo = elementos.remove(elementos.size() - 1);
        if (!estaVacio()) {
            elementos.set(0, ultimo);
            heapify(0);
        }
        return raiz;
    }

    private void heapify(int i) {
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
        int menor = i;

        if (izq < elementos.size() && elementos.get(izq).getCercania() < elementos.get(menor).getCercania()) {
            menor = izq;
        }
        if (der < elementos.size() && elementos.get(der).getCercania() < elementos.get(menor).getCercania()) {
            menor = der;
        }
        if (menor != i) {
            Collections.swap(elementos, i, menor);
            heapify(menor);
        }
    }

    @Override
    public Pedido obtener() {
        return estaVacio() ? null : elementos.get(0);
    }

    @Override
    public boolean estaVacio() {
        return elementos.isEmpty();
    }

    @Override
    public int tamano() {
        return elementos.size();
    }

    @Override
    public ArrayList<Pedido> aLista() {
        return new ArrayList<>(elementos);
    }
}
