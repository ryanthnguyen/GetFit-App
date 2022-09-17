package com.GetFit.dal;

import com.GetFit.dao.Goal;
import com.GetFit.dao.Macro;
import io.dropwizard.hibernate.AbstractDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;

public class Macros extends AbstractDAO<Macros.Record> {
    private static final String TABLE_NAME = "Macro";
    private static final String ID = "id";
    private static final String GOAL_ID = "goal_id";
    private static final String PROTEIN = "protein";
    private static final String FATS = "fats";
    private static final String CARBS = "carbs";
    private static final String TOTAL_CALORIES = "total_calories";
    private ModelMapper modelMapper;

    private SessionFactory sessionFactory;
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public Macros(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
        modelMapper = new ModelMapper();
    }

    public List<Macros.Record> listMacros() {
        return list(namedTypedQuery("listMacros"));
    }

    public void createMacro(Macro macro){
        Macros.Record record = modelMapper.map(macro, Macros.Record.class);
        persist(record);
    }

    @NamedQueries({
        @NamedQuery(name = "listMacros", query = "SELECT * FROM Macro")
    })
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(builderClassName = "Builder")
    @Table(name = TABLE_NAME)
    @Data
    public static class Record{
        @Column(name = ID)
        String id;

        @Column(name = GOAL_ID)
        String goalId;

        @Column(name = PROTEIN)
        double protein;

        @Column(name = FATS)
        double fats;

        @Column(name = CARBS)
        double carbs;

        @Column(name = TOTAL_CALORIES)
        int totalCalories;
    }


}





