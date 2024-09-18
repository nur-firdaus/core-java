import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a LinkedBlockingQueue with no limit (or specify a max size)
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();

        // Create a ThreadPoolExecutor with 10 fixed threads and an unbounded queue
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,                        // Core pool size
                10,                        // Maximum pool size (fixed)
                60L,                       // Keep alive time for idle threads
                TimeUnit.SECONDS,          // Time unit for keep alive
                taskQueue                  // Unbounded task queue
        );

        // Submit tasks to the pool
        for (int i = 0; i < 50; i++) { // Example with 50 tasks
            final int taskId = i;
            executor.execute(() -> performTask(taskId));
        }

        executor.shutdown(); // Shutdown after tasks are complete
    }

    // Method that performs the task
    private static void performTask(int taskId) {
        // Replace this with the actual task logic
        System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);  // Simulating task workload
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
