package com.tricount.domain.validate;

import com.tricount.domain.entities.Activity;

import java.util.List;

public class ValidateActivities implements IValidateActivities {

    @Override
    public boolean Validate(List<Activity> activities) {
        for(var activity : activities){
            boolean result = activity.name()!= ""  && activity.name()!= null &&
                    activity.Price()> 0.0 && activity.participants() != null && !activity.participants().isEmpty();
            if(!result)
                return false;
        }
        return true;
    }
}
