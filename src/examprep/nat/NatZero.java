package examprep.nat;

public class NatZero implements ADTNat {
    public NatZero() {}

    public boolean isZero() {
        return true;
    }

    @Override
    public ADTNat suc() {
        return new Nat(this);
    }

    @Override
    public ADTNat pred() {
        throw new UnsupportedOperationException("0 has no predecessor");
    }

    @Override
    public ADTNat add(ADTNat nat) {
        return nat;
    }

    @Override
    public boolean equals(ADTNat nat) {
        return nat.isZero();
    }

    @Override
    public int compareTo(ADTNat nat) {
        return nat.isZero() ? 0 : 1;
    }

    @Override
    public ADTNat sub(ADTNat nat) {
        throw new UnsupportedOperationException("Can't subtract from 0.");
    }

    @Override
    public ADTNat mult(ADTNat nat) {
        return this;
    }

    @Override
    public ADTNat div(ADTNat nat) {
        return this;
    }

    @Override
    public ADTNat mod(ADTNat nat) {
        return this;
    }

    @Override
    public boolean even() {
        return true;
    }
    @Override
    public String toString() {
        return "0";
    }
}
