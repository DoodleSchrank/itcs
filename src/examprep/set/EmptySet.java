package examprep.set;

public class EmptySet<T> implements ADTSet<T> {
    public EmptySet() {
    }

    @Override
    public T head() {
        throw new UnsupportedOperationException("Empty set has no head!");
    }

    @Override
    public ADTSet<T> tail() {
        throw new UnsupportedOperationException("Empty set has no tail!");
    }

    @Override
    public boolean is_empty() {
        return true;
    }

    @Override
    public ADTSet<T> insert(T item) {
        return new Set<>(item, this);
    }

    @Override
    public boolean is_in(T item) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ADTSet<T> union(ADTSet<T> other) {
        return other;
    }

    @Override
    public ADTSet<T> intersect(ADTSet<T> other) {
        return this;
    }

    @Override
    public String toString() {
        return "[]";
    }
}
