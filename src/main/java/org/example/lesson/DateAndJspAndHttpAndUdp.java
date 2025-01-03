package org.example.lesson;

import java.time.LocalDate;
import java.util.Date;

public class DateAndJspAndHttpAndUdp {

    public static void main(String[] args) {
        final var now = LocalDate.now();

        System.out.println(now);
        System.out.println(LocalDate.now());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getMonth());
        System.out.println(now.getYear());

        final var localDate = LocalDate.of(-9999999, 12, 31);
        System.out.println(localDate);


        // GET - запрос страницы (юез информации)
        // POST - сохранить информации
        // PUT - изменить информации
        // DELETE - удаление
        //
        // Http 1.1 - 1.2

        // [USER] REQ -> [SERVER]
        // [USER] RESPONSE <- [SERVER]


        // Http 2.0
        // [USER] REQ (start)-> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ (end)-> [SERVER]
        // [USER] RESPONSE <- [SERVER]

        // [USER] REQ (START)-> [SERVER]
        // [USER] RESPONSE <- [SERVER]



        // UDP
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
        // [USER] REQ -> [SERVER]
    }
}
