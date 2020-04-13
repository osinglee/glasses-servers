package come.glasses.entity;

import java.util.Date;

public class StockEntity {
    private Integer id;

    private Integer brand;

    private Integer type;

    private String model;

    private Integer number;

    private Date createdAt;

    private Date updatedAt;

    public StockEntity(Integer id, Integer brand, Integer type, String model, Integer number, Date createdAt, Date updatedAt) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.model = model;
        this.number = number;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public StockEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}