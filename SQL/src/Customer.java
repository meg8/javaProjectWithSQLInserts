import java.util.Scanner;

/**
 * Object <code>Customer</code> represents table of online shop database.
 * It is creating when we are going to add information of new customer to existing database.
 * It contains data about customerId, name, surname, address and telephone number.
 * Every input details should fit to certain format - otherwise program can not accept them.
 *<p>***</p>
 * Customer class is used by <code>Inscriber class</code> to add new "customer insert" to "sql_dml.txt".
 * It is also used by <code>Tally class</code> to add new object to ArrayList with every customers and
 * to create chart with existing <code>customerId</code>
 * (this chart is needful to set correct <code>customerId</code> in <code>Order class</code>.

 *
 * @author Magdalena Wisniewska
 * @version 2.0 15.03.2018
 */

public class Customer {

    /**
     * <code>nextCustomerId</code> is statistic variable which is used to create unique <code>consumerId</code>
     * for every new instance of <code>Consumer class</code>.
     */
    private static int nextCustomerId = 0;

    /**
     * <code>customerId</code> is variable which is setting automatically during creating new customer
     * (incrementation of <code>nextCustomerId</code> variable).
     */

    private int customerId;

    /**
     * <code>name</code> describes name of new customer. For companies - person who is making an order.
     */

    private String name;

    /**
     * <code>surname</code> describes surname of new customer. For companies - person who is making an order.
     */

    private String surname;

    /**
     * <code>firstAddressLine</code> describes address of new customer. It should contains for example name of street,
     * number of house/local, name of company. Everything depends of character of customer and country/region.
     */

    private String firstAddressLine;

    /**
     * <code>secondAddressLine</code> describes address of new customer. It should contains for example postcode,
     * name of province. Everything depends of character of country/region.
     */

    private String secondAddressLine;

    /**
     * <code>city</code> describes city of new customer.
     */

    private String city;

    /**
     * <code>country</code> describes country of new customer.
     */
    private String country;

    /**
     * <code>phoneNumber</code> describes telephone number of new customer.
     */

    private String phoneNumber;

    /**
     * <code>reader</code> is used to load data from user.
     */

    private Scanner reader = new Scanner(System.in);

    /**
     * In this constructor we execute method <code>setCustomerDetails()</code>
     * and in this way we get values of every using variables to create object of <code>Customer class</code>.
     */

    Customer() {

        setCustomerDetails();
        System.out.println();

        this.customerId = ++nextCustomerId;
        this.name = getName();
        this.surname = getSurname();
        this.firstAddressLine = getFirstAddressLine();
        this.secondAddressLine = getSecondAddressLine();
        this.city = getCity();
        this.country = getCountry();
        this.phoneNumber = getPhoneNumber();

    }

    /**
     * In method <code>toString()</code> is creating writing with details about single consumer object
     * which is displaying with other objects after calling <code>displayList()</code> method from
     * <code>Tally class</code>. Instead of concatenation of strings - method returns StringBuilder object.
     *
     * @return conglomerator
     */

    public String toString() {

        StringBuilder conglomerator = new StringBuilder("");
        conglomerator.append(customerId).append(" || ").append(name).append(" || ").append(surname).append(" || ");
        conglomerator.append(firstAddressLine).append(" || ").append(secondAddressLine).append(" || ");
        conglomerator.append(city).append(" || ").append(country).append(" || ").append(phoneNumber);

        return String.valueOf(conglomerator);
    }

    /**
     * <code>setCustomerDetails</code> method is used to call methods like <code>setName(), setSurname()</code>  etc.
     * to collect values of every variable essential to create new instance of <code>Customer class</code> .
     * Next methods are calling till one of the variables (loading from user as Strings) equals "END".
     * In this way new customer is not created and unique <code>customerId</code> which was booked for him can be reuse.
     */

