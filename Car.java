public class Car {
    final static private int ID_MAX_DEFAULT = 9999999;
    final static private char TYPE_DEFAULT = 'A';
    final static private int MIN_ID = 1000000;

    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

    public Car(int id, char type, String brand, boolean isManual) {
        _id = (id > ID_MAX_DEFAULT || id < MIN_ID) ? ID_MAX_DEFAULT : id;
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
        _isManual = other.getIsManual();
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

    public boolean getIsManual() {
        return _isManual;
    }

    public void setId(int id) {
        if (id <= ID_MAX_DEFAULT && id >= MIN_ID) {
            _id = id;
        }
    }

    public void setType(char type) {
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
        return (_type > other.getType() || _type == other.getType() && other.getIsManual());
    }

    public boolean worse(Car other) {
        return (!isBetter(other));
    }

    public String toString() {
        return "id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + (_isManual ? "manual" : "auto");
    }

    public boolean equals(Car other) {
        return (_type == other.getType() && _brand == other.getBrand() && _isManual == other.getIsManual());
    }
}
