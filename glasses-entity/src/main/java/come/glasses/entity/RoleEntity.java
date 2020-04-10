package come.glasses.entity;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-10 16:40
 */
public class RoleEntity {
    private Integer id;
    private String name;
    private String permission;

    public RoleEntity(Integer id, String name, String permission) {
        this.id = id;
        this.name = name;
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
