public class ListaLigada<T> {
    private static class Nodo<U> {
        private U data;
        private Nodo<U> siguiente;
        public Nodo(U d){ this.data = d; }
        public U getData(){ return data; }
        public void setData(U d){ this.data = d; }
        public Nodo<U> getSiguiente(){ return siguiente; }
        public void setSiguiente(Nodo<U> s){ this.siguiente = s; }
        @Override public String toString(){ return data + " -> "; }
    }

    Nodo<T> head;
    int tamanio = 0;
    Nodo<T> currNode;

    public ListaLigada() { }

    public boolean estaVacia(){
        return head == null;
    }

    public int getTamanio(){
        return this.tamanio;
    }

    public void agregar(T valor){
        if (this.head == null){
            this.head = new Nodo<>(valor);
        } else {
            currNode = this.head;
            while (currNode.getSiguiente() != null){
                currNode = currNode.getSiguiente();
            }
            currNode.setSiguiente(new Nodo<>(valor));
        }
        this.tamanio++;
    }

    public void agregar_al_final(T valor){
        agregar(valor);
    }

    public void agregar_al_inicio(T valor){
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.setSiguiente(this.head);
        this.head = nuevo;
        this.tamanio++;
    }

    public boolean agregar_despues_de(T referencia, T valor){
        if (this.head == null) return false;

        currNode = this.head;
        while (currNode != null){
            if ((referencia == null && currNode.getData() == null) ||
                (referencia != null && referencia.equals(currNode.getData()))){
                Nodo<T> nuevo = new Nodo<>(valor);
                nuevo.setSiguiente(currNode.getSiguiente());
                currNode.setSiguiente(nuevo);
                this.tamanio++;
                return true;
            }
            currNode = currNode.getSiguiente();
        }
        return false;
    }

    public int buscar(T valor){
        currNode = this.head;
        int contador = 0;
        while (currNode != null){
            if ((valor == null && currNode.getData() == null) ||
                (valor != null && valor.equals(currNode.getData()))){
                return contador;
            }
            contador++;
            currNode = currNode.getSiguiente();
        }
        return -1;
    }

    public boolean actualizar(T actual, T nuevo){
        currNode = this.head;
        while (currNode != null){
            if ((actual == null && currNode.getData() == null) ||
                (actual != null && actual.equals(currNode.getData()))){
                currNode.setData(nuevo);
                return true;
            }
            currNode = currNode.getSiguiente();
        }
        return false;
    }

    public void eliminar(int posicion){
        if (posicion < 0 || posicion >= this.tamanio || this.head == null) return;

        if (posicion == 0){
            eliminar_el_primero();
            return;
        }

        Nodo<T> anterior = this.head;
        int i = 0;
        while (i < posicion - 1){
            anterior = anterior.getSiguiente();
            i++;
        }
        Nodo<T> aEliminar = anterior.getSiguiente();
        anterior.setSiguiente(aEliminar.getSiguiente());
        this.tamanio--;
    }

    public void eliminar_el_primero(){
        if (this.head == null) return;
        this.head = this.head.getSiguiente();
        this.tamanio--;
    }

    public void eliminar_el_final(){
        if (this.head == null) return;

        if (this.head.getSiguiente() == null){
            this.head = null;
            this.tamanio--;
            return;
        }

        Nodo<T> anterior = this.head;
        Nodo<T> actual = this.head.getSiguiente();
        while (actual.getSiguiente() != null){
            anterior = actual;
            actual = actual.getSiguiente();
        }
        anterior.setSiguiente(null);
        this.tamanio--;
    }

    public void trasversal(){
        currNode = this.head;
        while (currNode != null){
            System.out.print(currNode);
            currNode = currNode.getSiguiente();
        }
        System.out.println();
    }
}
