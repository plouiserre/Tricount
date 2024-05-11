package com.tricount.domain.validate;

import com.tricount.domain.entities.Travel;

public class ValidateTravel implements IValidateTravel{

    private IValidateActivities _validateActivities;
    private IValidateParticipant _validateParticipants;
    private Travel _travel;

    public ValidateTravel(IValidateParticipant validateParticipant, IValidateActivities validateActivity){
        _validateActivities = validateActivity;
        _validateParticipants = validateParticipant;
    }

    @Override
    public boolean Validate(Travel travel) {
        _travel = travel;
        if(SimpleCheckTravel()) {
            return ValidateAllActivities();
        }
        else {
            return false;
        }
    }

    private boolean SimpleCheckTravel(){
        return _travel.Name() != "" && _travel.Name()!= null
                && _travel.Activities() != null && !_travel.Activities().isEmpty();
    }

    private boolean ValidateAllActivities() {
        boolean resultActivity = _validateActivities.Validate(_travel.Activities());
        if (!resultActivity) {
            return false;
        } else {
            for (var activity : _travel.Activities()) {
                boolean resultParticipant = _validateParticipants.Validate(activity.participants());
                if (!resultParticipant) {
                    return false;
                }
            }
        }
        return true;
    }

}
