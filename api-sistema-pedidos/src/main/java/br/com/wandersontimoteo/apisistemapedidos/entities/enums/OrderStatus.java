package br.com.wandersontimoteo.apisistemapedidos.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int orderStatusCode;

    private OrderStatus(int orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public int getOrderStatus() {
        return orderStatusCode;
    }

    public static OrderStatus valueOf(int orderStatusCode) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getOrderStatus() == orderStatusCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus orderStatusCode");
    }
}
