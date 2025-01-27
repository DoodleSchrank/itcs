package examprep.adt;

public class Set<T> implements ADTSet<T> {
    private final T head;
    private final ADTSet<T> tail;

    public Set(T head, ADTSet<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public ADTSet<T> tail() {
        return tail;
    }

    @Override
    public boolean is_empty() {
        return false;
    }

    @Override
    public ADTSet<T> insert(T item) {
        if (this.contains(item)) {
            return this;
        }

        return new Set<>(item, this);
    }

    @Override
    public boolean is_in(T item) {
        if (this.head.equals(item)) {
            return true;
        }

        return tail.is_in(item);
    }

    // just for readability in insert and intersect
    public boolean contains(T item) {
        return this.is_in(item);
    }

    @Override
    public int size() {
        return tail.size() + 1;
    }

    @Override
    public ADTSet<T> union(ADTSet<T> other) {
        if (other.is_empty()) return this;
        return this.insert(other.head())
                .union(other.tail());
    }

    @Override
    public ADTSet<T> intersect(ADTSet<T> other) {
        if (other.is_empty()) return new EmptySet<>();
        return this.contains(other.head())
                ? this.intersect(other.tail()).insert(other.head())
                : this.intersect(other.tail());
    }

    @Override
    public String toString() {
        return tail.toString() + ", " + this.head.toString();
    }

    public static void main(String[] args) {
        var set1 = new EmptySet<Integer>().insert(1).insert(2).insert(3).insert(4).insert(5).insert(1);
        var set2 = new EmptySet<Integer>().insert(3).insert(4).insert(5).insert(6).insert(6).insert(6);
        System.out.println(set1.toString());
        System.out.println(set2.toString());
        System.out.println("intersect: " + set2.intersect(set1).toString());
        System.out.println("union: " + set2.union(set1).toString());
    }
}
