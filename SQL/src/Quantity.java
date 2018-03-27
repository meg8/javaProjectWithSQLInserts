import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Object <code>Quantity</code> represents table of online shop database.
 * It is creating when we are going to add information of quantity of ordered items to existing database.
 * It contains data about OrderId, ItemId, quantity and average item price.
 * Every of input details should fit to certain format - otherwise program can not accept them.
 * <p>***</p>
 * Quantity class is used by Inscriber class to add new "quantity insert" to "sql_dml.txt".
 * It is also used by Tally class to add new object to ArrayList with every quantity of ordered items in database.
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */

public class Quantity {

    /**
     * <code>orderId</code> is variable which defines number of orderId.
     * It is correct if value of this variable is the same like one existing in orderTab.
     */

    private int orderId;

    /**
     * <code>itemId</code> is variable which defines number of itemId
     * It is correct if value of this variable is the same like one existing in itemTab.
     */

    private int itemId;

    /**
     * <code>quantity</code> is variable which defines number of ordered concrete items.
     */

    private int quantity;

    /**
     * <code>averageItemPrice</code> is variable which states average price of single item. For example customer ordered
     * 6 the same items for 200 zl per unit but one of them he got for free - average price here should be 166.66 zl.
     */

    private float averageItemPrice;

    /**
     * <code>averageItemPriceString</code> contains cost of packing and delivering.
     * It is parsing to float variable in <code>setExtraCost</code> method.
     * It is global variable because we check in other classes if her value equates "END".
     */

    private String averageItemPriceString;

    /**
     * <code>itemTab</code> contains chart with itemId
     */

    private int itemTab[];

    /**
     * <code>orderTab</code> contains chart with orderTab.
     */

    private int orderTab[];

    /**
     * <code>df</code> defines indicated format for variables concerning money.
     */

    private DecimalFormat df;

    /**
     * <code>reader</code> is used to load data from user.
     */

    private Scanner reader = new Scanner(System.in);

    /**
     * In this constructor we execute method <code>setQuantityDetails</code>
     * and in this way we get values of every using variables to create object of <code>Quantity class</code>.
     *
     * @param tally we use this object to get and set value of orderTab and itemTab
     * @param df    we use this object to input value of averageItemPrice in indicated format
     */

    Quantity(Tally tally, DecimalFormat df) {

        this.orderTab = tally.chartWithOrderId();
        this.itemTab = tally.chartWithItemId();
        this.df = df;

        setQuantityDetails();
        System.out.println();

        this.orderId = getOrderId();
        this.itemId = getItemId();
        this.quantity = getQuantity();
        this.averageItemPrice = getAverageItemPrice();
        this.averageItemPriceString = getAverageItemPriceString();
    }

    /**
     * In method <code>toString()</code> is creating writing with details about single quantity object
     * which is display with other objects after calling <code>displayList()</code> method from Tally class.
     */

    public String toString() {

        StringBuilder conglomerator = new StringBuilder("");
        conglomerator.append(orderId).append(" || ").append(itemId).append(" || ");
        conglomerator.append(quantity).append(" || ").append(df.format(averageItemPrice));

        return String.valueOf(conglomerator);
    }

    /**
     * <code>setQuantityDetails</code> method is used to call methods like <code>setQuantity, setAverageItemPrice</code>  etc.
     * to collect values of every variable essential to create new instance of <code>Order class</code> .
     * Next methods are calling till one of the variables (loading from user as Strings) equals "END".
     */

    private void setQuantityDetails() {
        System.out.println("----------------------");
        System.out.println("WPROWADZ DANE ILOSCIOWE");
        System.out.println("----------------------");
        setOrderId();
        if (orderId != 0) {
            setItemId();
            if (itemId != 0) {
                setQuantity();
                if (quantity != 0) {
                    setAverageItemPrice();
                }
            }
        }
    }


    /**
     * <code>getOrderId</code> method is used to return value of <code>orderId</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return orderId
     */

    int getOrderId() {
        return orderId;
    }

    /**
     * <code>getItemId</code> method is used to return value of <code>itemId</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return itemId
     */

    int getItemId() {
        return itemId;
    }

    /**
     * <code>getQuantity</code> method is used to return value of <code>quantity</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return getQuantity
     */

    int getQuantity() {
        return quantity;
    }

    /**
     * <code>getAverageItemPrice</code> method is used to return value of <code>averageItemPrice</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return averageItemPrice
     */

    float getAverageItemPrice() {
        return averageItemPrice;
    }

    /**
     * <code>getAverageItemPriceString</code> method is used to return value of <code>averageItemPriceString</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return averageItemPriceString
     */

    String getAverageItemPriceString() {
        return averageItemPriceString;
    }

    /**
     * <code>setOrderId</code> method is used to set <code>orderId</code> variable by user extracting
     * <code>Scanner class</code>. While value of variable it is not consistent with conditions incl. in Regex
     * and Length class - user has to set variable again. Always orderId must be the same like one from orderTab
     * - otherwise program can not accept them.
     */

