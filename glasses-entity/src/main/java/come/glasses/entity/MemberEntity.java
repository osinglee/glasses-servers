package come.glasses.entity;

import come.glasses.utils.RegexpPattern;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MemberEntity {
    private Integer id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @Pattern(regexp = RegexpPattern.PHONE,message = "手机号码格式错误")
    @NotNull(message = "手机号码不能为空")
    private String phone;

    private String birthday;

    private String address;

    private Integer createId;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
}
