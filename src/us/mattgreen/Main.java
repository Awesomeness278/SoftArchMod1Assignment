package us.mattgreen;

import java.util.Scanner;

public class Main {

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        AnimalCreator creator = new AnimalCreator(in);

        // Lines to Replace Begin Here
        creator.createAnimal();
        creator.createAnimal();
        creator.createAnimal();
        // End Lines to Replace

        for (Talkable thing : creator.getAnimals()) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public static void printOut(Talkable p) {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + " | " + p.talk());
    }
}
