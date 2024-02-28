import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Room;
import models.Student;

public class App {
    public static void main(String[] args) throws Exception {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter Rows : ");
            int rows = input.nextInt();

            System.out.print("Enter Cols : ");
            int cols = input.nextInt();

            List<Student> students = new ArrayList<>();
            students.add(new Student("921721115001", "CSD"));
            students.add(new Student("921721115002", "CSD"));
            students.add(new Student("921721115003", "CSD"));
            students.add(new Student("921721115004", "CSD"));
            students.add(new Student("921721115005", "CSD"));
            students.add(new Student("921721115006", "CSD"));
            students.add(new Student("921721115007", "CSD"));
            students.add(new Student("921721115008", "CSD"));
            students.add(new Student("921721115009", "CSD"));
            students.add(new Student("921721115010", "CSD"));

            List<Room> examHalls = new ArrayList<>();
            examHalls.add(new Room("H1", rows, cols, 3));
            examHalls.add(new Room("H2", rows, cols, 3));
            arrangeSeats(students, examHalls);
            // List<Room> arrangedRooms = arrangeSeats(students, examHalls);
            // System.out.println(arrangedRooms.size());
            for (Room hall : examHalls) {
                System.out.println("****************************");
                System.out.println(" HALL NUMBER : " + hall.hallNo);
                System.out.println();
                for (int i = 0; i < hall.hallMatrix.length; i++) {
                    for (int j = 0; j < hall.hallMatrix[i].length; j++) {
                        if(hall.hallMatrix[i][j].student != null){
                            System.out.print(hall.hallMatrix[i][j].student.regNo + " - ");
                        }else{
                            System.out.print(hall.hallMatrix[i][j].seatName + " - ");
                        }
                    }
                    System.out.println();
                }
            }


        }

    }

    static void arrangeSeats(List<Student> studentList, List<Room> examHallList) {
        boolean isArrangeble = check(studentList, examHallList);
        System.out.println(isArrangeble);

        if (isArrangeble) {
            int hallIndex = 0;
            for (Student theStudent : studentList) {
                System.out.println(theStudent.regNo);
                Room hall = examHallList.get(hallIndex);
                if (hall.totalNoOfSeats > 0) {
                    perform(hall,theStudent);
                } else {
                    hallIndex = (hallIndex + 1) % examHallList.size();
                }
            }
        }
        return;
    }

    static int[] perform(Room hall,Student theStudent){
        for (int col = 0; col <= (hall.cols)- hall.seatPerBench; col += hall.seatPerBench) {
            for (int row = 0; row < hall.rows; row++) {
                if (hall.hallMatrix[row][col].student == null) {
                    hall.hallMatrix[row][col].student = theStudent;
                    hall.totalNoOfSeats -= 1;
                    return new int[] {2,2};
                }
            }
        }
        return new int[] {0,0};
    }
    

    static boolean check(List<Student> studentList, List<Room> examHallList) {

        int noOfStudents = studentList.size();

        int totalNoOfSeats = 0;
        for (Room hall : examHallList) {
            totalNoOfSeats += hall.totalNoOfSeats;
        }

        System.out.println("No Of Students : " + noOfStudents);
        System.out.println("No Of Seats : " + totalNoOfSeats);

        if (noOfStudents > totalNoOfSeats) {
            return false;
        }

        return true;
    }

}