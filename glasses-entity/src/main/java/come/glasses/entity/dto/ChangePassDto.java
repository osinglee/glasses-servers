package come.glasses.entity.dto;


import javax.validation.constraints.NotNull;

public class ChangePassDto {

    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "旧密码不能为空")
    private String pass;

    @NotNull(message = "新密码不能为空")
    private String newPass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
