package bird;

import java.util.ArrayList;
import java.util.Random;


public class Aviary{

   public static void main(String[] args)
    {
       String[] parrotPhrases = {"Polly wanna craker! ",
                                 "Pieces of eight: Pieces of eight! ",
                                 "You're a pretty boy!",
                                 "I wonder if this thing can talk?"};

       Bird[] birdArray = { new Ostrich(), new Goose(), new Parrot("green"),
                            new TalkingParrot("red", parrotPhrases), new ScreenOwl(),
                            new SnowOwl() };

       System.out.print(birdArray[0].toString());
       System.out.print(birdArray[1].toString());
       System.out.print(birdArray[2].toString());
       System.out.print(birdArray[3].toString());
       System.out.print(birdArray[4].toString());
       System.out.print(birdArray[5].toString());
       
    }
}
