import java.util.Random;
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        // Заповнення матриці випадковими числами
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }

        // Виведення матриці на екран
        System.out.println("Матриця 4x4:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }

        // Обчислення сум і добутків
        int sumEvenRows = 0, sumOddRows = 0, productEvenCols = 1, productOddCols = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                    if (j % 2 == 0) {
                        productEvenCols *= matrix[i][j];
                    } else {
                        productOddCols *= matrix[i][j];
                    }
                } else {
                    sumOddRows += matrix[i][j];
                }
            }
        }

        // Виведення результатів
        System.out.println("Сума елементів парних рядків: " + sumEvenRows);
        System.out.println("Сума елементів непарних рядків: " + sumOddRows);
        System.out.println("Добуток елементів парних стовпців: " + productEvenCols);
        System.out.println("Добуток елементів непарних стовпців: " + productOddCols);

        // Перевірка на магічний квадрат
        boolean isMagicSquare = true;
        int magicSum = sumEvenRows + sumOddRows; // Сума всіх елементів в рядку
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum
                    != magicSum || colSum != magicSum) {
                isMagicSquare = false;
                break;
            }
        }
        // Перевірка діагоналей
        System.out.println("Чи є матриця магічним квадратом? " + isMagicSquare);
    }
}


