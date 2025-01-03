package org.example.ArrayListAndLinkedList;

    /**
     * Коллекция типа LinkedList хранит числа и есть ноды, а так же имеет различные методы add(), headIsEmpty(),
     * get(int index), getSize(), remove(int index), update(int index, int elem),
     */
    public class CustomLinkedList implements CustomList {

        private Node head = null;

        private int size = 0;

        /**
         * Метод добавляет элемент. Проверяет создан ли хедер. Если нет добавляет элемент в конец списка.
         *
         * @param "elem" - элемент, который будет добавлен в коллекцию
         */
        @Override
        public void add(int elem) {
            if (headIsEmpty()) {
                head = new Node(elem);
                size++;
            } else {
                Node node = new Node(elem);
                Node dummy = head;

                while (dummy.next != null) {
                    dummy = dummy.next;
                }

                dummy.next = node;
                size++;
            }
        }

        private boolean headIsEmpty() {

            return head == null;
        }

        /**
         * Метод передает значение найденого в листе по индексу; сначало проверяем что индекс в пределах
         * размера листа, затем создаем переменную для хранения значения, так как начинаем с головы присваиваем ей
         * значения 1-го элемента, проходим по листу, как только находим нужный индекс, возвращаем значение индекса
         * @param index
         * @return
         */

        @Override
        public int get(int index) { // 1
            if (index > size || index < 0) {
                throw new IllegalArgumentException("Такого индекса нет");
            }

            Node node = head; // index 1

            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node.val;
        }

        /**
         * Метод передает размер листа. создаем переменную для хранения размера списка,
         * инициализируем переменную для перебора списка, начиная с головы; Перебераем лист пока текущий узел не равен
         * null (то есть пока не достигнем конца списка) --> Возвращаем размер списка
         * @return
         */

        @Override
        public int getSize() {
            int size = 0;
            Node current = head;

            while (current != null) {
                size++;
                current = current.next;
            }

            return size;
        }

        /**
         * Метод удаляет ссылку на слудующий узел (то есть удаляем ячейку по индексу) --> Если список пуст
         * или индекс меньше 0, ни чего не делаем; Если нужно удалить первый элемент (индекс 0), перемещаем указатель
         * head на следующий узел; Поиск узла, который стоит перед удаляемым узлом, если следующий узел null, з
         * начит индекс выходит за пределы списка и мы ни чего не делаем; Проверяем, что после current есть узел
         * для удаления, пропускаем удаляемый узел.
         * @param index
         */

        @Override
        public void remove(int index) {
            if (head == null || index < 0) {

                return;
            }
            if (index == 0) {
                head = head.next;

                return;
            }
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current.next == null) {

                    return;
                }
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }

        /**
         * Метод который после нахождения элемента по индексу присваивает ему значение --> Если список пуст
         * или индекс меньше 0, ни чего не делаем; Инициализация переменной для поиска нужного узла; Проход по списку
         * до узла на позиции index, если следующий узел null, значит индекс выходит за пределы списка, ни чего не делаем;
         * После нахождения узла обновляем его значение
         * @param index
         * @param elem
         */

        @Override
        public void update(int index, int elem) {
            if(head == null || index < 0) {

                return;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                if(current.next == null) {

                    return;
                }
                current = current.next;
            }
            current.val = elem;
        }

        private static class Node {

            // Поле для хранения значения узла
            private int val;

            // Ссылка на следующий узел в списке
            private Node next;

            //  Конструктор узла, принимающий значение
            public Node(int val) {
                // Инициализация значения узла
                this.val = val;
                // Изначально следующий узел отсутствует, поэтому null
                this.next = null;
            }
        }
    }
