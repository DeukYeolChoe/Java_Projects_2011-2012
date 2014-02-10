package bird;


public class TalkingParrot extends Parrot{

    private String[] myPhrases;

    public TalkingParrot(String color,String[] phases)
    {
        super(color);
        myPhrases = phases;
    }

    public String getCall()
    {
        int randomIndex = randomInt(myPhrases.length);
        return myPhrases[randomIndex];
    }
}
