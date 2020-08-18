package model;

import java.util.Objects;

public class Denomination {

    private int value;
    private int qty;
    public Denomination(){}
    public Denomination(int value, int qty) {
        this.value = value;
        this.qty = qty;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Denomination that = (Denomination) o;
        return value == that.value &&
                qty == that.qty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, qty);
    }
}
