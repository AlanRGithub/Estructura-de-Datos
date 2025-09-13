public class PruebasSet {
    public static void main(String[] args) {
        SetADT<Integer> a = new SetADT<>();
        a.agregar(2); a.agregar(2); a.agregar(23); a.agregar(22); a.agregar(11); a.agregar(22);
        System.out.println("a = " + a + " | longitud=" + a.longitud());

        System.out.println("contiene 23? " + a.contiene(23));
        System.out.println("contiene 99? " + a.contiene(99));

        System.out.println("eliminar 22 -> " + a.eliminar(22));
        System.out.println("a = " + a + " | longitud=" + a.longitud());

        SetADT<Integer> b = new SetADT<>();
        b.agregar(11); b.agregar(2); b.agregar(23);
        System.out.println("a.equals(b)? " + a.equals(b));

        SetADT<Integer> c = new SetADT<>();
        c.agregar(2); c.agregar(11);
        System.out.println("c esSubConjunto de a? " + c.esSubConjunto(a));

        SetADT<Integer> d = new SetADT<>();
        d.agregar(100); d.agregar(2);
        SetADT<Integer> u = a.union(d);
        System.out.println("a U d = " + u);

        System.out.println("interseccion(a, d) = " + a.interseccion(d));

        System.out.println("a \\ d = " + a.diferencia(d));
    }
}
