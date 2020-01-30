package by.khodus.dto;

import org.springframework.context.annotation.Bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


public class MobileDto {

    interface Save {
    }

    interface Update {
    }

    interface Delete {
    }

    @Digits(integer = 5, fraction = 0)
    @NotNull(groups = {Update.class, Delete.class})
    @Null(groups = {Save.class})
    private int id;

    @Null(groups = {Delete.class})
    @NotNull(groups = {Save.class, Update.class})
    private String Model;

    @Null(groups = {Delete.class})
    @NotNull(groups = {Save.class, Update.class})
    private String Cost;

    public MobileDto(int id, String model, String cost) {
        this.id = id;
        Model = model;
        Cost = cost;
    }

    public MobileDto() {
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }
}
