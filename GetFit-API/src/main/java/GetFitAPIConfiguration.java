import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GetFitAPIConfiguration extends Configuration {
    @NotNull
    private int protein = 0;

    @NotNull
    private int fats = 0;

    @NotNull
    private int carbs = 0;

    @JsonProperty
    public int getProtein(){
        return protein;
    }

    @JsonProperty
    public void setProtein(int protein){
        this.protein = protein;
    }

    @JsonProperty
    public int getCarbs(){
        return carbs;
    }

    @JsonProperty
    public void setCarbs(int carbs){
        this.carbs = carbs;
    }

    @JsonProperty
    public int getFats(){
        return fats;
    }

    @JsonProperty
    public void setFats(int fats){
        this.fats = fats;
    }
}
