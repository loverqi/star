package cn.loverqi.star.core.bean;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 带页码的Response的返回值类型，该类只能使用PageInfo实例化
 * @author loverqi
 * @date 2018年1月5日
 */
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -2869658134927577905L;

    private int pageNum;

    //每页的数量
    private int pageSize;

    //当前页的数量
    private int size;

    //总记录数
    private long total;

    //总页数
    private int pages;

    //结果集
    private List<T> list;

    /**
     * @param pageInfo PageHeper中的PageInfo类，无法直接实例化
     */
    public PageResult(PageInfo<T> pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.size = pageInfo.getSize();
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
        this.list = pageInfo.getList();
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getSize() {
        return size;
    }

    public long getTotal() {
        return total;
    }

    public int getPages() {
        return pages;
    }

    public List<T> getList() {
        return list;
    }

}