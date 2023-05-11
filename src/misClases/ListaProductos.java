package misClases;

import java.util.ArrayList;
import java.util.List;

public class ListaProductos {

    public ArrayList<Producto> productos;

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

    //Burbuja
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

    //Seleccion
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

    //Burbuja
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

    //Quicksort
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

    //Insercion
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

    public void ordenarPorPrecioAsc() {
        mergesortPorPrecioAsc(0, productos.size() - 1);
    }

    private void mergesortPorPrecioAsc(int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;

            mergesortPorPrecioAsc(inicio, medio);
            mergesortPorPrecioAsc(medio + 1, fin);

            mergePorPrecioAsc(inicio, medio, fin);
        }
    }

    private void mergePorPrecioAsc(int inicio, int medio, int fin) {
        int longitudIzquierda = medio - inicio + 1;
        int longitudDerecha = fin - medio;

        ArrayList<Producto> izquierda = new ArrayList<>();
        ArrayList<Producto> derecha = new ArrayList<>();

        for (int i = 0; i < longitudIzquierda; i++) {
            izquierda.add(productos.get(inicio + i));
        }
        for (int j = 0; j < longitudDerecha; j++) {
            derecha.add(productos.get(medio + 1 + j));
        }

        int i = 0, j = 0;
        int k = inicio;
        while (i < longitudIzquierda && j < longitudDerecha) {
            if (izquierda.get(i).getPrecio() <= derecha.get(j).getPrecio()) {
                productos.set(k, izquierda.get(i));
                i++;
            } else {
                productos.set(k, derecha.get(j));
                j++;
            }
            k++;
        }

        while (i < longitudIzquierda) {
            productos.set(k, izquierda.get(i));
            i++;
            k++;
        }

        while (j < longitudDerecha) {
            productos.set(k, derecha.get(j));
            j++;
            k++;
        }
    }

    //Busqueda Lineal
    public int buscarProductoPorNombre(List<Producto> productos, String nombreProducto) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNombre().equals(nombreProducto)) {
                return i; // Retorna el índice del producto encontrado
            }
        }
        return -1; // Retorna -1 si el producto no se encuentra en la lista
    }
}
