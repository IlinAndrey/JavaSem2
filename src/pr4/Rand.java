package pr4;
import java.util.Random;
public class Rand implements Runnable {
    private final String[] words = {"Олег", "Максим", "Егор", "Дима", "Степа", "Илья", "Саша", "Алена", "Ира", "Макар", "Николай", "Алина", "Оля", "Марина", "Даня", "Глеб", "Лена", "Лиза", "Семен", "Ваня", "Артем", "Геннадий", "Настя", "Кирилл", "Паша", "Луиза", "Антон", "Маша", "Света", "Даша", "Боря", "Леня", "Лев", "Кристина", "Ксюша"};
    private final Random random = new Random();

    @Override
    public void run() {
        try {
            System.out.println(words[random.nextInt(words.length)]);
            Thread.sleep(random.nextInt(5001) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}