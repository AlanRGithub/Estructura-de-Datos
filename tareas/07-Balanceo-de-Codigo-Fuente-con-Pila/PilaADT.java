public class PilaADT<T> {

    private static class Nodo<E> {
        E dato;
        Nodo<E> sig;
        Nodo(E d, Nodo<E> s) { dato = d; sig = s; }
    }

    private Nodo<T> tope;
    private int size;

    public PilaADT() {
        tope = null;
        size = 0;
    }

    public void push(T x) {
        tope = new Nodo<>(x, tope);
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Pila vacia");
        T x = tope.dato;
        tope = tope.sig;
        size--;
        return x;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Pila vacia");
        return tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int longitud() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[tope -> ");
        Nodo<T> aux = tope;
        while (aux != null) {
            sb.append(aux.dato);
            aux = aux.sig;
            if (aux != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
