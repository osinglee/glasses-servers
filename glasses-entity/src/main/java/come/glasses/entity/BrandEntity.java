package come.glasses.entity;

import io.swagger.models.auth.In;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-07 16:58
 * 品牌
 */
public class BrandEntity {

    private Integer id;

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
