package matrix.mainApp;

import matrix.model.Matrix;
import matrix.multiplication.NaiveMatrixMultiplication;
import matrix.multiplication.BaseMatrixMultiplication;
import matrix.multiplication.MultithreadingMatrixMultiplication;

public class Main {
    public static void main(String[] args) {
        int M = 500; int N = 500; int P = 500;
        Matrix A = new Matrix(M, N);
        Matrix B = new Matrix(N, P);

        long startTime;
        try {
            startTime = System.currentTimeMillis();
            new NaiveMatrixMultiplication(A, B).multiply();
            System.out.println(String.format("Run naive solution in %d ms", System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            new MultithreadingMatrixMultiplication(A, B).multiply();
            System.out.println(String.format("Run multithreading solution in %d ms", System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
