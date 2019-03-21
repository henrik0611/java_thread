package matrix.model;

import java.util.Random;


public class Matrix {
    public int r;
    public int c;
    private MatrixType mat;
    private MatrixType tMat;

    public Matrix(int r, int c) {
        this.r = r;
        this.c = c;

        this.mat = createRandomMatrix();
        this.tMat = createTransposeMatrix();
    }

    public Matrix(MatrixType mat) {
        this.mat = mat;
        this.r = mat.size();
        if (mat.size() > 0)
            this.c = mat.get(0).size();
        else
            this.c = 0;
        this.tMat = createTransposeMatrix();
    }

    private MatrixType createRandomMatrix() {
        Random rand = new Random();
        MatrixType mat = new MatrixType();
        for (int i = 0; i < this.r; i++) {
            Vector row = new Vector();
            for (int j = 0; j < this.c; j++)
                row.add((long) rand.nextInt(1000));
            mat.add(row);
        }
        return mat;
    }

    private MatrixType createTransposeMatrix() {
        MatrixType tMat = new MatrixType();
        for (int j = 0; j < this.c; j++) {
            Vector col = new Vector();
            for (int i = 0; i < this.c; i++)
                col.add(this.mat.get(i).get(j));
            tMat.add(col);
        }
        return tMat;
    }

    public Vector getRow(int i) {
        return this.mat.get(i);
    }

    public Vector getCol(int j) {
        return this.tMat.get(j);
    }

    public void print() {
        for (Vector row: mat) {
            for (long x: row) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
