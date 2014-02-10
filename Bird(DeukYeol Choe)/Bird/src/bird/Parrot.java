package bird;

public class Parrot extends FlyingBird
{
    public Parrot(String color)
    {
        super(color,"fruit");
    }

    public String getCall()
    {
        return "Sqeek";
    }
}
