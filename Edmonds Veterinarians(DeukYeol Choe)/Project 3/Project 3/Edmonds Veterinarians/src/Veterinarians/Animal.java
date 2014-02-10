package Veterinarians;

public abstract class Animal {

    private boolean teeth, fleas, rabies;

    abstract boolean needTeeth();
    abstract boolean needFleas();
    abstract boolean needRabies();

    public Animal(){}

}
