package examprep.adt;

public interface ADTSet<T> {

    T head();

    ADTSet<T> tail();

    boolean is_empty();

    ADTSet<T> insert(T item);

    boolean is_in(T item);

    int size();

    ADTSet<T> union(ADTSet<T> other);

    ADTSet<T> intersect(ADTSet<T> other);
}
