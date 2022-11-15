
public class Date {
    final private int MAX_ONE_DIGIT_NUMBER = 9;

    private int _day;
    private int _month;
    private int _year;

    public Date(int d, int m, int y) {
        _day = d;
        _month = m;
        _year = y;
    }

    public int getDay() {
        return _day;
    }

    public int getMonth() {
        return _month;
    }

    public int getYear() {
        return _year;
    }

    public void setDay(int dayToSet) {
        _day = dayToSet;
    }

    public void setMonth(int monthToSet) {
        _month = monthToSet;
    }

    public void setYear(int yearToSet) {
        _year = yearToSet;
    }

    public boolean equals(Date other) {
        return (_day == other.getDay() && _month == other.getMonth() && _year == other.getYear());
    }

    public boolean before(Date other) {
        // if the _year is less than other's year return true
        // if the _year is equal to other's year and _month is less than other's month
        // return true
        // if the _year is equal to other's year and _month is equal to other's month
        // and day is less than other's day return true
        // else return false
        return(_year < other.getYear() || _year == other.getYear() && _month < other.getMonth()
                || _year == other.getYear() && _month == other.getMonth() && _day < other.getDay());
    } 

    public String toString() {
        String dayString = (_day > MAX_ONE_DIGIT_NUMBER) ? _day + "" : "0" + _day; // checking if number is above 9
        String monthString = (_month > MAX_ONE_DIGIT_NUMBER) ? _month + "" : "0" + _month;
        return dayString + "/" + monthString + "/" + _year;
    }
}