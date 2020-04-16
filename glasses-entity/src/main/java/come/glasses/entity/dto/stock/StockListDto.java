package come.glasses.entity.dto.stock;

import java.util.Date;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-13 09:40
 */
public class StockListDto {
    private Integer id;

    private Integer brand;

    private String brandName;

    private Integer type;

    private String model;

    private Integer number;

    private Date createdAt;

    private Date updatedAt;

    public StockListDto(Integer id, Integer brand, String brandName, Integer type, String model, Integer number, Date createdAt, Date updatedAt) {
        this.id = id;
        this.brand = brand;
        this.brandName = brandName;
        this.type = type;
        this.model = model;
        this.number = number;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public StockListDto() {
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
