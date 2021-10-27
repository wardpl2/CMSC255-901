package Labs.Lab9;

public class Lab9 {

    public static void main(String[] args) {
        /*
        [0,0][0,1][0,2][0,3][0,4]
        [1,0][1,1][1,2][1,3][1,4]
        [2,0][2,1][2,2][2,3][2,4]
         */
        int [][] addTo10Input = {
                {  6,  3,  2,  0,  4},
                { 34, 53,  0, 23,  1},
                {  0, 23, 54, 11,  7}
        };
        /*
        [0,0][0,1][0,2]
        [1,0][1,1][1,2]
        [2,0][2,1][2,2]
         */
        double [][] findAvgInput = {
                {  5, 4.5,  6.8},
                {  6,  0,  3.4},
                { 7,  8.4,  2.3}
        };
        /*
        [0,0][0,1][0,2][0,3][0,4][0,5]
        [1,0][1,1][1,2][1,3][1,4][1,5]
        [2,0][2,1][2,2][2,3][2,4][2,5]
        [3,0][3,1][3,2][3,3][3,4][3,5]
        [4,0][4,1][4,2][4,3][4,4][4,5]
        [5,0][5,1][5,2][5,3][5,4][5,5]
         */
        double [][] findAvgInputLarge = {
                { 6.7,  23.8,  0,  5.9,  12.8,  45.7},
                {  0,  36.8,  13.5,  6.7,  54.9,  67.4},
                {  37.4,  2.5,  39.8,  0,  2.4,  43.6},
                {  44.6,  76.5,  4.5, 2.4,  0, 54.6},
                {  5.4,  76.3,  6.5, 28.5,  54.7,  0},
                {  19.4,  0,  5.3,  65.4,  93.5,  3.5}
        };

        addTo10 (addTo10Input);
        System.out.println();
        findAverage (findAvgInput);
        System.out.println();
        findAverage (findAvgInputLarge);
        System.out.println();
        }

    public static void addTo10 (int [][] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (double d : array[i]) {
                sum += d;
            }

            int replacement = (10 - sum);

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = replacement;
                }
            }

            for (double d : array[i]) {
                System.out.printf("%.0f ", d);
            }
            System.out.println();
        }
    }

    public static void findAverage (double [][] array) {

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                while (array[row][col] == 0) {
                    double rowSum = 0;
                    double colSum = 0;

                    for (double d : array[row]) {
                        rowSum += d;
                    }

                    for (double[] doubles : array) {
                        colSum += doubles[col];
                    }

                    array[row][col] = Math.max(rowSum / array[row].length,colSum / array.length);
                }
            }
        }

        //print structure
        for (double[] doubles : array) {
            for (double aDouble : doubles) {
                System.out.printf("%.2f ", aDouble);
            }
            System.out.println();
        }
    }

}