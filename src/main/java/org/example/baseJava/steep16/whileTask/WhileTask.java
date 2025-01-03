package org.example.baseJava.steep16.whileTask;


import java.util.Random;
import java.util.Scanner;

public class WhileTask {

    public int sumNumber(int n) {
        int sum = 0;
        int a = 1;
        while (a <= n) {
            sum = sum + a;
            a++;
        }
        return sum;
    }

    public boolean primeNumber(int n) {
        if(n < 2) return false;
        int a = 2;
        while (a <= Math.sqrt(n)) {
            if(n % a == 0) {
                return false;
            }
            a++;
        }
        return true;
    }
    // не знал как тестировать метод, запустил консоль в классе TestTest и проверил работу
    public void guessNumber() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int guessedNumber;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Угадай число...");
            guessedNumber = scanner.nextInt();
            if (guessedNumber < numberToGuess) {
                System.out.println("Загаданное число больше");
            } else if (guessedNumber > numberToGuess) {
                System.out.println("Загаданное число меньше");
            }
        } while (guessedNumber != numberToGuess);
        System.out.println("Вы угадали");
    }

    // я списал, не знал как сделать
    public int[] fibonacci(int n) {
        int[] fib = new int[n];
        if (n > 0) fib[0] = 0;
        if (n > 1) fib[1] = 1;

        int i = 2;
        while (i < n) {
            fib[i] = fib[i-1] + fib[i-2];
            i++;
        }
        return fib;
    }

    public String reverseNumber(int number) {
        StringBuilder reversed = new StringBuilder();
        int n = Math.abs(number);
        do {
            reversed.append(n % 10);
            n /= 10;
        } while (n > 0);

        return (number < 0 ? "-" : "") + reversed.toString();
    }

}
