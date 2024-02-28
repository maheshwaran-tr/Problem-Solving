package models;

public class Room {

    public String hallNo;
    public int seatPerBench;
    public int rows;
    public int cols;
    public int totalNoOfSeats;
    public Seat[][] hallMatrix;

    public Room(String hallNo,int rows, int cols,int seatPerBench) {
        this.seatPerBench = seatPerBench;
        this.hallNo = hallNo;
        this.rows = rows;
        this.cols = cols * seatPerBench;
        totalNoOfSeats = rows * cols * seatPerBench;
        hallMatrix = generateStructure();
    }

    public Seat[][] generateStructure() {
        char colName = 'A';
        Seat[][] matrix = new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Seat seat = new Seat();
                seat.seatName = (char) (colName + j) + "" + (i + 1);
                matrix[i][j] = seat; // Store the seat in the matrix
            }
        }
        return matrix;
    }

    public void printMatrix(Seat[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j].student + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }
    }

}