public class Company {
    final private static int MAX_RENTS = 1000;

    private Rent[] _rents;
    private int _noOfRents;

    public Company() {
        _rents = new Rent[MAX_RENTS];
        _noOfRents = 0;
    }

    public boolean addRent(String name, Car car, Date pickupDate, Date returnDate) {
        if (_noOfRents == 0) {
            _rents[0] = new Rent(name, car, pickupDate, returnDate);
            _noOfRents++;
            return true;
        } else if (_noOfRents == MAX_RENTS) {
            return false;
        }
        int index = getInsertIndex(pickupDate, returnDate);
        Rent[] newRents = new Rent[MAX_RENTS];
        int j = 0;
        _noOfRents++;
        for (int i = 0; i < _noOfRents + 1; i++) {
            if (i == index) {
                newRents[i] = new Rent(name, car, pickupDate, returnDate);
            } else {
                newRents[i] = _rents[j];
                j++;
            }
        }
        _rents = newRents;
        return true;
    }

    public boolean removeRent(Date d) {
        if (_noOfRents == 0) {
            return false;
        }
        int index = getDeleteIndex(d);
        if (index == -1)
            return false;
        Rent[] newRents = new Rent[MAX_RENTS];
        for (int i = 0, k = 0; i < _noOfRents; i++) {
            // 1 2 3
            if (i == index) {
                continue;
            }
            newRents[k++] = _rents[i];
        }
        _rents = newRents;
        _noOfRents--;
        return true;
    }

    private int getInsertIndex(Date pick, Date ret) {
        int index = _noOfRents;
        for (int i = 0; i < _noOfRents; i++) {
            Date curPickupDate = _rents[i].getPickDate();
            Date curReturnDate = _rents[i].getReturnDate();
            if (pick.equals(curPickupDate) && ret.after(curReturnDate)) {
                return i;
            }
            if (pick.equals(curPickupDate) && curPickupDate.after(ret)) {
                return i;
            }
            if (pick.before(curPickupDate)) {
                return i;
            }
        }
        return index;
    }

    private int getDeleteIndex(Date date) {
        for (int i = 0; i < _noOfRents; i++) {
            Date curReturnDate = _rents[i].getReturnDate();
            if (date.equals(curReturnDate)) {
                return i;
            }
        }
        return -1;

    }

    public Car lastCarRent() {
        if (_noOfRents == 0) {
            return null;
        } else if (_noOfRents == 1) {
            return _rents[0].getCar();
        }
        Rent rent = _rents[0]; // getting the first rent
        for (int i = 1; i < _noOfRents; i++) {
            Rent curRent = _rents[i];
            if (curRent.getReturnDate().after(rent.getReturnDate())) {
                rent = curRent;
            }
        }
        return rent.getCar();
    }

    public int getSumOfPrices() {
        int sum = 0;
        for (int i = 0; i < _noOfRents; i++) {
            sum += _rents[i].getPrice();
        }
        return sum;
    }

    public int getSumOfDays() {
        int days = 0;
        for (int i = 0; i < _noOfRents; i++) {
            days += _rents[i].howManyDays();
        }
        return days;
    }

    public double averageRent() {
        if (_noOfRents == 0) {
            return 0;
        }
        return ((double) getSumOfDays() / (double) _noOfRents);
    }

    public char mostCommonRate() {

        if (_noOfRents == 0) {
            return 'N';
        } else if (_noOfRents == 1) {
            return _rents[0].getCar().getType();
        }

        char[] rates = { 'A', 'B', 'C', 'D' };
        int[] frequencies = new int[rates.length];

        for (int i = 0; i < _noOfRents; i++) {
            switch (_rents[i].getCar().getType()) {
                case 'A':
                    frequencies[0] += 1;
                    break;
                case 'B':
                    frequencies[1] += 1;
                    break;
                case 'C':
                    frequencies[2] += 1;
                    break;
                case 'D':
                    frequencies[3] += 1;
                    break;
                default:
                    break;
            }
        }
        int max = -1;// setting as first
        int maxIndex = -1;
        int maxIndexTwo = -1;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                maxIndex = i;
            } else if (max != 0 && frequencies[i] == max) {
                maxIndexTwo = i;
            }
        }
        if (maxIndexTwo == -1)
            return rates[maxIndex];
        else {
            if (rates[maxIndex] > rates[maxIndexTwo])
                return rates[maxIndex];
            else
                return rates[maxIndexTwo];
        }

    }

    public Rent[] getRents() {
        return _rents;
    }

    public int getNumOfRents() {
        return _noOfRents;
    }

    public Rent longestRent() {
        if (_noOfRents == 0) {
            return null;
        }
        Rent[] longArray = new Rent[MAX_RENTS];
        int index = 0;
        int longestSoFar = 0;
        for (int i = 0; i < _noOfRents; i++) {
            Rent rent = _rents[i];
            if (rent.howManyDays() > longestSoFar) {
                longestSoFar = rent.howManyDays();
                index = 0;
                longArray = new Rent[MAX_RENTS];
                longArray[index] = rent;
            } else if (rent.howManyDays() == longestSoFar) {
                index++;
                longArray[index] = rent;
            }
        }
        return longArray[0];
    }

    public String toString() {
        if (_noOfRents == 0) {
            return "The company has 0 rents.";
        }
        String str = "";
        str += "The company has " + _noOfRents + " rents:\n";
        for (int i = 0; i < _noOfRents; i++) {
            str += _rents[i].toString();
            if (i != _noOfRents - 1)
                str += "\n";
        }
        return str;
    }

    public static void main(String[] args) {
        Date d1 = new Date(1, 1, 2000);
        Date d2 = new Date(6, 1, 2000);
        Date d7 = new Date(22, 1, 2000);
        Date d9 = new Date(29, 1, 2000);
        Car carA = new Car(123456789, 'A', "Ford", false);
        Company c2 = new Company();
        c2.addRent("Rent 12 After After", carA, d1, d2);
        c2.addRent("Rent 12 After", carA, d1, d7);
        c2.addRent("Rent 12", carA, d1, d9);
        System.out.println("c2 = " + c2);

    }

}