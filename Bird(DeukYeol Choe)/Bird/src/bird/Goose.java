package bird;

public class Goose extends WalkingBird{

    public Goose()
    {
        super("gray", "bugs");
    }

    public String getCall()
    {
        return "Honk!";
    }
}
