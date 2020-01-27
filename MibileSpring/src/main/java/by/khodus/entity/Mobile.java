package by.khodus.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "mobile")
public class Mobile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_id")
    @SequenceGenerator(name = "gen_id", sequenceName = "mobile_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "cost")
    private String cost;


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
        return id == mobile.id &&
                Objects.equals(model, mobile.model) &&
                Objects.equals(cost, mobile.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, cost);
    }
}


