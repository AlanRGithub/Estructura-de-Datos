public class PruebasListaLigada {
    public static void main(String[] args) {
        ListaLigada<Integer> ll = new ListaLigada<>();

        System.out.println("¿Está vacía? " + ll.estaVacia());

        ll.agregar_al_final(5);
        ll.agregar_al_final(10);
        ll.agregar_al_final(15);

        ll.agregar_al_inicio(1);

        boolean okDespues = ll.agregar_despues_de(10, 11);
        System.out.println("agregar_despues_de(10, 11) = " + okDespues);

        System.out.print("Lista: ");
        ll.trasversal();

        System.out.println("Índice de 11: " + ll.buscar(11));

        System.out.println("Actualizar 15 -> 16: " + ll.actualizar(15, 16));
        System.out.print("Lista: ");
        ll.trasversal();

        ll.eliminar(0);
        System.out.print("Después de eliminar(0): ");
        ll.trasversal();

        ll.eliminar(2);
        System.out.print("Después de eliminar(2): ");
        ll.trasversal();

        ll.eliminar_el_primero();
        System.out.print("Después de eliminar_el_primero(): ");
        ll.trasversal();

        ll.eliminar_el_final();
        System.out.print("Después de eliminar_el_final(): ");
        ll.trasversal();

        System.out.println("Tamaño actual: " + ll.getTamanio());
        System.out.println("¿Está vacía? " + ll.estaVacia());
    }
}
