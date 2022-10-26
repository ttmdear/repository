package repo.java.concurrency;

public class App2 {
    public static void main(String[] args) {
        new App2().run();
    }

    public void run() {
        runSleep();
        runJoin();
        runYield();
    }

    private void runSleep() {
        Thread threadA = new ThreadSleep("threadA", 4000);
        Thread threadB = new ThreadSleep("threadB", 3000);

        threadA.start();
        threadB.start();
    }

    private void runJoin() {
        Thread threadA = new ThreadSleep("threadA", 10000);
        Thread threadJoin = new ThreadJoin("threadJoin", threadA);

        threadA.start();
        threadJoin.start();
    }

    private void runYield() {
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();
        runThreadCounter();

        // ThreadSleep threadSleep = new ThreadSleep("sleep", 10000);
        // threadSleep.setPriority(1);
        // threadSleep.start();

        ThreadPrimaryNumber threadPrimaryNumber = new ThreadPrimaryNumber(100000, false);

        threadPrimaryNumber.setPriority(1);
        threadPrimaryNumber.start();
    }

    private void runThreadCounter() {
        ThreadPrimaryNumber threadPrimaryNumber = new ThreadPrimaryNumber(1000000);

        threadPrimaryNumber.setPriority(10);
        threadPrimaryNumber.start();
    }

    private static class ThreadPrimaryNumber extends Thread {
        private final int max;
        private final boolean yield;

        private ThreadPrimaryNumber(int max) {
            this(max, true);
        }

        private ThreadPrimaryNumber(int max, boolean yield) {
            this.max = max;
            this.yield = yield;
        }

        @Override
        public void run() {
            System.out.println(String.format("%s(%s).run():start", this.getClass().getSimpleName(), Thread.currentThread().getId()));

            int primaryNumber = 1;

            for(int i = 0; i <= max; i++) {
                for(int j = 2; j <= i; j++) {
                    if (i % j == 0) {
                        if (i == j) {
                            primaryNumber = i;
                        } else {
                            break;
                        }
                    }
                }

                if (yield) Thread.yield();
            }

            System.out.println(primaryNumber);
            System.out.println(String.format("%s(%s).run():end", this.getClass().getSimpleName(), Thread.currentThread().getId()));
        }
    }

    private static class ThreadJoin extends Thread {
        private final String name;
        private final Thread waitFor;

        private ThreadJoin(String name, Thread waitFor) {
            this.name = name;
            this.waitFor = waitFor;
        }

        @Override
        public void run() {
            System.out.println(String.format("ThreadJoin %s with id %s - run", name, Thread.currentThread().getId()));

            try {
                waitFor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("ThreadJoin %s with id %s - run", name, Thread.currentThread().getId()));
        }
    }

    private static class ThreadSleep extends Thread {
        private final String name;
        private final int sleep;

        public ThreadSleep(String name, int sleep) {
            this.name = name;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            System.out.println(String.format("ThreadSleep %s with id %s - run", name, Thread.currentThread().getId()));

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("ThreadSleep %s with id %s - finish", name, Thread.currentThread().getId()));
        }
    }
}