    private void setCustomerDetails() {
        System.out.println("----------------------");
        System.out.println("WPROWADZ DANE KLIENTA");
        System.out.println("----------------------");
        setName();
        if (!name.equals("END")) {
            setSurname();
            if (!surname.equals("END")) {
                setFirstAddressLine();
                if (!firstAddressLine.equals("END")) {
                    setSecondAddressLine();
                    if (!secondAddressLine.equals("END")) {
                        setCity();
                        if (!city.equals("END")) {
                            setCountry();
                            if (!country.equals("END")) {
                                setPhoneNumber();
                                if (phoneNumber.equals("END")) {
                                    nextCustomerId--;
                                }
                            } else {
                                nextCustomerId--;
                            }
                        } else {
                            nextCustomerId--;
                        }
                    } else {
                        nextCustomerId--;
                    }
                } else {
                    nextCustomerId--;
                }
            } else {
                nextCustomerId--;
            }
        } else {
            nextCustomerId--;
        }
    }

    /**
     * <code>getCustomerId()</code> method is used to return value of <code>customerId</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return customerId
     */

    int getCustomerId() {
        return customerId;
    }

    /**
     * <code>getName()</code> method is used to return value of <code> name </code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return name
     */

    String getName() {
        return name;
    }

    /**
     * <code>getSurname()</code> method is used to return value of <code>surname</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return surname
     */

    String getSurname() {
        return surname;
    }

    /**
     * <code>getFirstAddressLine()</code> method is used to return value of <code>firstAddressLine</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return firstAddressLine
     */

    String getFirstAddressLine() {
        return firstAddressLine;
    }

    /**
     * <code>getSecondAddressLine()</code> method is used to return value of <code>secondAddressLine</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return secondAddressLine
     */

    String getSecondAddressLine() {
        return secondAddressLine;
    }

    /**
     * <code>getCity()</code> method is used to return value of <code>city</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return city
     */

    String getCity() {
        return city;
    }

    /**
     * <code>getCountry()</code> method is used to return value of <code>country</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return country
     */

    String getCountry() {
        return country;
    }

    /**
     * <code>getPhoneNumber()</code> method is used to return value of <code>phoneNumber</code> variable.
     * Access to this variable is private so if we would like te use it in another class - we have to call this method.
     *
     * @return phoneNumber
     */

    String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * <code>setName()</code> method is used to set <code>name</code> variable by user extracting
     * <code>Scanner class</code>.While value of variable it is not consistent with conditions incl. in Regex
     * and Length class - user has to set variable again.
     */

    private void setName() {

        System.out.print("Imie klienta: ");
        do {
            name = reader.nextLine();
            if (!Regex.bigSmallLettersPattern.matcher(name).matches() || (name.length() > Length.shortLengthOfString)) {
                System.out.println("Podaj imie klienta jeszcze raz. Dopuszczalne sa tylko male i duze litery (max "
                        + Length.shortLengthOfString + " znakow)");
            }
        }
        while ((!Regex.bigSmallLettersPattern.matcher(name).matches()) || (name.length() > Length.shortLengthOfString));
    }

    /**
     * <code>setSurname()</code> method is used to set <code>surname</code> variable by user extracting
     * <code>Scanner class</code>.While value of variable it is not consistent with conditions incl.
     * in Regex and Length class - user has to set variable again.
     */

    private void setSurname() {

        System.out.print("Nazwisko klienta: ");
        do {
            surname = reader.nextLine();
            if (!Regex.bigSmallLettersPattern.matcher(surname).matches() || (surname.length() > Length.shortLengthOfString)) {
                System.out.println("Podaj nazwisko klienta jeszcze raz. Dopuszczalne sa tylko male i duze litery " +
                        "(max " + Length.shortLengthOfString + " znakow)");
            }
        }
        while ((!Regex.bigSmallLettersPattern.matcher(surname).matches()) || (surname.length() > Length.shortLengthOfString));
    }

