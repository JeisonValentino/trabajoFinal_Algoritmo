package misClases;

import java.util.ArrayList;

public class ListaProductos {

    private ArrayList<Producto> productos;

    public ListaProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }

    public void eliminarProducto(Producto p) {
        this.productos.remove(p);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void ordenarPorCodigoBurbuja() {
        int n = productos.size();
        Producto temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos.get(j).getCodigo() > productos.get(j + 1).getCodigo()) {
                    temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarPorCodigoSeleccion() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos.get(j).getCodigo() > productos.get(j + 1).getCodigo()) {
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarPorPrecioDesc() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos.get(j).getPrecio() < productos.get(j + 1).getPrecio()) {
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarPorNombre() {
        int izq = 0;
        int der = productos.size() - 1;
        quicksortPorNombre(izq, der);
    }

    private void quicksortPorNombre(int izq, int der) {
        if (izq < der) {
            int indiceStart = particionPorNombre(izq, der);
            quicksortPorNombre(izq, indiceStart - 1);
            quicksortPorNombre(indiceStart + 1, der);
        }
    }

    private int particionPorNombre(int izq, int der) {
        String pivot = productos.get(der).getNombre();
        int i = izq - 1;
        for (int j = izq; j < der; j++) {
            if (productos.get(j).getNombre().compareToIgnoreCase(pivot) <= 0) {
                i++;
                Producto temp = productos.get(i);
                productos.set(i, productos.get(j));
                productos.set(j, temp);
            }
        }
        Producto temp = productos.get(i + 1);
        productos.set(i + 1, productos.get(der));
        productos.set(der, temp);
        return i + 1;
    }

    public void ordenarPorCodigoInsercion() {
        int n = productos.size();
        for (int i = 1; i < n; ++i) {
            Producto clave = productos.get(i);
            int j = i - 1;
            while (j >= 0 && productos.get(j).getCodigo() > clave.getCodigo()) {
                productos.set(j + 1, productos.get(j));
                j = j - 1;
            }
            productos.set(j + 1, clave);
        }
    }

    public Producto buscarPorCodigo(int codigoBuscado) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigoBuscado) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Producto> buscarPorNombre(String nombreBuscado) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                productosEncontrados.add(p);
            }
        }
        return productosEncontrados;
    }

}
