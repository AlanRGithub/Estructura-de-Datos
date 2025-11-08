import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Recursividad {

    public static class BinarySearchTree {
        private static class Nodo {
            int dato;
            Nodo izq;
            Nodo der;
            Nodo(int d){ this.dato = d; }
        }

        private Nodo raiz;
        private int tam;

        public BinarySearchTree(){}

        public int size(){ return tam; }

        public boolean isEmpty(){ return tam == 0; }

        public void Insert(int value){
            if(raiz == null){
                raiz = new Nodo(value);
                tam++;
                return;
            }
            Nodo actual = raiz;
            while(true){
                if(value == actual.dato){
                    return;
                }else if(value < actual.dato){
                    if(actual.izq == null){
                        actual.izq = new Nodo(value);
                        tam++;
                        return;
                    }else{
                        actual = actual.izq;
                    }
                }else{
                    if(actual.der == null){
                        actual.der = new Nodo(value);
                        tam++;
                        return;
                    }else{
                        actual = actual.der;
                    }
                }
            }
        }

        public boolean remove(int value){
            int antes = tam;
            raiz = borrarRec(raiz, value);
            return tam < antes;
        }

        private Nodo borrarRec(Nodo nodo, int value){
            if(nodo == null) return null;
            if(value < nodo.dato){
                nodo.izq = borrarRec(nodo.izq, value);
                return nodo;
            }else if(value > nodo.dato){
                nodo.der = borrarRec(nodo.der, value);
                return nodo;
            }else{
                tam--;
                if(nodo.izq == null && nodo.der == null){
                    return null;
                }else if(nodo.izq == null){
                    return nodo.der;
                }else if(nodo.der == null){
                    return nodo.izq;
                }else{
                    Nodo sucesor = nodo.der;
                    while(sucesor.izq != null) sucesor = sucesor.izq;
                    nodo.dato = sucesor.dato;
                    nodo.der = borrarRec(nodo.der, sucesor.dato);
                    return nodo;
                }
            }
        }

        public Nodo search(int value){
            Nodo actual = raiz;
            while(actual != null){
                if(value == actual.dato) return actual;
                if(value < actual.dato) actual = actual.izq; else actual = actual.der;
            }
            return null;
        }

        public List<Integer> transversal(String format){
            List<Integer> res = new ArrayList<>();
            String f = format == null ? "" : format.trim().toLowerCase(Locale.ROOT);
            if(f.equals("preorden") || f.equals("preorder")){
                pre(raiz, res);
            }else if(f.equals("postorden") || f.equals("postorder")){
                post(raiz, res);
            }else{
                in(raiz, res);
            }
            return res;
        }

        private void pre(Nodo n, List<Integer> out){
            if(n==null) return;
            out.add(n.dato);
            pre(n.izq, out);
            pre(n.der, out);
        }

        private void in(Nodo n, List<Integer> out){
            if(n==null) return;
            in(n.izq, out);
            out.add(n.dato);
            in(n.der, out);
        }

        private void post(Nodo n, List<Integer> out){
            if(n==null) return;
            post(n.izq, out);
            post(n.der, out);
            out.add(n.dato);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] datos = {8, 3, 10, 1, 6, 14, 4, 7, 13, 6, 3, 10};
        for(int x: datos) bst.Insert(x);
        System.out.println(bst.transversal("inorden"));
        System.out.println(bst.transversal("preorden"));
        System.out.println(bst.transversal("postorden"));
        System.out.println(bst.search(7) != null);
        System.out.println(bst.search(2) != null);
        bst.remove(3);
        System.out.println(bst.transversal("inorden"));
    }
}
