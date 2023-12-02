import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Перевірка наявності вказаних роздільників
        if (numbers.startsWith("//[")) {
            // Використовуємо регулярний вираз для визначення роздільників
            Pattern pattern = Pattern.compile("//\\[(.*?)\\]\n");
            Matcher matcher = pattern.matcher(numbers);

            if (matcher.find()) {
                String[] delimiters = matcher.group(1).split("\\]\\[");

                // Замінюємо всі входження роздільників на кому та розділяємо рядок за комами
                for (String delimiter : delimiters) {
                    numbers = numbers.replaceFirst("//\\[.*?\\]\n", "")
                            .replaceAll(Pattern.quote(delimiter), ",");
                }
            }
        } else if (numbers.startsWith("//")) {
            // Знаходимо індекс символу нового рядка
            int newlineIndex = numbers.indexOf("\n");

            // Отримуємо роздільник між "//" та символом нового рядка
            String delimiter = numbers.substring(2, newlineIndex);

            // Замінюємо всі входження роздільника на кому та розділяємо рядок за комами
            numbers = numbers.substring(newlineIndex + 1).replaceAll(Pattern.quote(delimiter), ",");
        }

        // Замінюємо символ нового рядка на кому
        numbers = numbers.replace("\n", ",");

        // Регулярний вираз для розділення рядка за комами або будь-яким роздільником
        String[] numberArray = numbers.split("[,]");

        // Замінюємо символ нового рядка на кому та розділяємо рядок за комами
        //String[] numberArray = numbers.replace("\n", ",").split(",");
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String num : numberArray) {
            // Ігноруємо порожні рядки
            if (!num.isEmpty()) {
                int parsedNum = Integer.parseInt(num);
                if (parsedNum < 0) {
                    negativeNumbers.add(parsedNum);
                } else if (parsedNum <= 1000) {
                    sum += parsedNum;
                }
                //sum += parsedNum;
            }
        }
        // Виклик винятку, якщо є від'ємні числа
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Недозволені від'ємні числа: " + negativeNumbers);
        }

        return sum;
    }
}
