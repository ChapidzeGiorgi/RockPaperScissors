package com.company;

import com.company.GameObjects.Paper;
import com.company.GameObjects.Rock;
import com.company.GameObjects.Scissors;
import com.company.GameUI.GameConsole;
import com.company.GameUI.GameObject;

public class Main {

    public static void main(String[] args) {
        GameObject[] gameObject = { new Rock(), new Paper(), new Scissors() };
        new GameConsole(gameObject).run();
    }
}
