package matrix.model;

public class Task {
    public Matrix A;
    public Matrix B;
    public int i;
    public int j;
    public MatrixType result;

    public Task(Matrix A, Matrix B, int i, int j, MatrixType result) {
        this.A = A;
        this.B = B;
        this.i = i;
        this.j = j;
        this.result = result;
    }
}
