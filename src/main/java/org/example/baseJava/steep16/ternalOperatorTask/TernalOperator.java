package org.example.baseJava.steep16.ternalOperatorTask;

public class TernalOperator {

    public String parity(int number) {
        return (number % 2 == 0 ? "Even" : "Odd");
    }

    public int max(int a, int b) {
        return (a > b ? a : b);
    }

    public String comingAge(int age) {
        return (age >= 18 ? "Access Granted" : "Access Denied");
    }

    public String estimation(int number) {
        return (number == 1) ? "Poor" :
               (number == 2) ? "Fair" :
               (number == 3) ? "Good" :
               (number == 4) ? "Very Good" :
               (number == 5) ? "Excellent" : "Invalid grade";
    }

    public double sale(double price, boolean discount) {
        return (discount == true) ? price / 100 * 110 : price;
    }


}
