package come.glasses.entity.dto.member;

import come.glasses.entity.dto.PageList;

public class MemberInputDto  extends PageList {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
