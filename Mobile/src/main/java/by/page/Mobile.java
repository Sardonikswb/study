package by.page;


import by.db.ConnectionToDB;

import java.util.Objects;

public class Mobile {
    private String model;
    private String cost;
    private int id;

    public Mobile() {
    }

    public Mobile(int id, String model, String cost) {
        this.model = model;
        this.cost = cost;
        this.id = id;
    }

    public Mobile(String model, String cost) {
        this.model = model;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "model='" + model + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return model.equals(mobile.model) &&
                cost.equals(mobile.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, cost);
    }
}
