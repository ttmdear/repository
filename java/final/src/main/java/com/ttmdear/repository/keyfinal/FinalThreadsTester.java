package com.ttmdear.repository.keyfinal;

import com.ttmdear.repository.keyfinal.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FinalThreadsTester {
    User user = new User();

    public void run() {
        for(int i=0; i<1; i++) {
            check();
        }
    }

    private void check() {
        Counter counter = new Counter();

        Thread threadCounter = new ThreadCounter(counter);
        Thread threadWatcher = new ThreadWatcher(counter);

        List<Thread> threads = new ArrayList<>();
        threads.add(threadCounter);
        threads.add(threadWatcher);

        threads.get(0).start();
        threads.get(1).start();

        // ExecutorService executorService = Executors.newFixedThreadPool(1);
        // List<Future<?>> tasks = new ArrayList<>();

        // tasks.add(executorService.submit(threadA));
        // tasks.add(executorService.submit(threadB));
        // tasks.add(executorService.submit(threadC));

        while(isRunningThreads(threads));

        // System.out.println(counter.getValue());
    }

    private boolean isRunningThreads(List<Thread> threads) {
        for(Thread thread: threads) {
            if (thread.isAlive()) {
                return true;
            }
        }

        return false;
    }

    private boolean isRunning(List<Future<?>> tasks) {
        for(Future<?> task: tasks) {
            if (!task.isDone()) {
                return true;
            }
        }

        return false;
    }

    private static class ThreadWatcher extends Thread {
        private Counter counter;

        public ThreadWatcher(Counter counter) {
            super();

            this.counter = counter;
        }

        @Override
        public void run() {
            super.run();

            while(true) {
                int counter = this.counter.getValue();

                System.out.println(counter);

                if (counter == 10) {
                    return;
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadCounter extends java.lang.Thread {
        private Counter counter;

        public ThreadCounter(Counter counter) {
            super();

            this.counter = counter;
        }

        @Override
        public void run() {
            super.run();

            for(int i=0; i<10; i++) {
                counter.increase();
            }
        }
    }

    private static class ThreadLock extends java.lang.Thread {
        private Lock lock;

        public ThreadLock(Lock lock) {
            super();

            this.lock = lock;
        }

        @Override
        public void run() {
            while (lock.isLocked()) {
                System.out.println("Czekam: " + Thread.currentThread().getId());
            };

            lock.setLocked(true);

            System.out.println("Run: " + Thread.currentThread().getId());

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Stop: " + Thread.currentThread().getId());

            lock.setLocked(false);
        }
    }

    private static class Lock {
        // private volatile boolean locked = false;
        private boolean locked = false;

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }
    }

    private static class Counter {
        private int value = 0;
        private int vvalue = 0;

        public void increase() {
            vvalue++;

            value = vvalue + 1;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getValue() {
            return value;
        }
    }
}
