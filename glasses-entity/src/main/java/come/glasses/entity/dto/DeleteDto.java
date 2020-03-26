package come.glasses.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 16:48
 */
public class DeleteDto {
    @NotNull(message = "id不能为空")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
