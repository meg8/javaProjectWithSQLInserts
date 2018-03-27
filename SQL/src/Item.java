import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Object <code>Item</code> represents table of online shop database.
 * It is creating when we are going to add information of new item to existing database.
 * It contains data about itemId, description, original price and bar code.
 * Every of input details should fit to certain format - otherwise program can not accept them.
 * <p>***</p>
 * Item class is used by Inscriber class to add new "item insert" to "sql_dml.txt".
 * It is also used by Tally class to add new object to ArrayList with every items in database
 * and create chart with existing itemId (this chart is needful to set correct itemId in Quantity class).
 * Tally class uses Item class also to create chart with existing bar code numbers to avoid duplicating values.
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */

class Item {

    /**
     * <code>nextItemId</code> is statistic variable which is used to create unique <code>itemId</code>
     * for every new instance of <code>Item class</code>.
     */

    private static int nextItemId = 0;

    /**
     * <code>itemId</code> is variable which is setting automatically during creating new item
     * (incrementation of <code>nextItemId</code> variable).
     */

    private int itemId;

    /**
     * <code>description</code> contains name and characteristics of new item.
     */

    private String description;

    /**
     * <code>originalPrice</code> contains primal price of new item.
     */

    private float originalPrice;

    /**
     * <code>originalPriceString</code> contains primal price of new item.
     * It is parsing to float variable in <code>setOriginalPrice()</code> method.
     * It is global variable because we check in other classes if her value equates "END".
     */

    private String originalPriceString;

    /**
     * <code>barCode</code> defines bare code.
     */

    private long barCode;

    /**
     * <code>barCodeTab</code> contains chart with bare codes.
     */

    private long barCodeTab[];

    /**
     * <code>df</code> defines indicated format for variables concerning money.
     */

    private DecimalFormat df;

    /**
     * <code>reader</code> is used to load data from user.
     */

    private Scanner reader = new Scanner(System.in);

    /**
     * In this constructor we execute method <code>setItemDetails()</code>
     * and in this way we get values of every using variables to create object of <code>Item class</code>.
     *
     * @param tally we use this object to get and set value of barCodeTab
     * @param df    we use this object to input value of originalPrice in indicated format
     */

    Item(Tally tally, DecimalFormat df) {

        this.barCodeTab = tally.chartWithBarCode();
        this.df = df;

        setItemDetails();
        System.out.println();

        this.itemId = ++nextItemId;
        this.description = getDescription();
        this.originalPrice = getOriginalPrice();
        this.originalPriceString = getOriginalPriceString();
        this.barCode = getBarCode();
    }

    /**
     * In method <code>toString()</code> is creating writing with details about single item object which is displaying
     * with other objects after calling <code>displayList()</code> method from <code>Tally class</code>.
     * Instead of concatenation of strings - method returns StringBuilder object.
     *
     * @return conglomerator
     */

    public String toString() {

        StringBuilder conglomerator = new StringBuilder("");
        conglomerator.append(itemId).append(" || ").append(description).append(" || ");
        conglomerator.append(df.format(originalPrice)).append(" || ").append(barCode);

        return String.valueOf(conglomerator);
    }

    /**
     * <code>setItemDetails</code> method is used to call methods like <code>setDescription(), setOriginalPrice()</code>
     * etc. to collect values of every variables essential to create new instance of <code>Item class</code> . Next
     * methods are calling till one of the variables (loading from user as Strings) equals "END". In this way new
     * item is not created and unique <code>itemId</code> which was booked for him can be reuse.
     */

    private void setItemDetails() {
        System.out.println("----------------------");
        System.out.println("WPROWADZ DANE ARTYKULU");
        System.out.println("----------------------");
        setDescription();
        if (!description.equals("END")) {
            setOriginalPrice();
            if (originalPrice != 0.0d) {
                setBarCode();
                if (barCode == 0) {
                    nextItemId--;
                }
            } else {
                nextItemId--;
            }
        } else {
            nextItemId--;
        }
    }

