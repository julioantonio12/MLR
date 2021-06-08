package examples.mlr;
import java.util.ArrayList;

public class MatrixProcedure implements MLRProcedure {
    Operations operations;

    MatrixProcedure() {
        this.operations = new Operations();
    }

    @Override
    public DataRegister calculate(ArrayList<DataRegister> data) {
        Matrices matrices = transformIndependentToMatrix(data);

        double[][] y = getYMatrix(data);
        double[][] firstPart = operations.invert(operations.multiply(matrices.xTransposed, matrices.x));
        double[][] secondPart = operations.multiply(matrices.xTransposed, y);
        double[][] thirdPart = operations.multiply(firstPart, secondPart);
        DataRegister dt = new DataRegister(thirdPart[0][0], thirdPart[1][0], thirdPart[2][0]);
        return dt;
    }

    private Matrices transformIndependentToMatrix(ArrayList<DataRegister> data) {
        double[][] transposed = new double[3][data.size()];
        double[][] matrix = new double[data.size()][3];
        for (int j = 0; j < data.size(); j++) {
            matrix[j][0] = 1;
            matrix[j][1] = data.get(j).getX1();
            matrix[j][2] = data.get(j).getX2();

            transposed[0][j] = 1;
            transposed[1][j] = data.get(j).getX1();
            transposed[2][j] = data.get(j).getX2();
        }
        Matrices result = new Matrices();
        result.x = matrix;
        result.xTransposed = transposed;
        return result;
    }

    private double[][] getYMatrix(ArrayList<DataRegister> data) {
        double[][] result = new double[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i).getY();
        }
        return result;
    }
}

class Matrices {
    double x[][];
    double xTransposed[][];
}