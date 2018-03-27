import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Plank of this program it enabling user (worker of the shop) inputting records to existing database of the shop
 * which will be in compliance with plenty of conditions imposed by structure of database.
 * <p>***</p>
 * On the beginning of the program user gets instruction how to input information to database about new <code>Customer,
 * Item, Order and Quantity</code>. He can also display list with details of every created objects of that classes and
 * finalize working of the program. Menu is available after pressing "M".
 * <p>***</p>
 * Anytime, during date entering there is option to resign with putting new record to database - user has to write "END"
 * instead of inputting correct and acceptable values of variables like for example <code>name, orderDate, itemId</code>.
 * Existing conditions will close the door on inputting this object to the proper list and to "sql_dml.txt" file.
 * <p>***</p>
 * In <code>Main</code> class of the program are created basic and essential objects of class like <code>Decimal
 * Writer, Inscriber, Scanner and Tally</code>. Instance of class like <code>Customer, Item, Order and Quantity
 * are optional - they are generated only if user chooses proper option and data entering will be not suspended.
 * <p>***</p>
 * Data entering there is in while loop which goes round till user press "9" - what saving data in "sql_dml.txt" file
 * and ends working of the program. Switch statement is using to check inputting information and then to boot up
 * creating new object and/or to trigger of proper methods. When user do not choose option which is included in switch
 * statement - he is asking about setting his choice again.
 *
 * 
 * <code>Scanner class</code>
 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */

public class Main {

    public static void main(String[] args) {

        try {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(Length.moneyScale);
            df.setMinimumFractionDigits(Length.moneyScale);

            Writer writer = new BufferedWriter(new FileWriter("sql_dml.txt"));
            Inscriber inscriber = new Inscriber();
            Scanner reader = new Scanner(System.in);
            Tally tally = new Tally();

            StringBuilder menu = new StringBuilder("Wybierz numer którejś z poniższych opcji(1,2,3,4,5,6,7,8,9):");
            menu.append("\n").append("1.Wprowadzanie danych klienta").append("\n").append("2.Wprowadzanie danych artykułu");
            menu.append("\n").append("3.Wprowadzanie danych zamowienia").append("\n").append("4.Wprowadzanie ilości artykułów");
            menu.append("\n").append("5.Wyswietl liste klientow").append("\n").append("6.Wyswietl liste artykulow");
            menu.append("\n").append("7.Wyswietl liste zamowien").append("\n").append("8.Wyswietl liste z ilosciami artykulow");
            menu.append("\n").append("9.Zakończ").append("\n");
            menu.append("\n").append("W kazdej chwili wprowadzania danych (opcje 1,2,3,4) mozesz zrezygnowac wpisujac 'END'");
            menu.append("\n").append("W momencie przerwania wpisywania danych rekord nie zostanie wpisany na liste i do pliku '*.txt'.");
            String newChoice = "Wybierz numer kolejnej opcji(1-9). Zeby wyswietlic menu wcisnij 'M'";


            System.out.println(menu);

            boolean loop = true;
            while (loop) {

                String choice = reader.nextLine();

                switch (choice) {

                    case "1":
                        Customer customer = new Customer();
                        inscriber.inscribeCustomerToFile(writer, customer);
                        tally.addCustomerToTheList(customer);
                        System.out.println(newChoice);
                        break;

                    case "2":
                        Item item = new Item(tally, df);
                        inscriber.inscribeItemToFile(writer, item);
                        tally.addItemToTheList(item);
                        System.out.println(newChoice);
                        break;

                    case "3":
                        Order order = new Order(tally, df);
                        inscriber.inscribeOrderToFile(writer, order);
                        tally.addOrderToTheList(order);
                        System.out.println(newChoice);
                        break;

                    case "4":
                        Quantity quantity = new Quantity(tally, df);
                        inscriber.inscribeQuantityToFile(writer, quantity);
                        tally.addQuantityToTheList(quantity);
                        System.out.println(newChoice);
                        break;

                    case "5":
                        tally.displayList(Tally.CUSTOMER_LIST);
                        System.out.println(newChoice);
                        break;

                    case "6":
                        tally.displayList(Tally.ITEM_LIST);
                        System.out.println(newChoice);
                        break;

                    case "7":
                        tally.displayList(Tally.ORDER_LIST);
                        System.out.println(newChoice);
                        break;

                    case "8":
                        tally.displayList(Tally.QTY_LIST);
                        System.out.println(newChoice);
                        break;

                    case "9":
                        System.out.println("Dane zostaly zapisane");
                        loop = false;
                        reader.close();
                        writer.close();
                        break;

                    case "M":
                        System.out.println(menu);
                        break;

                    default:
                        System.out.println("Dokonaj wyboru zgodnie z instrukcją");
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}



