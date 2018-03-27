import java.util.ArrayList;
import java.util.List;

/**
 * Class <code>Inscriber</code> retains methods which are used to create lists of objects like customers, items, order,
 * quantities and display them. It also has methods to build charts with <code>consumerId, itemId, orderId and barCode
 * </code> which are used to comparision with new values.
 *
 * @see Item#setBarCode()
 * @see Order#setCustomerId()
 * @see Quantity#setItemId()
 * @see Quantity#setOrderId()
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */


class Tally {

    /**
     * <code>customerList</code> is the list with every customers.
     */

    private List<Customer> customerList = new ArrayList<>();

    /**
     * <code>itemList</code> is the list with every items.
     */

    private List<Item> itemList = new ArrayList<>();

    /**
     * <code>orderList</code> is the list with every orders.
     */

    private List<Order> orderList = new ArrayList<>();

    /**
     * <code>qtyList</code> is the list with every quantities.
     */

    private List<Quantity> qtyList = new ArrayList<>();

    /**
     * <code>CUSTOMER_LIST</code> is variable which is used in <code>displayList(int numberOfList)</code> method .
     */

    static final int CUSTOMER_LIST = 1;

    /**
     * <code>CUSTOMER_LIST</code> is variable which is used in <code>displayList(int numberOfList)</code> method .
     */
    static final int ITEM_LIST = 2;

    /**
     * <code>ORDER_LIST</code> is variable which is used in <code>displayList(int numberOfList)</code> method .
     */

    static final int ORDER_LIST = 3;

    /**
     * <code>QTY_LIST</code> is variable which is used in <code>displayList(int numberOfList)</code> method .
     */

    static final int QTY_LIST = 4;

    /**
     * <code>customerTab</code> is the chart with <code>consumerId</code> of every adding consumers.
     */

    private int customerTab[];

    /**
     * <code>itemTab</code> is the chart with <code>itemId</code> of every adding items.
     */

    private int itemTab[];

    /**
     * <code>orderTab</code> is the chart with <code>orderId</code> of every adding orders.
     */

    private int orderTab[];

    /**
     * <code>barCodeTab</code> is the chart with <code>barcode</code> of every adding items.
     */

    private long barCodeTab[];

    /**
     * In this constructor we get values of every using variables to create object of <code>Tally class</code>.
     * Variables from this object will be use to create objects of <code>Order class</code> , <code>Quantity class</code>
     * and <code>Item class</code>.
     */

    Tally() {

        this.customerList = getCustomerList();
        this.itemList = getItemList();
        this.orderList = getOrderList();
        this.qtyList = getQuantityList();
        this.customerTab = chartWithCustomerId();
        this.itemTab = chartWithItemId();
        this.orderTab = chartWithOrderId();
        this.barCodeTab = chartWithBarCode();

    }

    /**
     * <code>getCustomerList()</code> method is used to return value of <code>customerList</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return customerList
     */

    private List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * <code>getItemList</code> method is used to return value of <code>itemList</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return itemList
     */

    private List<Item> getItemList() {
        return itemList;
    }

    /**
     * <code>getOrderList()</code> method is used to return value of <code>orderList</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return orderList
     */

    private List<Order> getOrderList() {
        return orderList;
    }

    /**
     * <code>getQuantityList()</code> method is used to return value of <code>qtyList</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return qtyList
     */

    private List<Quantity> getQuantityList() {
        return qtyList;
    }

    /**
     * <code>addCustomerToTheList(Customer customer)</code> method is adding new object to the customerList
     * if conditions are fulfilled.
     *
     * @param customer we use customer object to check if one of its variable equals "END"
     *                 - if not - consumer can be add to the list
     */

    void addCustomerToTheList(Customer customer) {
        if ((!customer.getName().equals("END")) && (!customer.getSurname().equals("END")) && (!customer.getFirstAddressLine().equals("END")) &&
                (!customer.getSecondAddressLine().equals("END")) && (!customer.getCity().equals("END")) && (!customer.getCountry().equals("END"))
                && (!customer.getPhoneNumber().equals("END"))) {
            customerList.add(customer);
        }
    }

    /**
     * <code>addOrderToTheList(Order order)</code> method is adding new object to the orderList if conditions are fulfilled.
     *
     * @param order we use order object to check if one of its variable equals "END" or 0 - if not -
     *              order can be add to the list
     */

    void addOrderToTheList(Order order) {
        if ((order.getCustomerId() != 0) && (!order.getOrderDate().equals("END")) &&
                (!order.getMeansOfImplementation().equals("END")) && (!order.getExtraCostString().equals("END"))) {
            orderList.add(order);
        }
    }

    /**
     * <code>addItemToTheList(Item item)</code> method is adding new object to the itemList if conditions are fulfilled.
     *
     * @param item we use item object to check if one of its variable equals "END" or 0
     *             - if not - consumer can be add to the list
     */

