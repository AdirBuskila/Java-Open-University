public class Car {
    final static private int ID_MAX_DEFAULT = 9999999;
    final static private char TYPE_DEFAULT = 'A';
    final static private int MIN_ID = 1000000;

    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

    public Car(int id, char type, String brand, boolean isManual) {
        // checking if the id is within range
        _id = (id > ID_MAX_DEFAULT || id < MIN_ID) ? ID_MAX_DEFAULT : id;
        // checking if the type is a valid type
        if (type == 'A' || type == 'B' || type == 'C' || type == 'D') {
            _type = type;
        } else {
            _type = TYPE_DEFAULT;
        }
        _brand = brand;
        _isManual = isManual;
    }

    public Car(Car other) {
        _id = other.getId();
        _type = other.getType();
        _brand = other.getBrand();
        _isManual = other.isManual();
    }

    public int getId() {
        return _id;
    }

    public char getType() {
        return _type;
    }

    public String getBrand() {
        return _brand;
    }

    public boolean isManual() {
        return _isManual;
    }

    public void setId(int id) {
        // checking if the id is within range
        if (id <= ID_MAX_DEFAULT && id >= MIN_ID) {
            _id = id;
        }
    }

    public void setType(char type) {
        // checking if the type is a valid type
        if (type == 'A' || type == 'B' || type == 'C' || type == 'D') {
            _type = type;
        }
    }

    public void setBrand(String brand) {
        if (brand != "") {
            _brand = brand;
        }
    }

    public void setIsManual(boolean isManual) {
        _isManual = isManual;
    }

    public boolean isBetter(Car other) {
        return (_type > other.getType() || _type == other.getType() && !_isManual && other.isManual());
    }

    public boolean worse(Car other) {
        return (!isBetter(other) && !equals(other));
    }

    public String toString() {
        return "id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + (_isManual ? "manual" : "auto");
    }

    public boolean equals(Car other) {
        return (_type == other.getType() && _brand == other.getBrand() && _isManual == other.isManual());
    }

}
