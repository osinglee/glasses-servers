package come.glasses.entity;

import java.util.Date;

public class ConsumptionEntity {
    private Integer id;

    private Integer tradeId;

    private Integer memberId;

    private Integer number;

    private Integer staffId;

    private String amount;

    private Date createdAt;

    public ConsumptionEntity(Integer id, Integer tradeId, Integer memberId, Integer number, Integer staffId, String amount, Date createdAt) {
        this.id = id;
        this.tradeId = tradeId;
        this.memberId = memberId;
        this.number = number;
        this.staffId = staffId;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public ConsumptionEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}