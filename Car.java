public class Car {

    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

    public Car(int id, char type, String brand, boolean isManual) {
        _id = id;
        _type = type;
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
        _id = id;
    }

    public void setType(char type) {
        _type = type;
    }

    public void setBrand(String brand) {
        _brand = brand;
    }

    public void setIsManual(boolean isManual) {
        _isManual = isManual;
    }

    public boolean better(Car other) {
        if (_type > other.getType() || _type == other.getType() && other.getIsManual()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "id: " + _id + " ,type: " + _type + " ,brand: " + _brand + " ,isManual: " + _isManual;
    }

    public static void main(String[] args) {
        Car c1 = new Car(0, 'A', "Ford", true);
        Car c2 = new Car(0, 'A', "Tesla", false);
        System.out.println(c1.better(c2));
        System.out.println(c2.better(c1));
    }
}
