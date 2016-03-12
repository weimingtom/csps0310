package com.edot.repository.provider;

/**
 * Created by tony on 16/1/21.
 */
public class OrderProvider {
    public final static int ORDER_ASC = 0;
    public final static int ORDER_DESC = 1;

    private int order;
    private String orderColumn;

    private OrderProvider() {

    }

    public static OrderProvider valueOf(int order, String orderColumn) {
        OrderProvider orderProvider = new OrderProvider();
        orderProvider.order = order;
        orderProvider.orderColumn = orderColumn;
        return orderProvider;
    }

    public int getOrder() {
        return order;
    }

    public String getOrderColumn() {
        return orderColumn;
    }
}
