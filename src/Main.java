import java.util.Scanner;

public class Main {
    static StepTracker stepTracker = new StepTracker();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (true) {
            if (userInput == 1) {
                stepTracker.addSteps();
            } else if (userInput == 2) {
                stepTracker.showStatistics();
            } else if (userInput == 3) {
                StepTracker.setNewGoal();
            } else if (userInput == 4) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("\nИзвините, данная команда на текущий момент не поддерживается. " +
                        "Выберите одну из команд, указанных ниже:\n");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("\n1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день. Текущая цель: " + StepTracker.getTargetStepsInDay());
        System.out.println("4 - Выйти из приложения");
    }
}
