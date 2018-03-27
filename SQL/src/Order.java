import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


/**
 * Object <code>Order</code> represents table of online shop database.
 * It is creating when we are going to add information of new order to existing database.
 * It contains data about orderId, customerId, order date, means of implementation and extraCost.
 * Every of input details should fit to certain format - otherwise program can not accept them.
 * <p>***</p>
 * Order class is used by Inscriber class to add new "order insert" to "sql_dml.txt".
 * It is also used by Tally class to add new object to ArrayList with every orders in database
 * and create chart with existing orderId (this chart is needful to set correct orderId in Quantity class).
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */
class Order {

    /**
     * <code>nextOrderId</code> is statistic variable which is used to create unique <code>orderId</code>
     * for every new instance of <code>Order class</code>.
     */

    private static int nextOrderId = 0;

    /**
     * <code>orderId</code> is variable which is setting automatically during creating new customer
     * (incrementation of <code>nextOrderId</code> variable).
     */

    private int orderId;

    /**
     * <code>customerId</code> is variable which defines number of customerId.
     * It is correct if value of this variable is the same like one existing in customerTab.
     */

    private int customerId;

    /**
     * <code>dateDate</code> is object of Date class which contains information about date of order which
     * is in accordance with SimpleDateFormat.
     */

    private Date dateDate;

    /**
     * <code>orderDate</code> is variable which defines date of order.
     * Assumedly final version of this variable should be in accordance with oracle database required format.
     */

    private String orderDate;

    /**
     * <code>meansOfImplementation</code> is variable which describes how order will arrive to customer
     * (self-pickup, courier company).
     */

    private String meansOfImplementation;

    /**
     * <code>extraCost</code> is variable which states cost of packing and delivering order to customer
     */

    private float extraCost;

    /**
     * <code>extraCost</code> contains cost of packing and delivering.
     * It is parsing to float variable in <code>setExtraCost</code> method.
     * It is global variable because we check in other classes if her value equates "END".
     */

    private String extraCostString;

    /**
     * <code>barCodeTab</code> contains chart with customerId.
     */

    private int customerTab[];

    /**
     * <code>df</code> defines indicated format for variables concerning money.
     */

    private DecimalFormat df;

    /**
     * <code>reader</code> is used to load data from user.
     */

    private Scanner reader = new Scanner(System.in);

    /**
     * In this constructor we execute method <code>setOrderDetails()</code>
     * and in this way we get values of every using variables to create object of <code>Order class</code>.
     *
     * @param tally we use this object to get and set value of customerTab
     * @param df    we use this object to input value of extraCost in indicated format
     */

    Order(Tally tally, DecimalFormat df) {

        this.customerTab = tally.chartWithCustomerId();
        this.df = df;

        setOrderDetails();
        System.out.println();

        this.orderId = ++nextOrderId;
        this.customerId = getCustomerId();
        this.orderDate = getOrderDate();
        this.dateDate = getDateDate();
        this.meansOfImplementation = getMeansOfImplementation();
        this.extraCost = getExtraCost();
        this.extraCostString = getExtraCostString();
    }

    /**
     * In method <code>toString()</code> is creating writing with details about single order object
     * which is display with other objects after calling <code>displayList()</code> method from Tally class.
     */

    public String toString() {
        StringBuilder conglomerator = new StringBuilder("");
        conglomerator.append(orderId).append(" || ").append(customerId).append(" || ").append(orderDate).append(" || ");
        conglomerator.append(meansOfImplementation).append(" || ").append(df.format(extraCost));

        return String.valueOf(conglomerator);
    }

    /**
     * <code>setOrderDetails()</code> method is used to call methods like <code>setOrderDate(), setExtraCost()</code>  etc.
     * to collect values of every variable essential to create new instance of <code>Order class</code> .
     * Next methods are calling till one of the variables (loading from user as Strings) equals "END". In this way new order is not created and unique
     * <code>orderId</code>  which was booked for it can be reuse.
     */

