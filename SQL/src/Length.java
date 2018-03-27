/**
 * Class <code>Length</code> retains information about limits concerning numbers of signs
 * which can sit in character string inputting by user during creating new customer, item, order or quantity.
 * Most limits correspond with data in ERD diagram of database. One of them concerning max value of int data type.
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */

class Length {

    /**
     * <code>shortLengthOfString</code> variable concerns  <code>name, surname, firstAddressLine, secondAddressLine,
     * city, country, phoneNumber</code> from <code>Customer class</code>.
     */

    final static int shortLengthOfString = 20;

    /**
     * <code>mediumLengthOfString</code> variable concerns <code>meansOfImplementation</code> from <code>Order class</code>.
     */

    final static int mediumLengthOfString = 30;

    /**
     * <code>longLengthOfString</code> variable concerns <code>description</code> from <code>Item class</code>.
     */

    final static int longLengthOfString = 40;

    /**
     * <code>barCodeLength</code> variable concerns <code>barCode</code> from <code>Item class</code>.
     */

    final static int barCodeLength = 13;

    /**
     * <code>moneyPrecision</code> variable concerns <code>originalPrice</code> from <code>Item class</code>,
     * <code>extraCost</code> from <code>Order class</code> and <code>averageItemPrice</code> from <code>Quantity class</code>.
     */

    final static int moneyPrecision = 9;

    /**
     * <code>moneyScale</code> variable concerns <code>originalPrice</code> from <code>Item class</code>,
     * <code>extraCost</code> from <code>Order class</code> and <code>averageItemPrice</code> from
     * <code>Quantity class</code>.It is also used to set object of <code>DecimalFormat</code>
     * (every variables concerning money are displaying on the list according to this format).
     */

    final static int moneyScale = 2;

    /**
     * <code>intMaxValue</code> variable concerns <code>quantity</code> from <code>Quantity class</code>
     * and every "id" which are foreign keys from other tables(classes).
     */

    final static int intMaxValue = Integer.MAX_VALUE;

}