    void addItemToTheList(Item item) {
        if ((!item.getDescription().equals("END") && (!item.getOriginalPriceString().equals("END")) && (item.getBarCode() != 0))) {
            itemList.add(item);
        }
    }

    /**
     * <code>addQuantityToTheList(Quantity quantity)</code> method is adding new object to the qtyList
     * if conditions are fulfilled.
     *
     * @param quantity we use quantity object to check if one of its variable equals "END" or 0
     *                 - if not - quantity can be add to the list
     */

    void addQuantityToTheList(Quantity quantity) {
        if ((quantity.getOrderId() != 0) && (quantity.getItemId() != 0 && (quantity.getQuantity() != 0) && (!quantity.getAverageItemPriceString().equals("END")))) {
            qtyList.add(quantity);
        }
    }

    /**
     * <code>displayList()</code> method is building and displaying StringBuilder object which contains objects of
     * <code>Customer class</code>, <code>Item class</code>, <code>Order class</code> or <code>Quantity class</code>.
     *
     * @param numberOfList - states name of list which will be display
     */

    void displayList(int numberOfList) {

        String name = "";
        String isEmpty = "";
        List listName = new ArrayList<>();


        switch (numberOfList) {
            case 1:
                name = "LISTA KLIENTOW : ";
                isEmpty = "Lista klientow jest pusta. Zeby wprowadzic klienta wybierz '1'";
                listName = customerList;
                break;
            case 2:
                name = "LISTA ARTYKULOW : ";
                isEmpty = "Lista artykulow jest pusta. Zeby wprowadzic artykul wybierz '2'";
                listName = itemList;
                break;
            case 3:
                name = " LISTA ZAMOWIEN : ";
                isEmpty = "Lista zamowien jest pusta. Zeby wprowadzic zamowienie wybierz '3'";
                listName = orderList;
                break;
            case 4:
                name = "LISTA Z INFORMACJA O ILOSCIACH : ";
                isEmpty = "Lista z ilosciami jest pusta. Zeby wprowadzic ilosci wybierz '4'";
                listName = qtyList;
                break;
        }


        StringBuilder buildingList = new StringBuilder("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n"
                + name + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n");
        if (listName.isEmpty()) {
            System.out.println(isEmpty);
        } else {
            for (Object aListList : listName) {
                buildingList.append(aListList).append("\n");
            }
            System.out.println(buildingList);
        }

    }

    /**
     * <code>chartWithCustomerId()</code> method is creating chart with <code>customerId</code> using
     * <code>customerList</code>. If <code>customerList</code> is empty - chart contains only one element - 0.
     *
     * @return customerTab
     */

    int[] chartWithCustomerId() {
        customerTab = new int[customerList.size()];
        if (customerList.isEmpty()) {
            customerTab = new int[1];
            customerTab[0] = 0;
        } else {
            for (int i = 0; i < customerTab.length; i++) {
                customerTab[i] = customerList.get(i).getCustomerId();
            }
        }
        return customerTab;
    }

    /**
     * <code>chartWithItemId()</code> method is creating chart with <code>itemId</code> using <code>itemList</code>.
     * If <code>itemList</code> is empty - chart contains only one element - 0.
     *
     * @return itemTab
     */

    int[] chartWithItemId() {
        itemTab = new int[itemList.size()];
        if (itemList.isEmpty()) {
            itemTab = new int[1];
            itemTab[0] = 0;
        } else {
            for (int i = 0; i < itemTab.length; i++) {
                itemTab[i] = itemList.get(i).getItemId();
            }
        }
        return itemTab;
    }

    /**
     * <code>chartWithOrderId()</code> method is creating chart with <code>orderId</code> using <code>orderList</code>.
     * If <code>orderList</code> is empty - chart contains only one element - 0.
     *
     * @return orderTab
     */

    int[] chartWithOrderId() {
        orderTab = new int[orderList.size()];
        if (orderList.isEmpty()) {
            orderTab = new int[1];
            orderTab[0] = 0;
        } else {
            for (int i = 0; i < orderTab.length; i++) {
                orderTab[i] = orderList.get(i).getOrderId();
            }
        }
        return orderTab;
    }

    /**
     * <code>chartWithBarCode()</code> method is creating chart with <code>barCode</code> using <code>itemList</code>.
     * If <code>itemList</code> is empty - chart contains only one element - 0.
     *
     * @return barCodeTab
     */

    long[] chartWithBarCode() {
        barCodeTab = new long[itemList.size()];
        if (itemList.isEmpty()) {
            barCodeTab = new long[1];
            barCodeTab[0] = 0;
        } else {
            for (int i = 0; i < barCodeTab.length; i++) {
                barCodeTab[i] = itemList.get(i).getBarCode();
            }
        }
        return barCodeTab;
    }

}