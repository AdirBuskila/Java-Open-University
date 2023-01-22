/*
 * by: Adir Buskila
 */

public class Company {
    final private static int MAX_RENTS = 1000;

    private Rent[] _rents;
    private int _noOfRents;

    /*
     * public Company()
     * Creates a new Company object
     * Initializing the _rents to a new Rent array with length of max rents (1000)
     * Initializing the number of rents to 0
     */
    public Company() {
        _rents = new Rent[MAX_RENTS];
        _noOfRents = 0;
    }

    /*
     * 
     * public boolean addRent(java.lang.String name,
     * Car car,
     * Date pick,
     * Date ret
     * )
     * adding a new rent bases on these rules:
     * if its the first rent to be added, add to the first place (_rents[0]) return
     * true
     * if its the number of rents is at its maximum, don't add and return false
     * find the index where the new Rent needs to be added
     * copy all the elements of the old array to a new array and add the new rent in
     * the given index
     * after that copy all the elements with +1 in the index
     * return true
     * Parameters:
     * name - the client name
     * car - the rented car
     * pick - the pickup date
     * ret - the return date
     */

    public boolean addRent(String name, Car car, Date pick, Date ret) {
        if (_noOfRents == 0) {
            _rents[0] = new Rent(name, car, pick, ret);
            _noOfRents++;
            return true;
        } else if (_noOfRents == MAX_RENTS) {
            return false;
        }
        int index = getInsertIndex(pick);
        Rent[] newRents = new Rent[MAX_RENTS];
        int j = 0;
        _noOfRents++;
        for (int i = 0; i < _noOfRents + 1; i++) {
            if (i == index) {
                newRents[i] = new Rent(name, car, pick, ret);
            } else {
                newRents[i] = _rents[j];
                j++;
            }
        }
        _rents = newRents;
        return true;
    }

    /*
     * public boolean removeRent(Date ret)
     * removing a rent from the array:
     * getting the index of the Rent that is to be removed
     * copying all the elements of the array to a new array
     * except for the element with the delete index
     * Parameters:
     * ret - return date of the rent
     */
    public boolean removeRent(Date ret) {
        if (_noOfRents == 0) {
            return false;
        }
        int index = getDeleteIndex(ret);
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

    /*
     * 
     * public int getInsertIndex(Date pick)
     * getting the index of the new rent that needs to be added
     * setting the index to the last element of the array
     * if the new pick Date is before the current pick Date
     * set the index for that index
     * Parameters:
     * pick - pick Date of the new rent
     */
    private int getInsertIndex(Date pick) {
        int index = _noOfRents;
        for (int i = 0; i < _noOfRents; i++) {
            Date curPickupDate = _rents[i].getPickDate();
            if (pick.before(curPickupDate)) {
                return i;
            }
        }
        return index;
    }

    /*
     * public boolean getDeleteIndex(Date ret)
     * getting the index of the rent that needs to be removed
     * going through the array and if the return Date is equals to current return
     * Date
     * return the index
     * if went through all the array and no match return -1 (there is no rent with
     * that return date)
     * Parameters:
     * ret - return date of the removed Rent
     */
    private int getDeleteIndex(Date ret) {
        for (int i = 0; i < _noOfRents; i++) {
            Date curReturnDate = _rents[i].getReturnDate();
            if (ret.equals(curReturnDate)) {
                return i;
            }
        }
        return -1;

    }

    /*
     * public Car lastCarRent()
     * getting the car of the rent that has the latest return date
     * if there are no rents return null
     * if there is one rent, return it's car
     * going through the array and if the current rent's return date is after the
     * previous one
     * then its the current latest rent
     */
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

    /*
     * public int getSumOfPrices()
     * summing all the prices of the rents
     */
    public int getSumOfPrices() {
        int sum = 0;
        for (int i = 0; i < _noOfRents; i++) {
            sum += _rents[i].getPrice();
        }
        return sum;
    }

    /*
     * public int getSumOfDays()
     * summing all the days of the rents
     */
    public int getSumOfDays() {
        int days = 0;
        for (int i = 0; i < _noOfRents; i++) {
            days += _rents[i].howManyDays();
        }
        return days;
    }

    /*
     * public double averageRent()
     * returning the average days a rent has in the array by:
     * dividing the sum of days with the num of rents
     */
    public double averageRent() {
        if (_noOfRents == 0) {
            return 0;
        }
        return ((double) getSumOfDays() / (double) _noOfRents);
    }

    /*
     * public char mostCommonRate()
     * returning which car rate is the most common in the rent array
     * setting a new array as the frequencies of each rate
     * going through the array and adding to the frequencies array
     * checking which char appears the most
     */
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

    /*
     * public Rent longestRent()
     * returning the rent that has the most days in it
     * if there are two rents with the same amount days, return the first from them
     * going through the array and checking if the current rent has more days than
     * longest so far
     */
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

    /*
     * public String toString()
     * returning a string with all the rents using the Rent's toString
     */
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