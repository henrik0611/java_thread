package matrix.multiplication;

import matrix.model.Task;
import matrix.model.Vector;

import java.util.concurrent.BlockingQueue;

public class MultiplicationWorker extends Thread {
    private BlockingQueue<Task> queue;
    public MultiplicationWorker(BlockingQueue<Task> queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Task task = queue.poll();
            if (task == null) {
                break;
            }

            Vector row_i = task.A.getRow(task.i);
            Vector col_j = task.B.getCol(task.j);
            long dotProduct = BaseMatrixMultiplication.dotProduct(row_i, col_j);
            task.result.get(task.i).set(task.j, dotProduct);
        }
    }
}
