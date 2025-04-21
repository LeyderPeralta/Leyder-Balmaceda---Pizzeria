package co.edu.unipiloto.estdatos.tallerheap.mundo;

import co.edu.unipiloto.estdatos.tallerheap.estructuras.Heap;
import co.edu.unipiloto.estdatos.tallerheap.estructuras.MaxHeap;
import co.edu.unipiloto.estdatos.tallerheap.estructuras.MinHeap;

import java.util.ArrayList;

public class Pizzeria {

    // Definición de constantes (si las necesitas)
    public static final String RECIBIR_PEDIDO = "RECIBIR";
    public static final String ATENDER_PEDIDO = "ATENDER";
    public static final String DESPACHAR_PEDIDO = "DESPACHAR";

    private Heap<Pedido> pedidosRecibidos;
    private Heap<Pedido> pedidosAtendidos;

    public Pizzeria() {
        pedidosRecibidos = new MaxHeap(); // Usando el MaxHeap
        pedidosAtendidos = new MinHeap(); // Usando el MinHeap
    }

    public void agregarPedido(String nombreAutor, double precio, int cercania) {
        Pedido nuevo = new Pedido(nombreAutor, precio, cercania);
        pedidosRecibidos.insertar(nuevo);
    }

    public Pedido atenderPedido() {
        Pedido p = pedidosRecibidos.eliminar();
        if (p != null) pedidosAtendidos.insertar(p);
        return p;
    }

    public Pedido despacharPedido() {
        return pedidosAtendidos.eliminar();
    }

    public ArrayList<Pedido> pedidosRecibidosList() {
        return pedidosRecibidos.aLista();
    }

    public ArrayList<Pedido> colaDespachosList() {
        return pedidosAtendidos.aLista();
    }

    // Método para procesar comandos (probablemente utilizado en tu clase Main)
    public void procesarComando(String comando) {
        switch (comando) {
            case RECIBIR_PEDIDO:
                System.out.println("Recibiendo pedido...");
                // Lógica para recibir pedido
                break;
            case ATENDER_PEDIDO:
                Pedido atendido = atenderPedido();
                System.out.println("Pedido atendido: " + atendido);
                break;
            case DESPACHAR_PEDIDO:
                Pedido despachado = despacharPedido();
                System.out.println("Pedido despachado: " + despachado);
                break;
            default:
                System.out.println("Comando no reconocido.");
        }
    }
}
