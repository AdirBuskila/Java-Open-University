public class Car {
    final static private int ID_MAX_DEFAULT = 9999999;
    final static private char TYPE_DEFAULT = 'A';
    final static private int MIN_ID = 1000000;

    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

    /*
     * public Car(int id,
     * char type,
     * java.lang.String brand,
     * boolean isManual)
     * Creates a new Car object
     * id should be a 7 digits number, otherwise set it to 9999999
     * type should be 'A','B','C' or 'D', otherwise set it to 'A'
     * Parameters:
     * id - the id of the car (7 digits number)
     * type - the type of the car ('A','B','C' or 'D')
     * brand - the car's brand
     * isManual - flag indicating if the car is manual
     */
    public Car(int id, char type, String brand, boolean isManual) {
        // checking if the id is within range
        _id = (id > ID_MAX_DEFAULT || id < MIN_ID) ? ID_MAX_DEFAULT : id;
        // checking if the type is a valid type
        _type = (type == 'A' || type == 'B' || type == 'C' || type == 'D') ? type : TYPE_DEFAULT;
        _brand = brand;
        _isManual = isManual;

    }

    /*
     * public Car(Car other)
     * 
     * Copy constructor
     * Parameters:
     * other - the car to be copied
     * 
     */
    public Car(Car other) {
        _id = other.getId();
        _type = other.getType();
        _brand = other.getBrand();
        _isManual = other.isManual();
    }

    /*
     * public int getId()
     * Gets the id
     * Returns:
     * the id
     */
    public int getId() {
        return _id;
    }

    /*
     * public char getType()
     * Gets the type
     * Returns:
     * the type
     */
    public char getType() {
        return _type;
    }

    /*
     * public java.lang.String getBrand()
     * Gets the brand
     * Returns:
     * the brand
     */
    public String getBrand() {
        return _brand;
    }

    /*
     * public boolean isManual()
     * Gets the isManual flag
     * Returns:
     * the isManual flag
     */
    public boolean isManual() {
        return _isManual;
    }

    /*
     * public void setId(int id)
     * Sets the id (only if the given id is valid)
     * Parameters:
     * id - the id value to be set
     */
    public void setId(int id) {
        // checking if the id is within range
        if (id <= ID_MAX_DEFAULT && id >= MIN_ID) {
            _id = id;
        }
    }

    /*
     * public void setType(char type)
     * Sets the type (only if the given type is valid)
     * Parameters:
     * type - the type value to be set
     */
    public void setType(char type) {
        // checking if the type is a valid type
        if (type == 'A' || type == 'B' || type == 'C' || type == 'D') {
            _type = type;
        }
    }

    /*
     * public void setBrand(java.lang.String brand)
     * Sets the brand of the car
     * Parameters:
     * brand - the brand value to be set
     */
    public void setBrand(String brand) {
        if (brand != "") {
            _brand = brand;
        }
    }

    /*
     * public void setIsManual(boolean isManual)
     * Sets the isManual flag of the car
     * Parameters:
     * isManual - the isManual flag to be set
     * 
     */
    public void setIsManual(boolean isManual) {
        _isManual = isManual;
    }

    /*
     * public boolean better(Car other)
     * 
     * Check if this car is better than the other car
     * A car is considered better than another car if its type is higher.
     * If both cars have the same type, an automated car is better than a manual
     * car.
     * Parameters:
     * other - car to compare this car to
     * Returns:
     * true if this car is better than the other car, otherwise false
     */
    public boolean better(Car other) {
        return (_type > other.getType() || _type == other.getType() && !_isManual && other.isManual());
    }

    /*
     * 
     * public boolean worse(Car other)
     * 
     * Check if this car is worse than the other car
     * Parameters:
     * other - car to compare this car to
     * Returns:
     * true if this car is worse than the other car, otherwise false
     */
    public boolean worse(Car other) {
        return other.better(this);
    }

    /*
     * public java.lang.String toString()
     * Returns a String object that represents this car
     * Overrides:
     * toString in class java.lang.Object
     * Returns:
     * String that represents this car in the following format:
     * id:1234567 type:B brand:Toyota gear:manual (or auto)
     * 
     */
    public String toString() {
        return "id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + (_isManual ? "manual" : "auto");
    }

    /*
     * public boolean equals(Car other)
     * Check if two cars are the same
     * Cars are considered the same if they have the same type, brand and gear
     * Parameters:
     * other - the car to compare this car to
     * Returns:
     * true if the cars are the same, otherwise false
     */
    public boolean equals(Car other) {
        return (_type == other.getType() && _brand == other.getBrand() && _isManual == other.isManual());
    }

}
