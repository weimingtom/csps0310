package com.edot.repository.provider;

/**
 * Created by tony on 16/1/21.
 */
public class PageProvider {
    private int currentPage;
    private int pageSize;

    private PageProvider() {

    }

    public static PageProvider valueOf(int currentPage, int pageSize) {
        PageProvider pageProvider = new PageProvider();
        pageProvider.currentPage = currentPage;
        pageProvider.pageSize = pageSize;
        return pageProvider;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }
}
