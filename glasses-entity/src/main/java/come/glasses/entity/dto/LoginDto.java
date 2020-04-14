package come.glasses.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-24 11:04
 */
public class LoginDto {
    @NotNull(message = "用户名不能为空")
    private String user;

    @NotNull(message = "密码不能为空")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
