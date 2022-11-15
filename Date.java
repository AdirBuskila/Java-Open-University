
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
        if (_year < other.getYear() || _year == other.getYear() && _month < other.getMonth()
                || _year == other.getYear() && _month == other.getMonth() && _day < other.getDay()) {
            return true;
        }
        return false;
    }

    public String toString() {
        String dayString = (_day > MAX_ONE_DIGIT_NUMBER) ? _day + "" : "0" + _day;
        String monthString = (_month > MAX_ONE_DIGIT_NUMBER) ? _month + "" : "0" + _month;
        return dayString + "/" + monthString + "/" + _year;
    }
}