package cn.ityun.web.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页对象
 */
public class PageListUtils {
    private int page;
    private int totalRows;
    private int pages;
    private List list = new ArrayList();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "page=" + page +
                ", totalRows=" + totalRows +
                ", pages=" + pages +
                ", list=" + list +
                '}';
    }
}
