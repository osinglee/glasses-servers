package come.glasses.entity.dto;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-03-26 17:39
 */
public class UserUpdate {
    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "name不能为空")
    private String name;

    @NotNull(message = "code不能为空")
    private String code;

    private Byte sex;

    private String phone;

    private Integer roleId;

    private String remarks;

    private String passwordEncrypted;

    private String currentToken;

    private Date createdAt;

    private Date updatedAt;

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
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted == null ? null : passwordEncrypted.trim();
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken == null ? null : currentToken.trim();
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
