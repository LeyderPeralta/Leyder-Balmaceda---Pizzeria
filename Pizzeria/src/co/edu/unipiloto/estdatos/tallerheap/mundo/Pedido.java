package co.edu.unipiloto.estdatos.tallerheap.mundo;
public class Pedido {
    private String autorPedido;
    private double precio;
    private int cercania;

    public Pedido(String autorPedido, double precio, int cercania) {
        this.autorPedido = autorPedido;
        this.precio = precio;
        this.cercania = cercania;
    }

    public String getAutorPedido() {
        return autorPedido;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCercania() {
        return cercania;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "autor='" + autorPedido + '\'' +
                ", precio=" + precio +
                ", cercania=" + cercania +
                '}';
    }
}
