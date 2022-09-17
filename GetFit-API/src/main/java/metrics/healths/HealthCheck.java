package metrics.healths;

public class HealthCheck extends com.codahale.metrics.health.HealthCheck {
    private int protein;
    private int carbs;
    private int fats;

    public HealthCheck(int protein, int carbs, int fats){
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }


    @Override
    protected Result check() throws Exception {
        if (protein > 2000 || carbs > 2000 || fats > 2000){
            Result.unhealthy("value is too great");
        }

        return Result.healthy();
    }
}
