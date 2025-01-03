package org.example.baseJava.steep16.switchTask;

public class SwitchTask {

    public String getDay(int numberDay) {
        return switch (numberDay) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
    }

    public String getSeason(String month) {
        return switch (month.toLowerCase()) {
            case "december", "january", "february" -> "Winter";
            case "march", "april", "may" -> "Spring";
            case "june", "july", "august" -> "Summer";
            case "september", "october", "november" -> "Autumn";
            default -> "Invalid month";
        };
    }

    public double result(double a, double b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b != 0 ? a / b : Double.NaN;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public String getEstimation(int numberEstimation) {
        return switch (numberEstimation) {
            case 1 -> "Poor";
            case 2 -> "Fair";
            case 3 -> "Good";
            case 4 -> "Very Good";
            case 5 -> "Excellent";
            default -> "Invalid Estimation";
        };
    }

    public String getАigure(int numberSides) {
        return switch (numberSides) {
            case 3 -> "Треуголник";
            case 4 -> "Квадрат";
            case 5 -> "Пятиугольник";
            case 6 -> "Шестиуголник";
            default -> "Invalid sides";
        };
    }


}
