
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
    private Date _pickupDate;
    private Date _returnDate;

    public Rent(String name, Car car, Date pickupDate, Date returnDate) {
        _name = name;
        _car = car;
        _pickupDate = pickupDate;
        if (pickupDate.difference(returnDate) < MIN_DAYS) {
            _returnDate = _pickupDate.tomorrow();
        } else {
            _returnDate = returnDate;
        }
    }

    public Rent(Rent other) {
        _name = other.getName();
        _car = new Car(other.getCar());
        _pickupDate = new Date(other.getPickupDate());
        _returnDate = new Date(other.getReturnDate());
    }

    public void setName(String name) {
        if (name != "") {
            _name = name;
        }
    }

    public String getName() {
        return _name;
    }

    public void setCar(Car car) {
        if (car != null) {
            _car = new Car(car);
        }
    }

    public Car getCar() {
        return new Car(_car);
    }

    public void setPickDate(Date pickDate) {
        if (pickDate != null) {
            _pickupDate = new Date(pickDate);
        }
    }

    public Date getPickupDate() {
        return new Date(_pickupDate);

    }

    public void setReturnDate(Date returnDate) {
        if (returnDate != null) {
            _returnDate = new Date(returnDate);
        }
    }

    public Date getReturnDate() {
        return new Date(_returnDate);
    }

    public boolean equals(Rent other) {
        return (_name.equals(other.getName())
                && _car.equals(other.getCar())
                && _pickupDate.equals(other.getPickupDate())
                && _returnDate.equals(other.getReturnDate()));
    }

    public int howManyDays() {
        return (_pickupDate.difference(_returnDate));
    }

    public int getPrice() {
        int rentalDays = howManyDays();
        int wholeWeeks = rentalDays / RENTAL_DAYS_FOR_DISCOUNT;
        int remainingDays = rentalDays % RENTAL_DAYS_FOR_DISCOUNT;
        int price = 0;
        switch (_car.getType()) {
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

    public int upgrade(Car newCar) {
        if (_car.isBetter(newCar)) {
            return 0;
        }
        int oldPrice = getPrice();
        _car = newCar;
        int newPrice = getPrice();
        return (newPrice - oldPrice);
    }

    public String toString() {
        return "Name:" + _name + " From:" + _pickupDate + " To:" + _returnDate + " Type:" + _car.getType() + " Days:"
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
        r1 = new Rent("Busi", busiCar, new Date(1, 2, 2022), new Date(5, 2, 2022));
        System.out.println(r1.howManyDays()); // 4

    }
}
