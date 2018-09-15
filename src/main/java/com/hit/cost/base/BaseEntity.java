package com.hit.cost.base;

import java.io.Serializable;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/9/15 17:00
 * <p>
 * Created By IDEA
 * ==========================
 */
public class BaseEntity implements Serializable {
    /**
     * 分页页码，默认页码为1
     */
    protected  int page = 1;
    /**
     * 分页每页数量，默认20条
     */
    protected  int size = 20;
    /**
     * 排序列的id，默认为code
     */
    protected  String sidx = "code";
    /**
     * 排序方式，默认为升序
     */
    protected  String sorted ="asc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSorted() {
        return sorted;
    }

    public void setSorted(String sorted) {
        this.sorted = sorted;
    }
}
