package examprep.nat;

public class Nat implements ADTNat {
    private final ADTNat pred;

    public Nat(ADTNat nat) {
        this.pred = nat;
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public ADTNat suc() {
        return new Nat(this);
    }

    @Override
    public ADTNat pred() {
        return pred;
    }

    @Override
    public ADTNat add(ADTNat nat) {
        if (nat.isZero()) return this;
        return this.add(nat.pred()).suc();
    }

    @Override
    public boolean equals(ADTNat nat) {
        if (nat.isZero()) return false;
        return this.pred().equals(nat.pred());
    }

    @Override
    public int compareTo(ADTNat nat) {
        if (nat.isZero()) return -1;
        return this.pred().compareTo(nat.pred());
    }

    @Override
    public ADTNat sub(ADTNat nat) {
        if (nat.isZero()) return this;
        return this.pred().sub(nat.pred());
    }

    @Override
    public ADTNat mult(ADTNat nat) {
        if (nat.pred().isZero()) return this;
        return this.mult(nat.pred()).add(this);
    }

    @Override
    public ADTNat div(ADTNat nat) {
        if (this.compareTo(nat) > 0) return new NatZero();
        if (nat.isZero()) return this;
        return this.sub(nat).div(nat).suc();
    }

    @Override
    public ADTNat mod(ADTNat nat) {
        if (this.compareTo(nat) > 0) return this;
        return this.sub(nat).mod(nat);
    }

    @Override
    public boolean even() {
        if (this.pred().isZero()) return false;
        return this.pred().pred().even();
    }

    @Override
    public String toString() {
        return String.valueOf(Integer.parseInt(pred.toString()) + 1);
    }

    public static void main(String[] args) {
        var nat1 = new NatZero().suc().suc().suc().suc();
        var nat2 = new NatZero().suc().suc().suc();

        System.out.println(nat1);
        System.out.println(nat2);
        System.out.println("add: " + nat1.add(nat2));
        System.out.println("mult: " + nat1.mult(nat2));
        System.out.println("div: " + nat1.mult(nat1).div(nat2));
        System.out.println("mod: " + nat1.mod(nat2));
    }
}
