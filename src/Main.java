import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringCalculator calculator = new StringCalculator();
        // Приклад використання:
        try {
            System.out.println("---1---");
            System.out.println("\"\" --> " + calculator.add(""));         // Виведе 0
            System.out.println("\"1\" --> " + calculator.add("1"));        // Виведе 1
            System.out.println("\"1,2\" --> " + calculator.add("1,2"));      // Виведе 3
            System.out.println();
            System.out.println("---2---");
            System.out.println("\"1,2,3,4\" --> " + calculator.add("1,2,3,4"));      // Виведе 10
            System.out.println();
            System.out.println("---3---");
            System.out.println("\"1\\n2,3\" --> " + calculator.add("1\n2,3"));    // Виведе 6
            System.out.println("\"1,\\n\" --> " + calculator.add("1,\n"));      // Виведе 1 (ігнорується порожній рядок)
            System.out.println();
            System.out.println("---4---");
            System.out.println("\"//;\\n1;2\" --> " + calculator.add("//;\n1;2")); // Виведе 3 (з роздільником ";")
            System.out.println();
            System.out.println("---6---");
            System.out.println("\"1000,999,1001\" --> " + calculator.add("1000,999,1001"));
            System.out.println();
            System.out.println("---7---");
            System.out.println("\"//[***]\\n1***2***3\" --> " + calculator.add("//[***]\n1***2***3"));
            System.out.println();
            System.out.println("---8---");
            System.out.println("\"//[*][%]\\n1*2%3\" --> " + calculator.add("//[*][%]\n1*2%3"));
            System.out.println("\"//[%][*]\\n1*2%3\" --> " + calculator.add("//[%][*]\n1*2%3"));
            System.out.println();
            System.out.println("---9---");
            System.out.println("\"//[%%][***]\\n2%%3***1001\" --> " + calculator.add("//[%%][***]\n2%%3***1001"));
            System.out.println();
            System.out.println("---5---");
            System.out.println("\"-1,2,-3\" --> " + calculator.add("-1,2,-3"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Виведе "Недозволені від'ємні числа: [-1, -3]"

        }
    }
}