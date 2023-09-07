package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;
    public static void main(String[] args) throws InterruptedException{
        List<Horse> hh = new ArrayList<>();
        Horse horse1 = new Horse("Go", 3, 0);
        Horse horse2 = new Horse("Mobile", 3, 0);
        Horse horse3 = new Horse("Java", 3, 0);
        hh.add(horse1);
        hh.add(horse2);
        hh.add(horse3);
        Hippodrome hippodrome = new Hippodrome(hh);
        game = hippodrome;
        game.run();
        game.printWinner();

    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
     void run() throws InterruptedException
    {
        for(int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }

    }
     void move(){
        for(Horse s : horses)
        {
            s.move();
        }
     }
     void print(){
        for(Horse q : horses)
        {
            q.print();

        }
        for(int i = 0; i < 10; i++)
        {
            System.out.println();
        }
     }
    public Horse getWinner(){
        double maxk = 0;
        Horse horse = null;
        for(Horse s : horses)
        {
            if(s.getDistance() > maxk)
            {
                maxk = s.getDistance();
                horse = s;
            }
        }
        return horse;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
