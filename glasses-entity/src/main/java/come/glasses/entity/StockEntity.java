package come.glasses.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class StockEntity {
    private Integer id;

    /**
     * 品牌id
     */
    @NotNull(message = "品牌不能为空")
    private Integer brand;

    /**
     * 1-镜架，2-镜片，3-隐形，4-药水，5-太阳镜，6-老花镜, 7-其他
     */
    @NotNull(message = "类型不能为空")
    private Integer type;

    /**
     * 型号
     */
    @NotNull(message = "型号不能为空")
    private String model;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
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