package my.sql.ex7;

import java.io.Serializable;

public class Expense implements Serializable {

    private int id;
    private String date;
    private int store_id;
    private Double sum;

    public Expense() {
    }

    public Expense(int id, String date, int store_id, Double sum) {
        this.id = id;
        this.date = date;
        this.store_id = store_id;
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

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", store_id=" + store_id +
                ", sum=" + sum +
                '}';
    }
}
