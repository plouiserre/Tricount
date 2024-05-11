package com.tricount.domain;

import com.tricount.domain.entities.Travel;
import com.tricount.domain.validate.IValidateTravel;

public class AddActivities {

    private IValidateTravel _validateTravel;

    public AddActivities(IValidateTravel validateTravel){
        _validateTravel = validateTravel;
    }

    public boolean AddActivities(Travel travel){
        return _validateTravel.Validate(travel);
    }
}
