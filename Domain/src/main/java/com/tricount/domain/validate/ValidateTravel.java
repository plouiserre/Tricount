package com.tricount.domain.validate;

import com.tricount.domain.entities.Travel;

public class ValidateTravel implements IValidate<Travel>{
    @Override
    public boolean Validate(Travel travel) {
        return travel.Name() != "" && travel.Name()!= null
                && travel.Activities() != null && !travel.Activities().isEmpty();
    }
}