    private void setOrderDetails() {
        System.out.println("----------------------");
        System.out.println("WPROWADZ DANE ZAMOWIENIA");
        System.out.println("----------------------");

        setCustomerId();
        if (customerId != 0) {
            setOrderDate();
            if (!orderDate.equals("END")) {
                setMeansOfImplementation();
                if (!meansOfImplementation.equals("END")) {
                    setExtraCost();
                    if (extraCostString.equals("END")) {
                        nextOrderId--;
                    }
                } else {
                    nextOrderId--;
                }
            } else {
                nextOrderId--;
            }
        } else {
            nextOrderId--;
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
     * <code>getCustomerId</code> method is used to return value of <code>customerId</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return customerId
     */

    int getCustomerId() {
        return customerId;
    }

    /**
     * <code>getOrderDate</code> method is used to return value of <code>orderDate</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return orderDate
     */

    String getOrderDate() {
        return orderDate;
    }

    /**
     * <code>getMeansOfImplementation</code> method is used to return value of <code>meansOfImplementation</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return meansOfImplementation
     */

    String getMeansOfImplementation() {
        return meansOfImplementation;
    }

    /**
     * <code>getExtraCost</code> method is used to return value of <code>extraCost</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return extraCost
     */

    float getExtraCost() {
        return extraCost;
    }

    /**
     * <code>getExtraCostString</code> method is used to return value of <code>getExtraCostString</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return extraCostString
     */

    String getExtraCostString() {
        return extraCostString;
    }

    /**
     * <code>getDateDate</code> method is used to return value of <code>dateDate</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return dateDate
     */

    private Date getDateDate() {
        return dateDate;
    }

    /**
     * <code>setCustomerId</code> method is used to set <code>customerId</code> variable by user extracting
     * <code> Scanner class </code>. While value of variable it is not consistent with conditions incl. in Length class
     * - user has to set variable again. Always customerId must be the same like one from customerTab
     * - otherwise program can not accept them.
     */

    private void setCustomerId() {
        System.out.print("Id klienta: ");

        boolean loop = false;
        int counter = 0;
        do {
            String customerIdString = reader.nextLine();
            if (customerIdString.equals("END")) {
                customerId = 0;
                break;
            }
            try {
                customerId = Integer.parseInt(customerIdString);
                if (customerTab[0] == 0) {
                    System.out.println("W bazie nie ma klientow. Napisz 'END', zeby wrocic do menu");
                    customerId = 0;
                } else {
                    for (int aCustomerTab : customerTab) {
                        if (customerId == aCustomerTab) {
                            counter++;
                        }
                    }
                    if (counter == 1) {
                        loop = true;
                    } else {
                        System.out.println(("Takiego id klienta nie ma w bazie. Podaj idKlienta jeszcze raz"));
                    }
                }
            } catch (Exception e) {
                System.out.println("Podaj id jeszcze raz. Dopuszczalne sa tylko cyfry. Max dopuszczalna wartosc to " + Length.intMaxValue);
            }
        }
        while (!loop);
    }

    /**
     * <code>setOrderDate</code> method is used to set variables like <code> orderDate </code> and <code> dateDate </code>
     * by user extracting <code>Scanner class</code>. While value of variable it is not consistent with conditions incl.
     * in Regex class - user has to set variable again. Date can not be earlier than existing of online shop and later
     * than day when user is adding new order - otherwise program can not accept them. User can not add days which are
     * not exist (although it is consistent with other conditions) like for example "2015.02.29" or "2017.06.31".
     */

    private void setOrderDate() {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        int dayInt, monthInt, yearInt;
        int dayToday = gc.get(GregorianCalendar.DAY_OF_MONTH);
        int monthToday = gc.get(GregorianCalendar.MONTH) + 1;
        int yearToday = gc.get(GregorianCalendar.YEAR);

        boolean loop = false;
        System.out.print("Data w formacie rrrr.mm.dd : ");
        do {
            StringBuilder day = new StringBuilder("");
            StringBuilder month = new StringBuilder("");
            StringBuilder year = new StringBuilder("");

            orderDate = reader.nextLine();

            if (orderDate.equals("END") && (!Regex.datePattern.matcher(orderDate).matches())) {
                break;
            } else if (!Regex.datePattern.matcher(orderDate).matches()) {
                System.out.println("Data nie pasuje do formatu. Podaj ja jeszcze raz.");
            } else {

                day.append(orderDate.charAt(8)).append(orderDate.charAt(9));
                month.append(orderDate.charAt(5)).append(orderDate.charAt(6));
                year.append(orderDate.charAt(0)).append(orderDate.charAt(1));
                year.append(orderDate.charAt(2)).append(orderDate.charAt(3));

                if (day.charAt(0) != 0) {
                    dayInt = Integer.parseInt(String.valueOf(day));
                } else {
                    dayInt = Integer.parseInt(String.valueOf(day.charAt(1)));
                }
                if (month.charAt(0) != 0) {
                    monthInt = Integer.parseInt(String.valueOf(month));
                } else {
                    monthInt = Integer.parseInt(String.valueOf(month.charAt(1)));
                }
                yearInt = Integer.parseInt(String.valueOf(year));

                if (((dayInt > 31) && (monthInt > 12))
                        || ((dayInt == 31) && ((monthInt == 2) || (monthInt == 4) || (monthInt == 6) || (monthInt == 9) || (monthInt == 11)))
                        || ((monthInt == 2) && (dayInt == 30)) || (((monthInt == 2) && (dayInt == 29)) && (yearInt != 2016) && (yearInt != 2020))) {
                    System.out.println("Nie ma takiego dnia. Podaj date jeszcze raz");
                } else if (yearInt < 2015) {
                    System.out.println("Data zamowienia nie moze być wcześniejsza niz data istnienia sklepu");
                } else if ((yearInt > yearToday) || (yearInt == yearToday) && ((monthInt > monthToday) || ((monthInt == monthToday) && (dayInt > dayToday)))) {
                    System.out.println("Data zamowienia nie moze byc pozniejsza niz data dzisiejsza");
                } else {
                    loop = true;
                    try {
                        dateDate = sdf.parse(orderDate);
                    } catch (ParseException e) {
                        loop = false;
                    }
                    orderDate = orderDate.charAt(2) + "" + orderDate.charAt(3) + "/" + month + "/" + day;
                }
            }
        } while (!loop);
    }

    /**
     * <code>setMeansOfImplementation</code> method is used to set <code>meansOfImplementation</code> variable by user
     * extracting <code>Scanner class</code>. While value of variable it is not consistent with conditions incl.
     * in Length class - user has to set variable again.
     */

    private void setMeansOfImplementation() {

        System.out.print("Sposob realizacji:");
        do {
            meansOfImplementation = reader.nextLine();
            if (meansOfImplementation.length() > Length.mediumLengthOfString) {
                System.out.println("Opis sposobu realizacji nie moze miec wiecej niz " + Length.mediumLengthOfString + " znakow");
            }
        } while (meansOfImplementation.length() > Length.shortLengthOfString);
    }

    /**
     * <code>setExtraCost()</code> method is used to set <code>extraCost</code> variable by user extracting
     * <code> Scanner class </code>. While value of variable it is not consistent with conditions incl. in Regex and
     * Length class - user has to set variable again.
     */

    private void setExtraCost() {

        System.out.print("Koszty dodatkowe: ");
        boolean loop = false;

        do {
            extraCostString = reader.nextLine();
            if ((extraCostString.equals("END")) && (!Regex.moneyPattern1.matcher(extraCostString).matches()) &&
                    (!Regex.moneyPattern2.matcher(extraCostString).matches()) &&
                    (!Regex.moneyPattern3.matcher(extraCostString).matches())) {
                break;
            } else if ((!Regex.moneyPattern1.matcher(extraCostString).matches()) &&
                    (!Regex.moneyPattern2.matcher(extraCostString).matches())
                    && (!Regex.moneyPattern3.matcher(extraCostString).matches())) {
                System.out.println("Podaj wysokosc kosztow jeszcze raz. Dopuszczalne sa tylko cyfry i znak '.'" +
                        " zastepujacy przecinek " + "(max " + Length.moneyPrecision + " cyfr, w tym max "
                        + Length.moneyScale + " po przecinku).");
            } else {
                extraCost = Float.parseFloat(extraCostString);
                loop = true;
            }
        } while (!loop);
    }
}
