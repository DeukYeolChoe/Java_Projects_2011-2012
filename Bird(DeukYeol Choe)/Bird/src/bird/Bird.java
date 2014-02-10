package bird;

import java.util.Random;

public abstract class Bird {
    private String myColor, myFood, myMovement;
    private static Random myRandom = new Random();

    abstract String getCall();

    public Bird(String color, String food, String movement)
    {
        myColor = color;
        myFood = food;
        myMovement = movement;
    }

    public String getColor()
    {
        return myColor;
    }

    public String getFood()
    {
        return myFood;
    }

     public String getMovement()
    {
        return myMovement;
    }

     public String toString()
    {
        return " A " + getColor()
                + " " + getClass().getName()
                + " " + getMovement()
                + " by hunting " + getFood()
                + ", \n calling " + getCall()    // call
                + "\n";
    }

     protected static int randomInt(int upperBound)
    {
         return myRandom.nextInt(upperBound);
    }
}
