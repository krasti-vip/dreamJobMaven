package org.example.step38.shop;

public class Shop {

    public static void main(String[] args) throws Exception {

        Storage storage = new Storage();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (storage) {
                        for (int i = 0; i < storage.arraySize(); i++) {
                            if (storage.getArray().get(i) == null) {

                                while (storage.getRemainingProducts() < storage.arraySize()) {
                                    storage.put("Унитаз");
                                }
                                storage.notifyAll();
                            }
                        }
                        try {
                            System.out.println("Склад полон, на нем 500 унитазов");
                            storage.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (storage) {
                        boolean result = storage.getProduct();
                        if (result == true && storage.getRemainingProducts() >= storage.arraySize() / 2) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад на половину пуст");
                            storage.getProduct();
                            storage.notifyAll();
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (storage) {
                        boolean result = storage.getProduct();
                        if (result == true && storage.getRemainingProducts() >= storage.arraySize() / 2) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад на половину пуст");
                            storage.getProduct();
                            storage.notifyAll();
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (storage) {
                        boolean result = storage.getProduct();
                        if (result == true && storage.getRemainingProducts() >= storage.arraySize() / 2) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад на половину пуст");
                            storage.getProduct();
                            storage.notifyAll();
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (storage) {
                        boolean result = storage.getProduct();
                        if (result == true && storage.getRemainingProducts() >= storage.arraySize() / 2) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад на половину пуст");
                            storage.getProduct();
                            storage.notifyAll();
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
