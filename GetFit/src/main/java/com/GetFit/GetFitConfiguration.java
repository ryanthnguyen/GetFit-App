package com.GetFit;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class GetFitConfiguration extends Configuration {
    // TODO: implement service configuration

    @Valid
    @NotNull
    private static DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory){
        this.database = factory;
    }

    @JsonProperty("database")
    public static DataSourceFactory getDataSourceFactory(){
        return database;
    }

}
