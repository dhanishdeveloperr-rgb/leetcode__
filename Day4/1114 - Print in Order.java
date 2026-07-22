import java.util.concurrent.CountDownLatch;

class Foo {

    private final CountDownLatch firstCompleted = new CountDownLatch(1);
    private final CountDownLatch secondCompleted = new CountDownLatch(1);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();

        
        firstCompleted.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        firstCompleted.await();

        printSecond.run();

        secondCompleted.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() finishes
        secondCompleted.await();

        printThird.run();
    }
}