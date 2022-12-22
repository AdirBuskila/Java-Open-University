
public class Rent {

    final private static int MIN_DAYS = 1;
    final private static int RENTAL_PER_DAY_A = 100;
    final private static int RENTAL_PER_DAY_B = 150;
    final private static int RENTAL_PER_DAY_C = 180;
    final private static int RENTAL_PER_DAY_D = 240;
    final private static int RENTAL_DAYS_FOR_DISCOUNT = 7;
    final private static int DAYS_IN_WEEK = 7;
    final private static double TEN_PERCENT_DISCOUNT = 0.9;

    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;

    /*
     * public Rent​(java.lang.String name,
     * Car car,
     * Date pick,
     * Date ret)
     * Creates a new Rent object
     * The return date must be at least one day after the pick up date, otherwise
     * set it to one day after the pick up date.
     * Parameters:
     * name - the client name
     * car - the rented car
     * pick - the pickup date
     * ret - the return date
     */
    public Rent(String name, Car car, Date pick, Date ret) {
        _name = name;
        _car = car;
        _pickDate = pick;
        // checking if the difference between the pickDate and
        // the returnDate is less than 1
        _returnDate = (pick.difference(ret) < MIN_DAYS) ? pick.tomorrow() : ret;

    }

    /*
     * public Rent​(Rent other)
     * Copy constructor
     * Parameters:
     * other - the rent to be copied
     */
    public Rent(Rent other) {
        _name = other.getName();
        _car = new Car(other.getCar());
        _pickDate = new Date(other.getPickDate());
        _returnDate = new Date(other.getReturnDate());
    }

    /*
     * public void setName​(java.lang.String name)
     * Sets the client name
     * Parameters:
     * name - the client name (You can assume that the name is a valid name)
     * 
     */
    public void setName(String name) {
        // checking if the name is not an empty string
        if (name != "") {
            _name = name;
        }
    }

    /*
     * public java.lang.String getName()
     * Gets the name
     * Returns:
     * the name
     */
    public String getName() {
        return _name;
    }

    /*
     * public void setCar​(Car car)
     * Sets the rented car
     * Parameters:
     * car - the rented car (You can assume that car is not null)
     */
    public void setCar(Car car) {
        // checking if the car is not equal to null
        if (car != null) {
            _car = new Car(car);
        }
    }

    /*
     * public Car getCar()
     * Gets the car
     * Returns:
     * the car
     */
    public Car getCar() {
        return new Car(_car);
    }

    /*
     * public void setPickDate​(Date pickDate)
     * Sets the pick up date
     * The pick up date must be at least one day before the return date, otherwise -
     * don't change the pick up date
     * Parameters:
     * pickDate - the pick up date (You can assume that pick up date is not null)
     */
    public void setPickDate(Date pickDate) {
        // checking if the pickDate is not equal to null
        if (pickDate != null) {
            _pickDate = new Date(pickDate);
        }
    }

    /*
     * public Date getPickDate()
     * Gets the pick up date
     * Returns:
     * the pick up date
     */
    public Date getPickDate() {
        return new Date(_pickDate);

    }

    /*
     * public void setReturnDate​(Date returnDate)
     * Sets the return date
     * The return date must be at least one day after the pick up date, otherwise -
     * don't change the return date
     * Parameters:
     * returnDate - the return date (You can assume that return date is not null)
     */
    public void setReturnDate(Date returnDate) {
        // checking if the returnDate is not equal to null
        if (returnDate != null) {
            _returnDate = new Date(returnDate);
        }
    }

    /*
     * public Date getReturnDate()
     * Gets the return date
     * Returns:
     * the return date
     */
    public Date getReturnDate() {
        return new Date(_returnDate);
    }

    /*
     * public boolean equals​(Rent other)
     * Check if 2 rents are the same
     * Parameters:
     * other - the rent to compare this rent to
     * Returns:
     * true if the rents are the same
     */
    public boolean equals(Rent other) {
        return (_name.equals(other.getName())
                && _car.equals(other.getCar())
                && _pickDate.equals(other.getPickDate())
                && _returnDate.equals(other.getReturnDate()));
    }

