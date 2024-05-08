package com.tricount.domain.validate;

import com.tricount.domain.entities.Participant;

public class ValidateParticipant implements IValidate<Participant> {

    @Override
    public boolean Validate(Participant participant) {
        return participant.lastName() != "" && participant.lastName() != null
                && participant.firstName() != "" && participant.firstName() != null;
    }
}
