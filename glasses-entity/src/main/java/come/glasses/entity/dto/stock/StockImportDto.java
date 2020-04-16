package come.glasses.entity.dto.stock;

import come.glasses.entity.StockEntity;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-16 11:10
 */
public class StockImportDto {
    
    private List<StockEntity> data;

    public List<StockEntity> getData() {
        return data;
    }

    public void setData(List<StockEntity> data) {
        this.data = data;
    }
}
