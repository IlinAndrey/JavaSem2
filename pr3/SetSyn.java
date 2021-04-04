package pr3;
import java.util.*;
public class SetSyn<E> implements Set {
    private ArrayList<E> r = new ArrayList<E>();

    public SetSyn(){
    }

    @Override
    public synchronized int size() {
        return r.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return r.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return r.contains((E) o);
    }

    @Override
    public synchronized Iterator iterator() {
        return r.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return r.toArray();
    }

    @Override
    public synchronized boolean add(Object o) {
        return r.add((E) o);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return r.remove((E) o);
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return r.addAll(c);
    }

    @Override
    public synchronized void clear() {
        r.clear();
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return r.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return r.retainAll(c);
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return r.containsAll(c);
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        return r.toArray(a);
    }
}
