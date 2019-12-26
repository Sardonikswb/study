package by.page;


import java.util.Objects;

public class Mobile {
    private String model;
    private String cost;
    private Integer id;

    public Mobile() {
    }

    public Mobile(Integer id, String model, String cost) {
        this.id = id;
        this.model = model;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return model.equals(mobile.model) &&
                cost.equals(mobile.cost) &&
                id.equals(mobile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, cost, id);
    }
}
