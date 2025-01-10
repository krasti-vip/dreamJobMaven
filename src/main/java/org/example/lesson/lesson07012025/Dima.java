package org.example.lesson.lesson07012025;

public class Dima implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            SafeList.add("Дима");
        }
    }
}
