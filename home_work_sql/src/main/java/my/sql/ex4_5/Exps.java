package my.sql.ex4_5;

import java.io.Serializable;
import java.util.Objects;

public class Exps implements Serializable {
    private int id;
    private String date;
    private String store;
    private Double sum;

    public Exps() {
    }

    public Exps(int id, String date, String store, Double sum) {
        this.id = id;
        this.date = date;
        this.store = store;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", store='" + store + '\'' +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exps exps = (Exps) o;
        return id == exps.id && Objects.equals(date, exps.date) && Objects.equals(store, exps.store) && Objects.equals(sum, exps.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, store, sum);
    }
}
