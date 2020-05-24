package controller;

/**
 * @author Laurent
 * Class for the userOrders
 */
public class UserOrder implements IUserOrder {

    private Order order;

    /**
     * @param order is the order we want (in the enum)
     */
    public UserOrder(Order order) {
        this.order = order;
    }

    /**
     * @return Order
     */
    @Override
    public Order getOrder() {
        return this.order;
    }
}
