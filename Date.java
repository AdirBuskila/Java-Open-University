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

    public Date(int day, int month, int year) {
        boolean isLeapYear = false;
        if (day < DAY_MIN || day > DAY_MAX || month < MONTH_MIN || month > MONTH_MAX || year < YEAR_MIN
                || year > YEAR_MAX) {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
            return;
        }
        boolean dividableByFour = (year % 4 == 0) ? true : false;
        boolean dividableByOneHundred = (year % 100 == 0) ? true : false;
        boolean dividableByFourHundred = (year % 400 == 0) ? true : false;
        if (dividableByFour && !dividableByOneHundred) {
            isLeapYear = true;
        }
        if (dividableByFour && dividableByOneHundred && dividableByFourHundred) {
            isLeapYear = true;
        }
        switch (month) {
            case 2:
                if ((isLeapYear && day > FEB_REGULAR_MAX_DAYS) || (!isLeapYear && day > FEB_LEAP_MAX_DAYS)) {
                    _day = DEFAULT_DAY;
                    _month = DEFAULT_MONTH;
                    _year = DEFAULT_YEAR;
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
                if (day > REGULAR_MONTH_MAX_DAYS) {
                    _day = DEFAULT_DAY;
                    _month = DEFAULT_MONTH;
                    _year = DEFAULT_YEAR;
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
        Date checkedDate = new Date(day, this.getMonth(), this.getYear());
        if (day == checkedDate.getDay() && this.getMonth() == checkedDate.getMonth()
                && this.getYear() == checkedDate.getYear()) {
            _day = day;
        }
    }

    public int getMonth() {
        return _month;
    }

    public void setMonth(int month) {
        Date checkedDate = new Date(this.getDay(), month, this.getYear());
        if (this.getDay() == checkedDate.getDay() && month == checkedDate.getMonth()
                && this.getYear() == checkedDate.getYear()) {
            _month = month;
        }
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        Date checkedDate = new Date(this.getYear(), this.getMonth(), year);
        if (this.getDay() == checkedDate.getDay() && this.getMonth() == checkedDate.getMonth()
                && this.getYear() == year) {
            _year = year;
        }
    }

    public boolean equals(Date other) {
        if (_day == other.getDay() && _month == other.getMonth() && _year == other.getYear()) {
            return true;
        }
        return false;
    }

    // the conditions checked in the two else if can be in the first but its more
    // readable like this
    public boolean before(Date other) {
        if (_year < other.getYear()) {
            return true;
        } else if (_year == other.getYear() && _month < other.getMonth()) {
            return true;
        } else if (_year == other.getYear() && _month == other.getMonth() && _day < other.getDay()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean after(Date other) {
        return (!before(other));
    }

    public String toString() {
        String dayString = (_day > ONE_DIGIT_NUMBER) ? _day + "" : "0" + _day;
        String monthString = (_month > ONE_DIGIT_NUMBER) ? _month + "" : "0" + _month;
        return dayString + "/" + monthString + "/" + _year;
    }

    public int difference(Date other) {
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
        Date tomorrow = new Date(this);
        boolean isLeapYear = false;
        boolean dividableByFour = (_year % 4 == 0) ? true : false;
        boolean dividableByOneHundred = (_year % 100 == 0) ? true : false;
        boolean dividableByFourHundred = (_year % 400 == 0) ? true : false;

        if (dividableByFour && !dividableByOneHundred) {
            isLeapYear = true;
        }
        if (dividableByFour && dividableByOneHundred && dividableByFourHundred) {
            isLeapYear = true;
        }
        switch (_month) {
            case 2:
                if (isLeapYear && _day == FEB_REGULAR_MAX_DAYS) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(tomorrow.getMonth() + 1);
                } else if (!isLeapYear && _day == FEB_LEAP_MAX_DAYS) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(tomorrow.getMonth() + 1);
                } else {
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (_day == DAY_MAX) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(tomorrow.getMonth() + 1);
                } else {
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (_day == REGULAR_MONTH_MAX_DAYS) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(tomorrow.getMonth() + 1);
                } else {
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
                break;
            case 12:
                if (_day == DAY_MAX) {
                    tomorrow.setDay(DAY_MIN);
                    tomorrow.setMonth(MONTH_MIN);
                    tomorrow.setYear(tomorrow.getYear() + 1);
                } else {
                    tomorrow.setDay(tomorrow.getDay() + 1);
                }
            default:
                break;
        }
        return tomorrow;
    }
}