    /*
     * public int howManyDays()
     * Returns the number of rent days
     * Returns:
     * the number of rent days
     */
    public int howManyDays() {
        // returning how many days is between the pickupDate
        // and the returnDate
        return (_pickDate.difference(_returnDate));
    }

    /*
     * public int getPrice()
     * Returns the rent total price
     * Returns:
     * the rent total price
     */
    public int getPrice() {
        // getting the how many rental days are there
        int rentalDays = howManyDays();
        // checking how many whole weeks are there in the rend period
        int wholeWeeks = rentalDays / RENTAL_DAYS_FOR_DISCOUNT;
        // checking how many remaining days are there, ie: 15 % 7 = 1
        int remainingDays = rentalDays % RENTAL_DAYS_FOR_DISCOUNT;
        int price = 0;
        switch (_car.getType()) {
            // calculating by:
            // 1) whole weeks multiplied by 7 (days in week) multiplied by rental per type
            // multiplied by ten percent discount
            // plus
            // 2) remaining days multiplied by rental per type
            case 'A':
                price = (int) (wholeWeeks * DAYS_IN_WEEK * RENTAL_PER_DAY_A * TEN_PERCENT_DISCOUNT)
                        + (remainingDays * RENTAL_PER_DAY_A);
                break;
            case 'B':
                price = (int) (wholeWeeks * DAYS_IN_WEEK * RENTAL_PER_DAY_B * TEN_PERCENT_DISCOUNT)
                        + (remainingDays * RENTAL_PER_DAY_B);
                break;
            case 'C':
                price = (int) (wholeWeeks * DAYS_IN_WEEK * RENTAL_PER_DAY_C * TEN_PERCENT_DISCOUNT)
                        + (remainingDays * RENTAL_PER_DAY_C);
                break;
            case 'D':
                price = (int) (wholeWeeks * DAYS_IN_WEEK * RENTAL_PER_DAY_D * TEN_PERCENT_DISCOUNT)
                        + (remainingDays * RENTAL_PER_DAY_D);
                break;

            default:
                break;
        }
        return price;
    }

    /*
     * public int upgrade​(Car car)
     * Try to upgrade the car to a better car
     * If the given car is better than the current car of the rent, upgrade it and
     * return the upgrade additional cost, otherwise - don't upgrade
     * Parameters:
     * car - the car to upgrade to
     * Returns:
     * the upgrade cost
     * 
     */
    public int upgrade(Car newCar) {
        // checking if the current car is better than the new car
        if (_car.better(newCar)) {
            return 0;
        }
        // getting the old price
        int oldPrice = getPrice();
        // setting _car to the new car
        setCar(newCar);
        // getting the new price
        int newPrice = getPrice();
        // returning the difference between the prices
        return (newPrice - oldPrice);
    }

    /*
     * public java.lang.String toString()
     * Returns a String that represents this rent
     * Overrides:
     * toString in class java.lang.Object
     * Returns:
     * String that represents this rent in the following format:
     * Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
     */
    public String toString() {
        return "Name:" + _name + " From:" + _pickDate + " To:" + _returnDate + " Type:" + _car.getType() + " Days:"
                + howManyDays() + " Price:" + getPrice();
    }

    public static void main(String[] args) {
        Car busiCar = new Car(1234567, 'A', "Ford", false);
        Date d1 = new Date(10, 3, 2022);
        Date d2 = new Date(14, 11, 2022);
        Rent r1 = new Rent("Busi", busiCar, d1, d2);
        Rent r2 = new Rent("Busi", busiCar, d1, d2);
        System.out.println("---equals---");
        System.out.println(r1.equals(r2)); // true
        System.out.println("---howManyDays---");
        r1 = new Rent("Busi", busiCar, new Date(1, 2, 2022), new Date(8, 2, 2022));
        System.out.println(r1.howManyDays()); // 7
        System.out.println("---getPrice---");
        System.out.println(r1.getPrice()); // 630
        r1.setReturnDate(new Date(10, 2, 2022));
        System.out.println(r1.howManyDays()); // 9
        System.out.println(r1.getPrice()); // 830

    }
}
