import java.util.Iterator;
import java.util.LinkedHashSet;

public class SetADT<T> implements Iterable<T> {
    private final LinkedHashSet<T> data;

    public SetADT() {
        this.data = new LinkedHashSet<>();
    }

    public int longitud() {
        return data.size();
    }

    public boolean contiene(T elemento) {
        return data.contains(elemento);
    }

    public boolean agregar(T elemento) {
        return data.add(elemento);
    }

    public boolean eliminar(T elemento) {
        return data.remove(elemento);
    }

    public boolean equals(SetADT<T> otro) {
        return otro != null && this.data.equals(otro.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetADT<?>)) return false;
        SetADT<?> that = (SetADT<?>) o;
        return this.data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    public boolean esSubConjunto(SetADT<T> otroConjunto) {
        return otroConjunto != null && otroConjunto.data.containsAll(this.data);
    }

    public SetADT<T> union(SetADT<T> otro) {
        SetADT<T> res = new SetADT<>();
        res.data.addAll(this.data);
        if (otro != null) res.data.addAll(otro.data);
        return res;
    }

    public SetADT<T> interseccion(SetADT<T> otro) {
        SetADT<T> res = new SetADT<>();
        if (otro == null) return res;
        for (T e : this.data) if (otro.data.contains(e)) res.data.add(e);
        return res;
    }

    public SetADT<T> diferencia(SetADT<T> otro) {
        SetADT<T> res = new SetADT<>();
        if (otro == null) { res.data.addAll(this.data); return res; }
        for (T e : this.data) if (!otro.data.contains(e)) res.data.add(e);
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean Agregar(T e){ return agregar(e); }
    public boolean Eliminar(T e){ return eliminar(e); }
    public boolean Equals(SetADT<T> o){ return equals(o); }
    public SetADT<T> Union(SetADT<T> o){ return union(o); }
    public SetADT<T> Diferencia(SetADT<T> o){ return diferencia(o); }

}
