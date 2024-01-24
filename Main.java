public class Main {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        // Приклад використання:
        System.out.println("---1---");
        System.out.println("\"\" --> " + calculator.add(""));         // Виведе 0
        System.out.println("\"1\" --> " + calculator.add("1"));        // Виведе 1
        System.out.println("\"1,2\" --> " + calculator.add("1,2"));      // Виведе 3

        }
    }
