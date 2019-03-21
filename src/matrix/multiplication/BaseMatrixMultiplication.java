package matrix.multiplication;

import matrix.model.Matrix;
import matrix.model.Vector;

public abstract class BaseMatrixMultiplication {
    protected Matrix matA;
    protected Matrix matB;
    protected int M;
    protected int N;

    protected BaseMatrixMultiplication(Matrix matA, Matrix matB) throws Exception {
        this.matA = matA;
        this.matB = matB;
        this.M = matA.r;
        this.N = matB.c;
        if (matA.c != matB.r)
            throw new Exception("Invalid matrix size");
    }

    public static long dotProduct(Vector a, Vector b) {
        long result = 0;
        for(int i = 0; i < a.size(); i++)
            result += a.get(i) * b.get(i);
        return result;
    }

    public abstract Matrix multiply();
}
