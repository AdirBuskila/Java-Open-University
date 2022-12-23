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
        } else {
            for (int i = 0; i < _noOfRents; i++) {
                Date curReturnDate = _rents[i].getReturnDate();
                if (date.equals(curReturnDate)) {
                    return i;
                }
            }
            return -1;
        }
        return index;
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
        }

        char previous = _rents[0].getCar().getType();
        char popular = _rents[0].getCar().getType();
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < _noOfRents; i++) {
            if (_rents[i].getCar().getType() == previous)
                count++;
            else {
                if (count > maxCount) {
                    popular = _rents[i - 1].getCar().getType();
                    maxCount = count;
                }
                previous = _rents[i].getCar().getType();
                count = 1;
            }
        }

        return count > maxCount ? _rents[_noOfRents - 1].getCar().getType() : popular;

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

}
