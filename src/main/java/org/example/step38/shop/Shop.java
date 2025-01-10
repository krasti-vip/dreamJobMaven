package org.example.step38.shop;

public class Shop {

    public static void main(String[] args) throws Exception {

        Storage storage = new Storage();

        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    synchronized (storage) {
                        for (int i = 0; i < storage.arrayLength(); i++) {
                            boolean result = storage.put("Унитаз");
                            if (result == true) {
                                System.out.println("Товар поступил на склад");
                            } else {
                                System.out.println("Склад полон");
                            }
                        }
                        try {
                            storage.wait(5_000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    synchronized (storage) {
                        boolean result = storage.get();
                        if (result == true) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад пуст");
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    synchronized (storage) {
                        boolean result = storage.get();
                        if (result == true) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад пуст");
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            Thread thread3 = new Thread(new Runnable() {
                public void run() {
                    synchronized (storage) {
                        boolean result = storage.get();
                        if (result == true) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад пуст");
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            Thread thread4 = new Thread(new Runnable() {
                public void run() {
                    synchronized (storage) {
                        boolean result = storage.get();
                        if (result == true) {
                            System.out.println("Товар забрали со склада");
                        } else {
                            System.out.println("Склад пуст");
                            try {
                                storage.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
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
}
