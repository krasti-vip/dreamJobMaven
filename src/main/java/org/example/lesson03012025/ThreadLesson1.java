package org.example.lesson03012025;

import java.util.Scanner;

public class ThreadLesson1 {

    static Thread t1 = new Thread(new ThreadOne());

    static Thread t2 = new Thread(new ThreadTwo());

    static Thread t3 = new Thread(() -> {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию Бакса Банни: ");
        String n = sc.nextLine();
        if (n != null && n.equals("Банни")) {
            System.out.println("Ты очень умен");
        } else {
            System.out.println("Ты туп как 100 тупиц!!!");
        }
    }
    );

    public static void main(String[] args) {

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Всё ступени взорвались в атмосфере, как тебе такое Илон Маск");
    }
}
