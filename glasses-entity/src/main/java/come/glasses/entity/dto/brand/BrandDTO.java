package come.glasses.entity.dto.brand;

import javax.validation.constraints.NotNull;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-07 17:24
 */
public class BrandDTO {
    @NotNull(message = "名称不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
