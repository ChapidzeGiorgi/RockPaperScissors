package com.company.GameUI;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameConsole {
    int humanPoints = 0, pcPoints = 0;
    private GameObject[]gameObjects = new GameObject[3];
    private String[] objects = {"Rock","Paper","Scissors"};
    private Map<String,String> objectTable = Map.of(
            "Scissors","Paper",
            "Rock","Scissors",
            "Paper","Rock"
    );
    private StringBuilder stringBuilder = new StringBuilder();

    public void run() {
        int i = 0;
        int j = 0;
        System.out.println("---------Starting Rock-Paper-Scissors Game------------");
        while(i < 3) {
            System.out.print("Choose ");
            for (GameObject g : gameObjects) {
                System.out.print(j + "." + g.getName() + " ");
                j++;
            }
            j = 0;
            String s = objects[matchToObject()];
            if(objectTable.get(objects[randomChoice()]).equals(s)) {
                humanPoints += 1;
                System.out.println("HumanPlayer Wins Point!" );
            }
            else {
                pcPoints += 1;
                System.out.println("Pc Wins Point!");
            }
            i++;
        }
        gameResult(humanPoints,pcPoints);
    }
    public void gameResult(int humanPoints, int pcPoints) {
        if (humanPoints < pcPoints) {System.out.println("-----Result-----\n" + "----Pc Wins!----");}
        else if (humanPoints == pcPoints) {System.out.println("-----Result-----\n" + "==== 0 - 0 ====");}
        else {System.out.println("----- Result -----\n" + "=== Human Wins! ==");}
    }
    public GameConsole(GameObject[]gameObjects) {
        this.gameObjects = gameObjects;
    }
    private int randomChoice() {
        int i = new Random().nextInt() * 3 + 1;
        if(i <= 3 && i >= 1) {return i;}
        return 0;
    }
    private String objectReceiver(int num) {
        return objects[num];
    }
    private int matchToObject() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if(tryParse(input)) {
            int result = Integer.parseInt(input);
            if(result >= 3 || result < 0) {
                return outOfBounds(input);
            }
            return Integer.parseInt(input);
        }
        else {
            int res = wrongInput(input);
            return res;
        }
    }
    private boolean tryParse(String input) {
        try {
            Integer.parseInt(input);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }
    private int wrongInput(String input) {
        Scanner scanner = new Scanner(System.in);
        String s = null;
        do {
            System.out.print("Wrong Input!Try Again! ");
            s = scanner.next();
            if(tryParse(s)) {
                return Integer.parseInt(s);
            }
        }
        while (!tryParse(s));
        return 0;
    }
    private int outOfBounds(String input) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Index is out of bound!Type (0 or 1 or 2) ");
            i = scanner.nextInt();
            if(i < 3 && i > -1) {
                return i;
            }
        }
        while (i >= 3 || i < 0);
        return -1;
    }
}
