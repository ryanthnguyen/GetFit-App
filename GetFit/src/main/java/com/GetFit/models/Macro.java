package com.GetFit.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.Generated;
import javax.validation.Valid;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/Macro")
@Produces(MediaType.APPLICATION_JSON)
@Data
@JsonDeserialize(builder = Macro.Builder.class)
public class Macro {
    @JsonProperty("id")
    private final @Valid String id;
    @JsonProperty("protein")
    private final @Valid int protein;
    @JsonProperty("carbs")
    private final @Valid int carbs;
    @JsonProperty("fats")
    private final @Valid int fats;

    public static Builder builder() {return new Builder();}


    @Generated
    public Builder toBuilder(){
        return (new Builder()).id(this.id).protein(this.protein).carbs(this.carbs).fats(this.fats);
    }

    public String getId(){
        return this.id;
    }

    public int getProtein(){
        return this.protein;
    }

    public int getCarbs(){
        return this.carbs;
    }

    public int getFats(){
        return this.fats;
    }

    @JsonPOJOBuilder(withPrefix="")
    public static class Builder{
        @JsonProperty("id")
        private String id;
        @JsonProperty("protein")
        private int protein;
        @JsonProperty("carbs")
        private int carbs;
        @JsonProperty
        private int fats;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder protein(int protein){
            this.protein = protein;
            return this;
        }

        public Builder carbs(int carbs){
            this.carbs = carbs;
            return this;
        }
        public  Builder fats(int fats){
            this.fats = fats;
            return this;
        }

        public Macro build(){
            Macro __instance__ = new Macro(this.id, this.protein, this.carbs, this.fats);
            return __instance__;
        }

    }

}