    /**
     * <code>setFirstAddressLine()</code> method is used to set <code>firstAddressLine</code> variable by user extracting
     * <code>Scanner class</code>.While value of variable it is not consistent with conditions incl. in Length class -
     * user has to set variable again.
     */

    private void setFirstAddressLine() {
        System.out.print("Pierwsza linia adresu: ");
        do {
            firstAddressLine = reader.nextLine();
            if (firstAddressLine.length() > Length.shortLengthOfString) {
                System.out.println("Linia adresu nie moze miec wiecej niz " + Length.shortLengthOfString + " znakow");
            }
        } while (firstAddressLine.length() > Length.shortLengthOfString);
    }

    /**
     * <code>setSecondAddressLine()</code> method is used to set <code>secondAddressLine</code> variable by user
     * extracting <code>Scanner class</code>. While value of variable it is not consistent with conditions incl.
     * in Length class - user has to set variable again.
     */

    private void setSecondAddressLine() {
        System.out.print("Druga linia adresu: ");
        do {
            secondAddressLine = reader.nextLine();
            if (secondAddressLine.length() > Length.shortLengthOfString) {
                System.out.println("Linia adresu nie moze miec wiecej niz " + Length.shortLengthOfString + " znakow");
            }
        } while (secondAddressLine.length() > Length.shortLengthOfString);
    }

    /**
     * <code>setCity()</code> method is used to set <code>city</code> variable by user extracting
     * <code>Scanner class</code>. While value of variable it is not consistent with conditions incl. in Regex and
     * Length class - user has to set variable again.
     */

    private void setCity() {


        System.out.print("Miasto:");
        do {
            city = reader.nextLine();
            if (!Regex.bigSmallLettersPattern.matcher(city).matches() || (city.length() > Length.shortLengthOfString)) {
                System.out.println("Podaj nazwe miasta jeszcze raz. Dopuszczalne sa tylko male i duze litery" +
                        "(max " + Length.shortLengthOfString + " znakow)");
            }
        }
        while (!Regex.bigSmallLettersPattern.matcher(city).matches() || (city.length() > Length.shortLengthOfString));
    }

    /**
     * <code>setCountry()</code> method is used to set <code>country</code> variable by user extracting
     * <code>Scanner class</code>. While value of variable it is not consistent with conditions incl.
     * in Regex and Length class - user has to set variable again.
     */

    private void setCountry() {

        System.out.print("Panstwo:");
        do {
            country = reader.nextLine();
            if (!Regex.bigSmallLettersPattern.matcher(country).matches() || (country.length() > Length.shortLengthOfString)) {
                System.out.println("Podaj nazwe państwa jeszcze raz. Dopuszczalne sa tylko male i duze litery" +
                        "(max " + Length.shortLengthOfString + " znakow)");
            }
        }
        while (!Regex.bigSmallLettersPattern.matcher(country).matches() || (country.length() > Length.shortLengthOfString));
    }

    /**
     * <code>setPhoneNumber()</code> method is used to set <code>phoneNumber</code> variable by user extracting
     * <code>Scanner class</code>. While value of variable it is not consistent with conditions incl.
     * in Regex and Length class - user has to set variable again.
     */

    private void setPhoneNumber() {

        System.out.print("Numer telefonu:");
        do {
            phoneNumber = reader.nextLine();
            if ((phoneNumber.equals("END")) && (!Regex.phoneNumberPattern.matcher(phoneNumber).matches())) {
                break;
            } else if (!Regex.phoneNumberPattern.matcher(phoneNumber).matches() ||
                    (phoneNumber.length() > Length.shortLengthOfString)) {
                System.out.println("Podaj numer telefonu jeszcze raz. Dopuszczalne sa tylko cyfry i znak '+' " +
                        "(max " + Length.shortLengthOfString + " znakow)");
            }
        }
        while (!Regex.phoneNumberPattern.matcher(phoneNumber).matches() || (phoneNumber.length() > Length.shortLengthOfString));
    }
}

