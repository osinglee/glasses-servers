package come.glasses.entity;

import come.glasses.utils.RegexpPattern;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private Integer id;

    @NotNull(message = "name不能为空")
    private String name;

    private Byte sex;

    @Pattern(regexp = RegexpPattern.PHONE,message = "手机号码格式错误")
    @NotNull(message = "手机号码不能为空")
    private String phone;

    private Integer roleId;

    private String remarks;

    private String passwordEncrypted;

    private String currentToken;

    private Date createdAt;

    private Date updatedAt;

    public User(Integer id, String name, Byte sex, String phone, Integer roleId, String remarks, String passwordEncrypted, String currentToken, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.roleId = roleId;
        this.remarks = remarks;
        this.passwordEncrypted = passwordEncrypted;
        this.currentToken = currentToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User() {
        super();
    }

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