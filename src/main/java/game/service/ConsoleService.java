package game.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;


public class ConsoleService {
    private Scanner scn = new Scanner(System.in);

    public String readString(String text) {
        System.out.println(text);
        scn = new Scanner(System.in);
        return scn.nextLine();
    }


    public int readInt(String text) {
        System.out.println(text);
        return readInt();
    }
    public int readInt() {
        return scn.nextInt();
    }


    public double readDouble(String text) {
        System.out.println(text);
        return scn.nextDouble();
    }
}

