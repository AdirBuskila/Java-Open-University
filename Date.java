public class Date {
    private final static int DEFAULT_DAY = 1;
    private final static int DEFAULT_MONTH = 1;
    private final static int DEFAULT_YEAR = 2000;

    private final static int DAY_MIN = 1;
    private final static int DAY_MAX = 31;
    private final static int MONTH_MIN = 1;
    private final static int MONTH_MAX = 12;
    private final static int YEAR_MIN = 1000;
    private final static int YEAR_MAX = 9999;
    private final static int ONE_DIGIT_NUMBER = 9;

    private final static int FEB_REGULAR_MAX_DAYS = 28;
    private final static int FEB_LEAP_MAX_DAYS = 29;
    private final static int REGULAR_MONTH_MAX_DAYS = 30;

    private int _day;
    private int _month;
    private int _year;

    // Date constructor
    public Date(int day, int month, int year) {
        // checking if the values are not within the max range
        if (day < DAY_MIN || day > DAY_MAX || month < MONTH_MIN || month > MONTH_MAX || year < YEAR_MIN
                || year > YEAR_MAX) {
            setDefault();
            return;
        }
        boolean isLeapYear = isLeapYear(year);
        switch (month) {
            case 2:
                // is leap year and the day is greater than the max
                // is not leap year and day is greater than feb max
                if ((isLeapYear && day > FEB_LEAP_MAX_DAYS) || (!isLeapYear && day > FEB_REGULAR_MAX_DAYS)) {
                    setDefault();
                } else {
                    _day = day;
                    _month = month;
                    _year = year;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                // day is greater than regular month max
                if (day > REGULAR_MONTH_MAX_DAYS) {
                    setDefault();
                } else {
                    _day = day;
                    _month = month;
                    _year = year;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                // no need for checking at this point
                // because already checked if within range at the start
                _day = day;
                _month = month;
                _year = year;
            default:
                break;
        }

    }

    public Date(Date other) {
        this(other.getDay(), other.getMonth(), other.getYear());
    }

    public int getDay() {
        return _day;
    }

    public void setDay(int day) {
        // creating a new date with the new given value
        Date checkedDate = new Date(day, this.getMonth(), this.getYear());
        // if the checkedDate values are equal to the unchanged values,
        // and the checkedDate.day is equal to the given day,
        // it's a valid date
        if (day == checkedDate.getDay() && this.getMonth() == checkedDate.getMonth()
                && this.getYear() == checkedDate.getYear()) {
            _day = day;
        }
    }

    public int getMonth() {
        return _month;
    }

    public void setMonth(int month) {
        // creating a new date with the new given value
        Date checkedDate = new Date(this.getDay(), month, this.getYear());
        // if the checkedDate values are equal to the unchanged values,
        // and the checkedDate.month is equal to the given month,
        // it's a valid date
        if (this.getDay() == checkedDate.getDay() && month == checkedDate.getMonth()
                && this.getYear() == checkedDate.getYear()) {
            _month = month;
        }
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        // creating a new date with the new given value
        Date checkedDate = new Date(this.getDay(), this.getMonth(), year);
        // if the checkedDate values are equal to the unchanged values,
        // and the checkedDate.year is equal to the given year,
        // it's a valid date
        if (this.getDay() == checkedDate.getDay() && this.getMonth() == checkedDate.getMonth()
                && checkedDate.getYear() == year) {
            _year = year;
        }
    }

    private void setDefault() {
        _day = DEFAULT_DAY;
        _month = DEFAULT_MONTH;
        _year = DEFAULT_YEAR;
    }

    public boolean equals(Date other) {
        return (_day == other.getDay() && _month == other.getMonth() && _year == other.getYear());
    }

    // the conditions checked in the two else if can be in the first but its more
    // readable like this
    public boolean before(Date other) {
        return (_year < other.getYear() || _year == other.getYear() && _month < other.getMonth()
                || _year == other.getYear() && _month == other.getMonth() && _day < other.getDay());
    }

    public boolean after(Date other) {
        // returning before with other in the parameter
        return other.before(this);
    }

    public String toString() {
        String dayString = (_day > ONE_DIGIT_NUMBER) ? _day + "" : "0" + _day;
        String monthString = (_month > ONE_DIGIT_NUMBER) ? _month + "" : "0" + _month;
        return dayString + "/" + monthString + "/" + _year;
    }

    public int difference(Date other) {
        // returning the absolute value between the two dates
        return Math.abs(calculateDate(_day, _month, _year)
                - other.calculateDate(other.getDay(), other.getMonth(), other.getYear()));
    }

    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }

    public Date tomorrow() {
        // creating a new date with the values of the current date
        Date tomorrow = new Date(this);
        // calculating leap year
        boolean isLeapYear = isLeapYear(tomorrow.getYear());
        switch (_month) {
            case 2:
                // leap year and max days: set day to min, set month to +1
                // not leap year and max days: set day to min, set month to next month
                if ((isLeapYear && _day == FEB_LEAP_MAX_DAYS) || (!isLeapYear && _day == FEB_REGULAR_MAX_DAYS)) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(tomorrow.getMonth() + 1);
                } else {
                    // next day
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                // day is max: set day to min, month to next month
                if (_day == DAY_MAX) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(tomorrow.getMonth() + 1);
                } else {
                    // next day
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                // day is max: set day to min, month to next month
                if (_day == REGULAR_MONTH_MAX_DAYS) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(tomorrow.getMonth() + 1);
                } else {
                    // next day
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
                break;
            case 12:
                // day is max: set day to min, set month to min, set year to next year
                if (_day == DAY_MAX) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(MONTH_MIN);
                    tomorrow.setYear(tomorrow.getYear() + 1);
                } else {
                    // next day
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
            default:
                break;
        }
        return tomorrow;
    }

    private boolean isLeapYear(int year) {
        // instantiating first to false
        boolean isLeapYear = false;
        // checking if dividable by four with no remainder
        boolean dividableByFour = (year % 4 == 0) ? true : false;
        // checking if dividable by one hundred with no remainder
        boolean dividableByOneHundred = (year % 100 == 0) ? true : false;
        // checking if dividable by four hundred with no remainder
        boolean dividableByFourHundred = (year % 400 == 0) ? true : false;
        // case 1 leap year = dividableByFour and not dividableByOneHundred
        // case 2 leap year = dividableByFour and dividableByOneHundred and
        // dividableByFourHundred
        if ((dividableByFour && !dividableByOneHundred)
                || (dividableByFour && dividableByOneHundred && dividableByFourHundred)) {
            isLeapYear = true;
        }
        // if no change to isLeapYear false is returned
        return isLeapYear;
    }
}
