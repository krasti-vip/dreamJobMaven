package org.example.servet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/bd")
public class HumanServlet extends HttpServlet {

    private final List<Human> humans = new ArrayList<>();

//    Human human1 = new Human("Dima");
//    Human human2 = new Human("Люк");

    @Override
    public void init() throws ServletException {
        humans.add(new Human("Dima"));
        humans.add(new Human("Люк"));
//        Human luk = humanDao.findByName("Люк").get();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-16");
        String name = req.getParameter("name");
        String del = req.getParameter("del");
        String update = req.getParameter("update");
        String newName = req.getParameter("newname");
        String add = req.getParameter("add");

        if (name != null) {
            Human foundHuman = findByName(name);
            if (add != null && add.equals("true") && foundHuman != null) {
                    resp.getWriter().write("Человек с именем: " + name + " существует");
                } else if (add != null && add.equals("true")) {
                    save(new Human(name));
                    resp.getWriter().write("Человек с именем " + name + " создан");

            } else if (del != null && del.equals("true") && foundHuman != null) {
                    delete(foundHuman);
                    resp.getWriter().write("Человек с именем: " + name + " удален");
                } else if(del != null && del.equals("true")) {
                    resp.getWriter().write("Удаление не удалось: человека с именем " + name + " не найдено");

            } else if (update != null && update.equals("true")) {
                if (foundHuman != null && newName != null) {
                    updateName(foundHuman, newName);
                    resp.getWriter().write("Человек: " + name + " изменен на " + newName);
                } else {
                    resp.getWriter().write("Изменение не удалось: человек с именем " + name + " не найден или новое имя не указано");
                }
            } else if (foundHuman != null) {
                resp.getWriter().write("Найден: " + foundHuman);
            } else {
                resp.getWriter().write("Человека с именем: " + name + " в базе данных не найдено");
            }
        } else {
            resp.getWriter().write("Все люди в базе данных: " + humans);
        }
    }
    private void save(Human human) {
        humans.add(human);
    }

    private void delete(Human human) {
        humans.remove(human);
    }

    private void updateName(Human human, String newName) {
        human.setName(newName);
    }

    private Human findByName(String name) {
        for (Human human : humans) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }
}
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-16");
//        String name = req.getParameter("name");
//
//        if(name != null && !name.trim().isEmpty()) {
//            Human human = new Human(name);
//            humanDao.save(human);
//            resp.getWriter().write("Создан человек: " + name);
//        } else {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Вы не указали имя");
//        }
//    }
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
//        resp.setCharacterEncoding("UTF-16");
//        String oldName = req.getParameter("oldName");
//        String newName = req.getParameter("newName");
//
//        if(newName == null || oldName == null) {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Не указано старое или новое имя");
//            return;
//        }
//
//        Optional<Human> oldHuman = humanDao.findByName(oldName);
//        if(oldHuman.isPresent()) {
//            Human newHuman = new Human(newName);
//            if (humanDao.update(newHuman)) {
//                resp.getWriter().write("Обновлено: " + oldHuman.get() + " на " + newHuman);
//            } else {
//                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Не удалось обновить человека");
//            }
//        } else {
//            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Не найден человек с именем: " + oldName);
//        }
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-16");
//        String name = req.getParameter("name");
//
//        if (name != null) {
//            if (humanDao.delete(name)) {
//                resp.getWriter().write("Удален человек с именем: " + name);
//            } else {
//                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Не найден человек с именем: " + name);
//            }
//        } else {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Не указано имя");
//        }
//    }


