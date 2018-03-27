import java.util.regex.Pattern;

/**
 * Class <code>Regex</code> retains information about regex patters.
 * Implementing value must suits to requirements - otherwise creating new object will be terminated or user will
 * have to input new data till conditions will be fulfilled.
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */

class Regex {

    /**
     * <code>bigSmallLettersPattern</code> allows to add writing with small and big letters without polish signs.
     * It checks correctness of <code>name, surname, city, country</code> from <code>Customer class</code>.
     */

    static Pattern bigSmallLettersPattern = Pattern.compile("[A-Za-z]+");

    /**
     * <code>phoneNumberPattern</code> allows to add writing with digits and "+" sign.
     * It checks correctness of <code>phoneNumber</code> from <code>Customer class</code>.
     */

    static Pattern phoneNumberPattern = Pattern.compile("[0-9+]+");

    /**
     * <code>datePattern</code> allows to add writing in format : "yyyy.mm.dd".
     * It checks correctness of <code>orderDate</code> from <code>Order class</code>.
     */

    static Pattern datePattern = Pattern.compile("[0-9]{4}\\.[0-1][0-9]\\.[0-3][0-9]");

    /**
     * <code>moneyPattern1</code> allows to add writing with max 7 digits (min 1 digit), dot and exactly 2 digits directly after dot.
     * It is one from tree acceptable patterns which checks correctness of <code>originalPrice</code> from <code>Item class</code>,
     * <code>extraCost</code> from <code>Order class</code> and <code>averageItemPrice</code> from <code>Quantity class</code>.
     */

    static Pattern moneyPattern1 = Pattern.compile("[0-9]{1,7}\\.[0-9]{2}");

    /**
     * <code>moneyPattern2</code> allows to add writing with max 8 digits (min 1 digit), dot and exactly 1 digit directly after dot.
     * It is one from tree acceptable patterns which checks correctness of <code>originalPrice</code> from <code>Item class</code>,
     * <code>extraCost</code> from <code>Order class</code> and <code>averageItemPrice</code> from <code>Quantity class</code>.
     */

    static Pattern moneyPattern2 = Pattern.compile("[0-9]{1,8}\\.[0-9]");

    /**
     * <code>moneyPattern3</code> allows to add writing with max 9 digits (min 1 digit).
     * It is one from tree acceptable patterns which checks correctness of <code>originalPrice</code> from <code>Item class</code>,
     * <code>extraCost</code> from <code>Order class</code> and <code>averageItemPrice</code> from <code>Quantity class</code>.
     */

    static Pattern moneyPattern3 = Pattern.compile("[0-9]{1,9}");

    /**
     * <code>barCodePattern</code> allows to add writing with exactly 13 digits and first of them can not be 0.
     * It checks correctness of <code>barCode</code> from <code>Item class</code>.
     */

    static Pattern barCodePattern = Pattern.compile("[1-9][0-9]{12}");

}
