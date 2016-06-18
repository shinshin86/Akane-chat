package main.akane;

import java.util.ArrayDeque;
import java.util.Deque;

public class Akane {
    Deque<String> deque;
    private static Akane instance;
    
    public static synchronized Akane getInstance() {
        if (instance == null) {
            instance = new Akane();
            System.out.println("Hash : " + instance.hashCode());
            instance.deque = new ArrayDeque<String>();
        }
        return instance;
    }
    
    // Main Method
    public String toSay(String word) {
        // test
        if(word.equals("こんにちわ")){
            return toHello();
        }
        
        deque.add(word);
        try {
            return reply();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ERROR!!!!!!!";
    }
    
    public String reply() throws InterruptedException {
        return deque.poll();
    }
    
    // It's a test method
    public String toHello() {
        return "こんにちわ〜なんだか眠くなってきたよ〜";
    }
}