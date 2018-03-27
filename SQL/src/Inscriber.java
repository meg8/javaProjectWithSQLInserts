import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Class <code>Inscriber</code> retains methods concerning to input information of consumer, item, order or quantity
 * to "sql_dml.txt". Calling them is leading to prepare ready "Insert" of record in SQL language which can be use in
 * oracle database to add new row to existing table. Writing will be add to the file only if process of creating new object
 * of Consumer, Item, Order, Quantity was terminated successfully.
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */

class Inscriber {

    /**
     * <code>inscribeCustomerToFile</code> method includes 2 parameters like
     *
     * @param customer it states object from <code>Customer class</code> which will be add to file
     * @param writer   it states place where we would like to add new writing
     *
     * Writing is adding to the file if it suits to requirements - otherwise nothing happens.
     */

    void inscribeCustomerToFile(Writer writer, Customer customer) {
        try {
            if ((!customer.getName().equals("END")) && (!customer.getSurname().equals("END")) && (!customer.getFirstAddressLine().equals("END")) &&
                    (!customer.getSecondAddressLine().equals("END")) && (!customer.getCity().equals("END")) && (!customer.getCountry().equals("END"))
                    && (!customer.getPhoneNumber().equals("END"))) {
                writer.write("INSERT INTO CUSTOMER VALUES(" + customer.getCustomerId() + ",'" + customer.getName() +
                        "','" + customer.getSurname() + "','" + customer.getFirstAddressLine() + "','" + customer.getSecondAddressLine() +
                        "','" + customer.getCity() + "','" + customer.getCountry() + "');");
                ((BufferedWriter) writer).newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <code>inscribeOrderToFile</code> method includes 2 parameters like
     *
     * @param order  - it states object from <code>Order class</code> which will be add to file
     * @param writer - it states place where we would like to add new writing
     *
     * Writing is adding to the file if it suits to requirements - otherwise nothing happens.
     */

    void inscribeOrderToFile(Writer writer, Order order) {
        try {
            if ((order.getCustomerId() != 0) && (!order.getOrderDate().equals("END")) &&
                    (!order.getMeansOfImplementation().equals("END")) && (!order.getExtraCostString().equals("END"))) {
                writer.write("INSERT INTO ORDER VALUES(" + order.getOrderId()
                        + "," + order.getCustomerId() + ",'" + order.getOrderDate() +
                        "','" + order.getMeansOfImplementation() + "'," + order.getExtraCost() + ");");
                ((BufferedWriter) writer).newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <code>inscribeItemToFile</code> method includes 2 parameters like
     *
     * @param item   it states object from <code>Item class</code> which will be add to file
     * @param writer it states place where we would like to add new writing
     *
     * Writing is adding to the file if it suits to requirements - otherwise nothing happens.
     */

    void inscribeItemToFile(Writer writer, Item item) {
        try {
            if ((!item.getDescription().equals("END") && (!item.getOriginalPriceString().equals("END")) && (item.getBarCode() != 0))) {
                writer.write("INSERT INTO ITEM VALUES(" + item.getItemId()
                        + ",'" + item.getDescription() + "'," + item.getOriginalPrice() + "," + item.getBarCode() + ");");
                ((BufferedWriter) writer).newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <code>inscribeQuantityToFile</code> method includes 2 parameters like
     *
     * @param quantity it states object from <code>Quantity</code> which will be add to file
     * @param writer   it states place where we would like to add new writing
     *
     * Writing is adding to the file if it suits to requirements - otherwise nothing happens.
     */

    void inscribeQuantityToFile(Writer writer, Quantity quantity) {
        try {
            if ((quantity.getOrderId() != 0) && (quantity.getItemId() != 0 && (quantity.getQuantity() != 0)) && (!quantity.getAverageItemPriceString().equals("END"))) {
                writer.write("INSERT INTO QUANTITY VALUES(" + quantity.getOrderId()
                        + "," + quantity.getItemId() + "," + quantity.getQuantity() + "," + quantity.getAverageItemPrice() + ");");
                ((BufferedWriter) writer).newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
