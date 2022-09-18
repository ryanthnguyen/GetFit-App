package com.GetFit.utils;
import com.GetFit.dal.Goals;
import com.GetFit.dal.Macros;
import com.GetFit.dao.Goal;
import com.GetFit.dao.Macro;
import org.modelmapper.ModelMapper;

public class TypeMapper{
    ModelMapper modelMapper;

    public TypeMapper(){
        this.modelMapper = new ModelMapper();
    }

    // map Macro dao -> Macro entity
    public Macros.Record toMacroEntity(Macro macro){
        return modelMapper.map(macro, Macros.Record.class);
    }

    public Macro toMacroDao(Macros.Record macro){
        return modelMapper.map(macro, Macro.class);
    }

    public Goals.Record toGoalEntity(Goal goal){
        return modelMapper.map(goal, Goals.Record.class);
    }

    public Goal toGoalDao(Goals.Record goal){
        return modelMapper.map(goal, Goal.class);
    }
}
