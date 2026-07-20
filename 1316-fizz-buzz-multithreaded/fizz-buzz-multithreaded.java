class FizzBuzz {
    private int n;
    private int current = 1;
    private final Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz"
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (lock) {
            while (current <= n) {
                if (current % 3 == 0 && current % 5 != 0) {
                    printFizz.run();
                    current++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz"
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock) {
            while (current <= n) {
                if (current % 5 == 0 && current % 3 != 0) {
                    printBuzz.run();
                    current++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz"
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (current <= n) {
                if (current % 15 == 0) {
                    printFizzBuzz.run();
                    current++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (current <= n) {
                if (current % 3 != 0 && current % 5 != 0) {
                    printNumber.accept(current);
                    current++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }
}