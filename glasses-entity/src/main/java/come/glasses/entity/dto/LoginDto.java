package come.glasses.entity.dto;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-24 11:04
 */
public class LoginDto {
    private String user;
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
