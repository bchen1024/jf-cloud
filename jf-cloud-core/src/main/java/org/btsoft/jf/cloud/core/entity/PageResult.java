package org.btsoft.jf.cloud.core.entity;

import java.util.List;

/**
 * 分页结果实体对象
 * @param <T>
 */
public class PageResult<T> {

    private List<T> result;

    private Page page;

    public PageResult(List<T> result, Page page) {
        this.result = result;
        this.page = page;
    }

    public PageResult(List<T> result, Page page,int total) {
        this.result = result;
        this.page = page;
        this.page.setTotal(total);
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
