public class Converter {

    static double metreInOneStep = 0.75;
    final static int METRES_IN_ONE_KILOMETRE = 1000;
    static double burnedCaloriesInOneStep = 50.0;
    final static int CALORIES_IN_ONE_KILOCALORIE = 1000;

    public double getDistance(int totalStepsPerMonth) {
        return totalStepsPerMonth * getMetreInOneStep() / METRES_IN_ONE_KILOMETRE;
    }

    public void printDistance(double distance) {
        System.out.println("Пройденная дистанция: " + distance + "км");
    }

    public double getCaloriesBurned(int totalStepsPerMonth) {
        return totalStepsPerMonth * getBurnedCaloriesInOneStep() / CALORIES_IN_ONE_KILOCALORIE;
    }

    public void printCaloriesBurned(double burnedCalories) {
        System.out.println("Количество сожжённых калорий: " + burnedCalories + "ккал");
    }

    public static double getMetreInOneStep() {
        return metreInOneStep;
    }

    public static void setMetreInOneStep(double metreInOneStep) {
        Converter.metreInOneStep = metreInOneStep;
    }

    public static double getBurnedCaloriesInOneStep() {
        return burnedCaloriesInOneStep;
    }

    public static void setBurnedCaloriesInOneStep(double burnedCaloriesInOneStep) {
        Converter.burnedCaloriesInOneStep = burnedCaloriesInOneStep;
    }
}
