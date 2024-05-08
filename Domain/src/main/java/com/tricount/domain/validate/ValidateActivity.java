package com.tricount.domain.validate;

import com.tricount.domain.entities.Activity;

public class ValidateActivity implements  IValidate<Activity> {
    @Override
    public boolean Validate(Activity activity) {
        return activity.name()!= ""  && activity.name()!= null &&
                activity.Price()> 0.0 && activity.participants() != null && !activity.participants().isEmpty();
    }
}
