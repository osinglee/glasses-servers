package come.glasses.entity.dto.stock;

import come.glasses.entity.dto.PageList;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-16 09:16
 */
public class StockInputDto  extends PageList {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
