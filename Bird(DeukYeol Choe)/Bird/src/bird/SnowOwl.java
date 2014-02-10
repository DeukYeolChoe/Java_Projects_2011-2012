package bird;


public class SnowOwl extends Owl{
    public SnowOwl()
    {
        super("white");
    }

    public String getCall()
    {
        String call = " ";
        int randomNumber = randomInt(4)+1;

        for(int count = 1; count <= randomNumber; count++);
            call += "Hoo";

        return call + ";";
    }

}
