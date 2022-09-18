package com.GetFit.dal;

import com.GetFit.dao.Goal;
import com.GetFit.dao.Macro;
import com.GetFit.dao.VanillaDao;
import com.GetFit.utils.TypeMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Table;
import java.util.List;

public class Goals extends VanillaDao<Goals.Record> {
    private static final String TABLE_NAME = "Goal";
    private static final String ID = "id";
    private static final String USER_ID = "user_id";
    private static final String NAME = "name";
    private static final String MACRO_ID = "macro_id";
    private SessionFactory sessionFactory;
    private TypeMapper typeMapper;

    public Goals(SessionFactory sessionFactory){
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public List<Goals.Record> listGoals() {
        return list(namedTypedQuery("listMacros"));
    }

    public void createGoal(Goal goal){
        persist(typeMapper.toGoalEntity(goal));
    }

    public Goal getMacro(int id){
        Goal goal = typeMapper.toGoalDao(get(id));

        if (goal == null){
            throw new EntityNotFoundException();
        }
        return goal;
    }

    public void updateGoal(Goal goal){
        persist(typeMapper.toGoalEntity(goal));
    }

    public void deleteGoal(Goal goal) throws EntityNotFoundException {
        delete(typeMapper.toGoalEntity(goal));
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Table(name = TABLE_NAME)
    public class Record{
        @Column(name = ID)
        String id;

        @Column(name = USER_ID)
        String userId;

        @Column(name = NAME)
        String name;

        @Column(name = MACRO_ID)
        String macroId;
    }
}
