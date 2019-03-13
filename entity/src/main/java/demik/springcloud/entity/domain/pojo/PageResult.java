package demik.springcloud.entity.domain.pojo;

import java.util.List;

/**
 * Function: 分页结果统一返回类
 *
 * @author zhangyu
 * Date: 2018/12/7 10:46 AM
 * @since JDK 1.8
 */
public class PageResult<T> {

    /**
     * 总条数
     */
    private Long pageTotal;

    /**
     * 返回的数据列表
     */
    private List<T> pageList;

    public Long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}
