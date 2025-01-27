package examprep.nat;

public interface ADTNat {

    boolean isZero();

    ADTNat suc();

    ADTNat pred();

    ADTNat add(ADTNat nat);

    boolean equals(ADTNat nat);

    int compareTo(ADTNat nat);

    ADTNat sub(ADTNat nat);

    ADTNat mult(ADTNat nat);

    ADTNat div(ADTNat nat);

    ADTNat mod(ADTNat nat);

    boolean even();
}
