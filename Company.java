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
        int index = getInsertDeleteIndex(pickupDate, true);
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
        int index = getInsertDeleteIndex(d, false);
        if (index == -1)
            return false;
        Rent[] newRents = new Rent[MAX_RENTS];
        for (int i = 0, k = 0; i < _noOfRents; i++) {
            if (i == index) {
                continue;
            }
            newRents[k++] = _rents[i];
        }
        _rents = newRents;
        _noOfRents--;
        return true;
    }

    private int getInsertDeleteIndex(Date date, boolean isPickup) {
        int index = _noOfRents;
        if (isPickup) {
            for (int i = 0; i < _noOfRents; i++) {
                Date curPickupDate = _rents[i].getPickDate();
                if (date.before(curPickupDate)) {
                    return i;
                }
            }
            return index;
        } else {
            for (int i = 0; i < _noOfRents; i++) {
                Date curReturnDate = _rents[i].getReturnDate();
                if (date.equals(curReturnDate)) {
                    return i;
                }
            }
            return -1;
        }
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
        System.out.println("maxIndex = " + maxIndex);
        System.out.println("maxIndexTwo = " + maxIndexTwo);
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
        Date d3 = new Date(8, 1, 2000);
        Date d4 = new Date(10, 1, 2000);
        Date d5 = new Date(16, 1, 2000);
        Date d6 = new Date(20, 1, 2000);
        Date d7 = new Date(22, 1, 2000);
        Date d8 = new Date(25, 1, 2000);
        Date d9 = new Date(29, 1, 2000);
        Date d10 = new Date(3, 2, 2000);
        Date d11 = new Date(10, 2, 2000);
        Date d12 = new Date(20, 2, 2000);
        Car carA = new Car(123456789, 'A', "Ford", false);
        Car carB = new Car(123456789, 'B', "Ford", false);
        Car carC = new Car(123456789, 'C', "Ford", false);
        Car carD = new Car(123456789, 'D', "Ford", false);
        Rent r1 = new Rent("Rent 1", carA, d1, d2);
        Rent r2 = new Rent("Rent 2", carB, d2, d3);
        Rent r3 = new Rent("Rent 3", carC, d3, d4);
        Rent r4 = new Rent("Rent 4", carC, d4, d5);
        Rent r5 = new Rent("Rent 5", carC, d5, d6);
        Rent r6 = new Rent("Rent 6", carC, d6, d7);
        Rent r7 = new Rent("Rent 7", carC, d7, d8);
        Rent r8 = new Rent("Rent 8", carC, d8, d9);
        Rent r10 = new Rent("Rent 10", carC, d10, d11);
        Rent r11 = new Rent("Rent 11", carD, d11, d12);
        String toStringTest = "The company has 11 rents:\n" +
                "Name:Rent 1 From:01/01/2000 To:06/01/2000 Type:A Days:5 Price:500\n" +
                "Name:Rent 2 From:06/01/2000 To:08/01/2000 Type:B Days:2 Price:300\n" +
                "Name:Rent 3 From:08/01/2000 To:10/01/2000 Type:C Days:2 Price:360\n" +
                "Name:Rent 4 From:10/01/2000 To:16/01/2000 Type:C Days:6 Price:1080\n" +
                "Name:Rent 5 From:16/01/2000 To:20/01/2000 Type:C Days:4 Price:720\n" +
                "Name:Rent 6 From:20/01/2000 To:22/01/2000 Type:C Days:2 Price:360\n" +
                "Name:Rent 7 From:22/01/2000 To:25/01/2000 Type:C Days:3 Price:540\n" +
                "Name:Rent 8 From:25/01/2000 To:29/01/2000 Type:C Days:4 Price:720\n" +
                "Name:Rent 9 From:29/01/2000 To:03/02/2000 Type:C Days:5 Price:900\n" +
                "Name:Rent 10 From:03/02/2000 To:10/02/2000 Type:C Days:7 Price:1134\n" +
                "Name:Rent 11 From:10/02/2000 To:20/02/2000 Type:D Days:10 Price:2232";
        System.out.println("---Testing Constructor---");
        Company c = new Company();
        Company c1 = new Company();
        System.out.println(c.mostCommonRate());
    }

}
