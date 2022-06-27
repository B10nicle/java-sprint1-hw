public class Converter {
    public void getDistance(int totalStepsPerMonth) {
        double distance = totalStepsPerMonth * 0.75 / 1000;
        System.out.println("Пройденная дистанция: " + distance + "км");
    }

    public void getCaloriesBurned(int totalStepsPerMonth) {
        double burnedCalories = totalStepsPerMonth * 50.0 / 1000;
        System.out.println("Количество сожжённых калорий: " + burnedCalories + "ккал");
    }
}
