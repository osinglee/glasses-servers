package come.glasses.entity;

import io.swagger.models.auth.In;

import javax.validation.constraints.NotNull;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-07 16:58
 * 品牌
 */
public class BrandEntity {

    private Integer id;

    @NotNull(message = "名称不能为空")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
