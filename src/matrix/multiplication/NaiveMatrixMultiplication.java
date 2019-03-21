package matrix.multiplication;

import matrix.model.Matrix;
import matrix.model.MatrixType;
import matrix.model.Vector;

public class NaiveMatrixMultiplication extends BaseMatrixMultiplication {
    public NaiveMatrixMultiplication(Matrix matA, Matrix matB) throws Exception{
        super(matA, matB);
    }

    public Matrix multiply() {
        MatrixType result = new MatrixType();
        for (int i = 0; i < M; i++) {
            Vector row = new Vector();
            for (int j = 0; j < N; j++)
                row.add(dotProduct(matA.getRow(i), matB.getCol(j)));
            result.add(row);
        }
        return new Matrix(result);
    }
}
