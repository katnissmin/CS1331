public class GarageOwner {
    private String name;
    private int age;
    private int carsOwned;

    public GarageOwner(String name, int age) {
        this.name = name;
        this.age = age;
        this.carsOwned = 0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(int carsOwned) {
        if (carsOwned >= 0) {
            this.carsOwned = carsOwned;
        }
    }

}


