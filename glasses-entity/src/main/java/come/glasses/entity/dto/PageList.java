package come.glasses.entity.dto;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-03-26 17:57
 */
public class PageList {

    private Integer page = 1;

    private Integer pageSize = 100;

    private Integer totalCount;

    private Integer offset;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}
