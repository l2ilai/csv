package Part5.cvs;

import java.util.Scanner;

public class InputMaxConsumption {
    protected int getMaxConsumption() {
        int number = -1;
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число максимально потребление ресурсов: ");
        if (s.hasNextInt()) {
            number = s.nextInt();
        }
        return number;
    }
}
