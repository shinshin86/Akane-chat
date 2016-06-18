package test;

import java.util.Scanner;
import main.akane.Akane;

public class TestRun {
    public static final String exitCommand = "exit";
    public static void main(String[] args){
        System.out.println("TEST START!!!");
        Akane akaneInstance = Akane.getInstance();
        Scanner sc = new Scanner(System.in);
        String sendWord;
        do{
            sendWord = sc.nextLine();
            System.out.println(akaneInstance.toSay(sendWord));
        }while(!(sendWord.equals(exitCommand)));
        System.out.println("Akane is sleeping.....zzz");
    }
}
