import java.util.Scanner;

public class StepTracker {
    private static final int NUMBER_OF_DAYS = 30;
    private static final int NUMBER_OF_MONTHS = 12;
    private static int[][] DATA;
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();

    public StepTracker() {
        DATA = new int[NUMBER_OF_MONTHS][NUMBER_OF_DAYS];
    }

    public void showStatistics() {
        enterMonthNumber();
        printStepsPerMonthByDays();
        TotalStepsPerMonth.printTotalStepsPerMonth(TotalStepsPerMonth.totalStepsPerMonth());
        MaxStepsInDayPerMonth.printMaxStepsInDayPerMonth(MaxStepsInDayPerMonth.maxStepsInDayPerMonth());
        AverageAmountOfSteps.printAverageAmountOfSteps(AverageAmountOfSteps.averageAmountOfSteps(TotalStepsPerMonth.totalStepsPerMonth()));
        converter.getDistance(TotalStepsPerMonth.totalStepsPerMonth());
        converter.getCaloriesBurned(TotalStepsPerMonth.totalStepsPerMonth());
        FindBestSeries.printBestSeries(FindBestSeries.findBestSeries());
    }

    public void addSteps() {
        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        while (month <= 0 || month > 12) {
            System.out.println("Извините, Вы ввели некорректный месяц.");
            System.out.print("Введите номер месяца: ");
            month = scanner.nextInt();
        }

        System.out.print("Введите день: ");
        int day = scanner.nextInt();
        while (day <= 0 || day > 30) {
            System.out.println("Извините, Вы ввели некорректный день.");
            System.out.print("Введите день: ");
            day = scanner.nextInt();
        }

        System.out.print("Введите количество шагов: ");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Извините, Вы ввели некорректное количество шагов.");
            System.out.print("Введите количество шагов: ");
            steps = scanner.nextInt();
        }

        int totalSteps = DATA[month - 1][day - 1];
        totalSteps += steps;
        DATA[month - 1][day - 1] = totalSteps;
        System.out.println("Значение сохранено! Текущее количество пройденных шагов в данный день: " + totalSteps);
    }

    static int month;

    private void enterMonthNumber() {
        System.out.print("Введите номер месяца: ");
        month = scanner.nextInt();
        while (month <= 0 || month > 12) {
            System.out.println("Извините, Вы ввели некорректный месяц.");
            System.out.print("Введите номер месяца: ");
            month = scanner.nextInt();
        }
    }

    private void printStepsPerMonthByDays() {
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < DATA[month - 1].length; i++) {
            System.out.print((i + 1) + " день: " + DATA[month - 1][i] + ", ");
        }
    }

    static class TotalStepsPerMonth {
        static int totalStepsPerMonth() {
            int totalStepsPerMonth = 0;
            for (int i = 0; i < DATA[month - 1].length; i++) {
                totalStepsPerMonth += DATA[month - 1][i];
            }
            return totalStepsPerMonth;
        }

        static void printTotalStepsPerMonth(int totalStepsPerMonth) {
            System.out.println("\nОбщее количество шагов за месяц: " + totalStepsPerMonth);
        }
    }

    static class MaxStepsInDayPerMonth {
        static int maxStepsInDayPerMonth() {
            int maxStepsPerMonth = 0;
            for (int i = 0; i < DATA[month - 1].length; i++) {
                if (DATA[month - 1][i] > maxStepsPerMonth)
                    maxStepsPerMonth = DATA[month - 1][i];
            }
            return maxStepsPerMonth;
        }

        static void printMaxStepsInDayPerMonth(int maxStepsPerMonth) {
            System.out.println("Максимальное пройденное количество шагов за день в месяце: " + maxStepsPerMonth);
        }
    }

    static class AverageAmountOfSteps {
        static int averageAmountOfSteps(int totalStepsPerMonth) {
            return totalStepsPerMonth / NUMBER_OF_DAYS;
        }

        static void printAverageAmountOfSteps(int averageAmountOfSteps) {
            System.out.println("Среднее количество шагов: " + averageAmountOfSteps);
        }
    }

    static class FindBestSeries {
        static int findBestSeries() {
            int maxCounter = 0;
            int counter = 0;
            for (int i = 0; i < DATA[month - 1].length; i++) {
                if (DATA[month - 1][i] >= Goal.getTargetStepsInDay()) {
                    counter++;
                    if (counter > maxCounter) {
                        maxCounter = counter;
                    }
                } else if (DATA[month - 1][i] < Goal.getTargetStepsInDay()) {
                    counter = 0;
                }
            }
            return maxCounter;
        }

        static void printBestSeries(int maxCounter) {
            System.out.println("Лучшая серия: " + maxCounter);
        }
    }

    static class Goal {
        private static int targetStepsInDay = 10_000;
        static Scanner scanner = new Scanner(System.in);

        public static void setNewGoal() {
            System.out.print("\nКакое количество шагов Вы хотите установить в качестве новой цели? ");
            int newTargetStepsInDay = scanner.nextInt();
            setTargetStepsInDay(newTargetStepsInDay);
        }

        public static void setTargetStepsInDay(int targetStepsInDay) {
            if (targetStepsInDay >= 0) {
                Goal.targetStepsInDay = targetStepsInDay;
                System.out.println("\nНовая цель сохранена!\n");
            } else {
                System.out.println("\nИзвините, Вы ввели некорректное значение.\n");
            }
        }

        public static int getTargetStepsInDay() {
            return targetStepsInDay;
        }
    }
}

