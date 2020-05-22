/**
 * @author ：shujie
 * @date ：2020/04/29
 * @description:
 */
public class Animal {

    private Integer pageSize;

    private Integer pageNo;

    private static final Integer DEFAULT_PAGE_SIZE = 10;

    private static final Integer DEFAULT_PAGE_NO = 1;

    private void init () {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.pageNo = DEFAULT_PAGE_NO;
    }

    public Animal() {
        init();
    }

    public Animal(Integer pageSize, Integer pageNo) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                '}';
    }
}
