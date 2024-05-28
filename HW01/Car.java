public class Car {
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;

    public Car(int year, String make, String model, String color, int conditionCategory) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        setConditionCategory(conditionCategory);
        setRestored();
    }

    public Car(int year, String make, String model) {
        this(year, make, model, "blue", 80);
    }

    public Car() {
        this(1960, "Jaguar", "E-Type", "silver", 89);
    }

    private void setConditionCategory(int conditionCategory) {
        if (conditionCategory >= 40 && conditionCategory <= 100) {
            this.conditionCategory = conditionCategory;
        } else {
            this.conditionCategory = 80;
        }
        printConditionCategory();
    }

    private void printConditionCategory() {
        if (conditionCategory >= 90 && conditionCategory <= 100) {
            System.out.println("Perfect");
        } else if (conditionCategory >= 80 && conditionCategory <= 89) {
            System.out.println("Excellent");
        } else if (conditionCategory >= 70 && conditionCategory <= 79) {
            System.out.println("Fine");
        } else if (conditionCategory >= 60 && conditionCategory <= 69) {
            System.out.println("Very Good");
        } else if (conditionCategory >= 50 && conditionCategory <= 59) {
            System.out.println("Good");
        } else if (conditionCategory >= 40 && conditionCategory <= 49) {
            System.out.println("Driver");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void setRestored() {
        isRestored = conditionCategory >= 90;
    }

    public int getConditionCategory() {
        return conditionCategory;
    }

    public boolean isRestored() {
        return isRestored;
    }

}
