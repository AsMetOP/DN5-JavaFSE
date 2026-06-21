public class PerformanceTester {
    public void performTask() {
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i);
        }
    }

    public void slowTask() throws InterruptedException {
        Thread.sleep(3000);
    }
}