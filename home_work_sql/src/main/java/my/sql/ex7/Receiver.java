package my.sql.ex7;

import java.io.Serializable;

public class Receiver implements Serializable {

    private int id;
    private String store;

    public Receiver(int id, String name) {
        this.id = id;
        this.store = name;
    }

    public Receiver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