    private void setOrderId() {

        System.out.print("Id Zamowienia: ");
        boolean loop = false;
        int counter = 0;
        do {
            String orderIdString = reader.nextLine();
            if (orderIdString.equals("END")) {
                orderId = 0;
                break;
            }
            try {
                orderId = Integer.parseInt(orderIdString);
                if (orderTab[0] == 0) {
                    System.out.println("W bazie nie ma zamowien. Napisz 'END', zeby wrocic do menu");
                    orderId = 0;
                } else {
                    for (int aOrderTab : orderTab) {
                        if (orderId == aOrderTab) {
                            counter++;
                        }
                    }
                    if (counter == 1) {
                        loop = true;
                    } else {
                        System.out.println(("Takiego id zamowienia nie ma w bazie. Podaj idZamowienia jeszcze raz"));
                    }
                }

            } catch (Exception e) {
                System.out.println("Podaj id jeszcze raz. Dopuszczalne sa tylko cyfry. Max dopuszczalna wartosc to " +
                        "" + Length.intMaxValue);
            }
        }
        while (!loop);
    }

    /**
     * <code>setItemId</code> method is used to set <code>itemId</code> variable by user extracting
     * <code>Scanner class</code>. While value of variable it is not consistent with conditions incl. in Length
     * class - user has to set variable again. Always itemId must be the same like one from customerTab - otherwise
     * program can not accept them.
     */

    private void setItemId() {
        System.out.print("Id Artykulu: ");
        boolean loop = false;
        int counter = 0;
        do {
            String itemIdString = reader.nextLine();
            if (itemIdString.equals("END")) {
                itemId = 0;
                break;
            }
            try {
                itemId = Integer.parseInt(itemIdString);
                if (itemTab[0] == 0) {
                    System.out.println("W bazie nie ma artykulow. Napisz 'END', zeby wrocic do menu");
                    itemId = 0;
                } else {
                    for (int anArtykulTab : itemTab) {
                        if (itemId == anArtykulTab) {
                            counter++;
                        }
                    }
                    if (counter == 1) {
                        loop = true;
                    } else {
                        System.out.println(("Takiego id artykulu nie ma w bazie. Podaj id Artykulu jeszcze raz"));
                    }
                }

            } catch (Exception e) {
                System.out.println("Podaj id jeszcze raz. Dopuszczalne sa tylko cyfry. Max dopuszczalna wartosc to " +
                        "" + Length.intMaxValue);
            }
        }
        while (!loop);
    }

    /**
     * <code>setQuantity()</code> method is used to set <code>quantity</code> variable by user extracting <code>Scanner class</code>.
     * While value of variable it is not consistent with conditions incl. in Length class - user has to set variable again.
     */

    private void setQuantity() {
        System.out.print("Ilosc: ");
        boolean loop = false;
        do {
            String quantityString = reader.nextLine();
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity == 0) {
                    System.out.println("Podaj ilosc jeszcze raz. Dopuszczalne sa tylko cyfry. Ilość nie moze wynosic '0'");
                } else {
                    loop = true;
                }
            } catch (Exception e) {
                System.out.println("Podaj ilosc jeszcze raz. Dopuszczalne sa tylko cyfry. Ilość nie moze wynosic '0'" + "\n" +
                        "Max dopuszczalna wartosc to " + Length.intMaxValue);
            }
        } while (!loop);
    }

    /**
     * <code>setAverageItemPrice</code> method is used to set <code>averageItemPriceString</code> variable by user
     * extracting <code>Scanner class</code>.While value of variable it is not consistent with conditions incl. in Regex
     * and Length class - user has to set variable again.
     */

    private void setAverageItemPrice() {

        System.out.print("Srednia cena sztuki:");
        boolean loop = false;
        do {
            averageItemPriceString = reader.nextLine();
            if ((averageItemPriceString.equals("END")) && (!Regex.moneyPattern1.matcher(averageItemPriceString).matches()) &&
                    (!Regex.moneyPattern2.matcher(averageItemPriceString).matches()) &&
                    (!Regex.moneyPattern3.matcher(averageItemPriceString).matches())) {
                break;
            } else if ((!Regex.moneyPattern1.matcher(averageItemPriceString).matches()) &&
                    (!Regex.moneyPattern2.matcher(averageItemPriceString).matches())
                    && (!Regex.moneyPattern3.matcher(averageItemPriceString).matches())) {
                System.out.println("Podaj srednia cene sztuki jeszcze raz. Dopuszczalne sa tylko cyfry i znak '.' " +
                        "zastepujacy przecinek " + "(max " + Length.moneyPrecision + " cyfr, w tym max "
                        + Length.moneyScale + " po przecinku).");
            } else {
                averageItemPrice = Float.parseFloat(averageItemPriceString);
                loop = true;
            }
        } while (!loop);
    }
}
