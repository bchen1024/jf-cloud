package org.btsoft.jf.cloud.core.entity;

/**
 * 分页实体对象
 */
public class Page {

    /**
     * 当前第几页
     */
    private int curPage=1;

    /**
     * 每页大小
     */
    private int pageSize=15;

    /**
     * 总数
     */
    private int total;

    /**
     * 索引起始数
     */
    private int startIndex;

    /**
     * 总页数
     */
    private int totalPage;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStartIndex() {
        this.startIndex=(this.curPage - 1) * this.pageSize;
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        this.totalPage=(int) Math.ceil((double) (this.total / this.pageSize));
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
