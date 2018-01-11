import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;
import java.util.concurrent.CountDownLatch;

public class ThreadedCounting {
    private static ConcurrentLinkedQueue<Integer> myQueue;
    private static CyclicBarrier myCyclicBarrier;
    private static CountDownLatch myCountDownLatch;

    public static void main(String[] args) {
        myQueue = new ConcurrentLinkedQueue<>();
        myCyclicBarrier = new CyclicBarrier(3);
        myCountDownLatch = new CountDownLatch(3);
        IntStream.rangeClosed(1, 10).forEach(myQueue::add);
        IntStream.rangeClosed(0, 2).mapToObj(i -> new Thread(new MyCounter(i))).forEach(Thread::start);

        try {
            myCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyCounter implements Runnable {
        private final int modValue;

        public MyCounter(int modValue) {
            this.modValue = modValue;
        }

        public void run() {
            while(!myQueue.isEmpty()) {
                int modResult = myQueue.peek() % 3;
                if (modResult == modValue) {
                    System.out.println(myQueue.poll() + " " + Thread.currentThread());
                }
                try {
                    myCyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

            myCountDownLatch.countDown();
        }
    }
}
