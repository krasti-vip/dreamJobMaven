package org.example.step34.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Использовать ArrayDeque как стек "Назад". Добавлять адреса страниц (строки). Реализовать переход "Назад" и проверку текущей страницы.
 * Пример: Переходы: google.com -> stackoverflow.com -> github.com; затем "назад" -> текущая "stackoverflow.com".
 */
public class BrouserNavigator {

    private final Deque<String> backStack = new ArrayDeque<>();
    private String currentPage = null;


    public void visit(String page) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = page;
    }


    public void back() {
        if (!backStack.isEmpty()) {
            currentPage = backStack.pop();
        }
    }

    public String getCurrentPage() {
        return currentPage;
    }
}