    /**
     * <code>getItemId()</code> method is used to return value of <code>itemIdId</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return itemId
     */

    int getItemId() {
        return itemId;
    }

    /**
     * <code>getDescription()</code> method is used to return value of <code>description</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return description
     */

    String getDescription() {
        return description;
    }

    /**
     * <code>getOriginalPrice</code> method is used to return value of <code>originalPrice</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return originalPrice
     */

    float getOriginalPrice() {
        return originalPrice;
    }

    /**
     * <code>getOriginalPriceString</code> method is used to return value of <code>originalPriceString</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return originalPriceString
     */

    String getOriginalPriceString() {
        return originalPriceString;
    }

    /**
     * <code>getBarCode</code> method is used to return value of <code>barCode</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return barCode
     */

    long getBarCode() {
        return barCode;
    }

    /**
     * <code>setDescription()</code> method is used to set <code>description</code> variable by user extracting
     * <code>Scanner class</code>. While value of variable it is not consistent with conditions incl. in Length class
     * - user has to set variable again.
     */

    private void setDescription() {
        System.out.print("Opis: ");

        do {
            description = reader.nextLine();
            if (description.length() > Length.longLengthOfString) {
                System.out.println("Opis sposobu realizacji nie moze miec wiecej niz " + Length.longLengthOfString + " znakow");
            }
        } while (description.length() > Length.longLengthOfString);
    }

    /**
     * <code>setOriginalPrice()</code> method is used to set <code> originalPrice </code> variable by user extracting
     * <code>Scanner class</code>.While value of variable it is not consistent with conditions incl. in Regex and
     * Length class - user has to set variable again.
     */

    private void setOriginalPrice() {

        System.out.print("Pierwotna cena: ");

        boolean loop = false;
        do {
            originalPriceString = reader.nextLine();
            if ((originalPriceString.equals("END")) && (!Regex.moneyPattern1.matcher(originalPriceString).matches()) &&
                    (!Regex.moneyPattern2.matcher(originalPriceString).matches()) && (!Regex.moneyPattern3.matcher(originalPriceString).matches())) {
                break;
            } else if ((!Regex.moneyPattern1.matcher(originalPriceString).matches()) && (!Regex.moneyPattern2.matcher(originalPriceString).matches())
                    && (!Regex.moneyPattern3.matcher(originalPriceString).matches())) {
                System.out.println("Podaj pierwotna cene jeszcze raz. Dopuszczalne sa tylko cyfry i znak '.' zastepujacy przecinek " +
                        "(max " + Length.moneyPrecision + " cyfr, w tym max " + Length.moneyScale + " po przecinku).");
            } else {
                originalPrice = Float.parseFloat(originalPriceString);
                loop = true;
            }
        } while (!loop);
    }

    /**
     * <code>setBarCode</code> method is used to set <code>barCode</code> variable by user extracting
     * <code>Scanner class</code>. While value of variable it is not consistent with conditions incl. in Regex
     * and Length class - user has to set variable again.Every new bar code must mu unique
     * - otherwise program can not accept them.
     */

    private void setBarCode() {

        System.out.print("Kod kreskowy: ");
        String barCodeString;
        boolean loop = false;
        int counter = 0;

        do {
            barCodeString = reader.nextLine();
            if ((barCodeString.equals("END")) && (!Regex.barCodePattern.matcher(barCodeString).matches())) {
                break;
            } else if (!Regex.barCodePattern.matcher(barCodeString).matches()) {
                System.out.println("Podaj kod kreskowy jeszcze raz. Musi zawierać " + Length.barCodeLength + " cyfr i pierwsza z nich nie moze byc '0'");
            } else {
                barCode = Long.parseLong(barCodeString);
                for (long aBarCodeTab : barCodeTab) {
                    if (barCode == aBarCodeTab) {
                        counter++;
                    }
                }
                if (counter == 1) {
                    System.out.println(("W bazie znajduje się artykul o takim kodzie. Podaj unikalny kod kreskowy"));
                    counter = 0;
                } else {
                    loop = true;
                }
            }
        } while (!loop);
    }
}