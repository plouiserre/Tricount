package com.tricount.domain.validate;

import com.tricount.domain.entities.Participant;

import java.util.List;

public class ValidateParticipant implements IValidateParticipant {

    @Override
    public boolean Validate(List<Participant> participants) {
        for(var participant : participants) {
            boolean result = participant.lastName() != "" && participant.lastName() != null
                    && participant.firstName() != "" && participant.firstName() != null;
            if(!result)
                return false;
        }
        return true;
    }
}
