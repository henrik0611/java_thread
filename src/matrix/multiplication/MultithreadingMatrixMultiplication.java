package matrix.multiplication;

import matrix.model.Matrix;
import matrix.model.MatrixType;
import matrix.model.Task;
import matrix.model.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultithreadingMatrixMultiplication extends BaseMatrixMultiplication {
    private static int N_THREAD = 4;
    public MultithreadingMatrixMultiplication(Matrix A, Matrix B) throws Exception {
        super(A, B);
    }

    public Matrix multiply() {
        // Initialize result
        MatrixType result = new MatrixType();
        for (int i = 0; i < M; i++) {
            Vector row = new Vector();
            for (int j = 0; j < N; j++) {
                row.add((long) 0);
            }
            result.add(row);
        }

        // Add tasks
        BlockingQueue<Task> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                queue.add(new Task(matA, matB, i, j, result));
            }
        }

        // Add workers
        List<MultiplicationWorker> workers = new ArrayList<>();
        for (int i = 0; i < N_THREAD; i++) {
            MultiplicationWorker worker = new MultiplicationWorker(queue);
            workers.add(worker);
            worker.start();
        }

        // Finish
        for (MultiplicationWorker worker: workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Matrix(result);
    }
}
