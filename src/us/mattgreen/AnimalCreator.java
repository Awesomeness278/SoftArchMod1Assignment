package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalCreator {
    private final ArrayList<Talkable> animals = new ArrayList<>();
    Scanner in;
    public AnimalCreator(Scanner in){
        this.in = in;
    }

    public void createAnimal(){
        System.out.println("What type of animal do you want?(dog or cat or teacher)");
        String type = in.nextLine();
        while(!type.equals("Cat") && !type.equals("Dog") && !type.equals("cat") && !type.equals("dog") && !type.equals("Teacher") && !type.equals("teacher")){
            System.out.println("Invalid input. Try again.");
            type = in.nextLine();
        }
        System.out.println("What is the "+type+"'s name?");
        String name = in.nextLine();
        switch (type) {
            case "Cat", "cat" -> {
                System.out.println("How many mice has the cat killed?");
                String num = in.nextLine();
                int n;
                try{
                    n = Integer.parseInt(num);
                }catch(NumberFormatException e){
                    while(true){
                        System.out.println("Please input a number.");
                        num = in.nextLine();
                        try{
                            n = Integer.parseInt(num);
                            break;
                        }catch (NumberFormatException ignored){}
                    }
                }
                animals.add(new Cat(n, name));
            }
            case "Dog", "dog" -> {
                System.out.println("Is the dog friendly(y or n)?");
                String answer = in.nextLine();
                while(!answer.equals("y") && !answer.equals("n") && !answer.equals("Y") && !answer.equals("N")){
                    System.out.println("Invalid input. Try again.");
                    answer = in.nextLine();
                }
                animals.add(new Dog(answer.equalsIgnoreCase("y"), name));
            }
            case "Teacher", "teacher" -> {
                System.out.println("How old is the teacher?");
                String num = in.nextLine();
                int n;
                try{
                    n = Integer.parseInt(num);
                }catch(NumberFormatException e){
                    while(true){
                        System.out.println("Please input a number.");
                        num = in.nextLine();
                        try{
                            n = Integer.parseInt(num);
                            break;
                        }catch (NumberFormatException ignored){}
                    }
                }
                animals.add(new Teacher(n, name));
            }
        }
    }

    public ArrayList<Talkable> getAnimals() {
        return animals;
    }
}
