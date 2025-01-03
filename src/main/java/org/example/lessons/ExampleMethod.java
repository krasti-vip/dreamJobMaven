package org.example.lessons;


public class ExampleMethod {
    public static void main(String[] args) {
        System.out.println(isPalindrome("шалАш"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(null));
    }


    /**
     * Метод проверяет является ли слово палиндромом.
     *
     * @param str при передачи пустого или null значение вернется false. Значение с 1 символом по умолчанию true.
     * @return возвращает результат провреки.
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("Передано пустое значение!");
            return false;
        }

        if (str.length() == 1) {
            System.out.println("Слово из 1 символа является по умолчанию палиндромом!");
            return true;
        }

        final var res = new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);

        if (res) {
            System.out.println("Значение: " + str + " является палиндромом!");
        } else {
            System.out.println("Значение: " + str + " не является палиндромом!");
        }

        return res;
    }
}
