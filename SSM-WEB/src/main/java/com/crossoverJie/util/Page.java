package com.crossoverJie.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Page
 *
 * @author chj
 * @Description: datagrid分页工具类
 * @date 2016-1-3 下午2:17:09
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 每页显示的数量
     **/
    private int limit;
    /**
     * 总条数
     **/
    private int total;
    /**
     * 当前页数
     **/
    private int pageNo;
    /**
     * 存放集合
     **/
    private List<T> rows = new ArrayList<T>();

    public int getOffset() {
        return (pageNo - 1) * limit;
    }

    public void setOffset(int offset) {
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    // 计算总页数
    public int getTotalPages() {
        int totalPages;
        if (total % limit == 0) {
            totalPages = total / limit;
        } else {
            totalPages = (total / limit) + 1;
        }
        return totalPages;
    }

    public int getTotal() {
        return total;
    }

    public int getOffsets() {
        return (pageNo - 1) * limit;
    }

    public int getEndIndex() {
        if (getOffsets() + limit > total) {
            return total;
        } else {
            return getOffsets() + limit;
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
