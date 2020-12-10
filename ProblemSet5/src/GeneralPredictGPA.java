/* @file GeneralPredictGPA.java
@brief Using loops to predict user's GPA.
@author Sara Barker
@date 10/9/2018 */

import java.util.Scanner;

public class GeneralPredictGPA {

    public static void main(String[] args) {

        //variable declarations and initializations
        Scanner frodo = new Scanner(System.in);
        int hours;
        String grade;
        double numberGrade;
        double[] hoursArray = new double[100];
        double[] gradeArray = new double[100];
        int currentCourse = 0;
        int i;
        String continueResponse = "y";
        double gpa;
        double numerator = 0;
        double denominator = 0;
        int numCourses = 0;

        //welcome
        System.out.println("Welcome to Sara's GPA Predictor!");

        //for loop for y/n input, class number iteration, and Scanner input for Number of Hours and Expected Grade
        for (i = 0; continueResponse.equals("y"); i++) {
            System.out.print("Course ");
            System.out.print(i + 1);
            System.out.println(": Number of hours?");
            hoursArray[i] = frodo.nextInt();
            System.out.println("Expected Grade?");
            grade = frodo.next();

            double ng;

            //conditions for letter grades; assignments
            if (grade.equals("A")) {
                gradeArray[i] = 4;
            } else if (grade.equals("A-")) {
                gradeArray[i] = 3.67;
            } else if (grade.equals("B+")) {
                gradeArray[i] = 3.33;
            } else if (grade.equals("B")) {
                gradeArray[i] = 3;
            } else if (grade.equals("B-")) {
                gradeArray[i] = 2.67;
            } else if (grade.equals("C+")) {
                gradeArray[i] = 2.33;
            } else if (grade.equals("C")) {
                gradeArray[i] = 2;
            } else if (grade.equals("C-")) {
                gradeArray[i] = 1.67;
            } else if (grade.equals("D+")) {
                gradeArray[i] = 1.33;
            } else if (grade.equals("D")) {
                gradeArray[i] = 1;
            } else if (grade.equals("D-")) {
                gradeArray[i] = 0.67;
            } else {
                gradeArray[i] = 0;
            }

            //incrementing the course number
            numCourses++;

            System.out.println("Continue (y/n)?");
            continueResponse = frodo.next();

            //if user does not input y/n, but something else
            while (!((continueResponse.equals("y")) || (continueResponse.equals("n")))) {
                System.out.println("Continue (y/n)?");
                continueResponse = frodo.next();
            }

        }

        //calculations
        for (i = 0; i < 100; i++) {
            numerator = numerator + (gradeArray[i] * hoursArray[i]);
            denominator = denominator + hoursArray[i];
        }

        gpa = numerator / denominator;

        //decimal rounding
        System.out.printf("Semester GPA is: %.4f", gpa);

        double min = gradeArray[0];
        int memory = 0;

        //if user were to receive at A in lowest course
        for (i = 0; i < numCourses; i++) {
            if (min > gradeArray[i]) {
                min = gradeArray[i];
                memory = i;
            }
        }

        //calculations pt. 2
        numerator = numerator - min * hoursArray[memory];
        numerator = numerator + 4 * hoursArray[memory];

        gpa = numerator / denominator;

        //giving advice to user and stating updated GPA if lowest grade = A
        System.out.print(". If you were to get an A in Course ");
        System.out.print(memory+1);
        System.out.printf(" your GPA would be %.4f", gpa);
        System.out.println(", just saying...");

        }
    }

