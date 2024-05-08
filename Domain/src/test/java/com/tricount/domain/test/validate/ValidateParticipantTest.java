package com.tricount.domain.test.validate;

import com.tricount.domain.entities.Participant;
import com.tricount.domain.validate.ValidateParticipant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ValidateParticipantTest {
    @Test
    public void ShouldValidateParticipantWithFirstNameAndLastNameComplete(){
        var participant = new Participant("Doe", "John");
        var validate = new ValidateParticipant();

        boolean result = validate.Validate(participant);

        Assertions.assertTrue(result);
    }

    @Test
    public void ShouldNotValidateWithParticipantWithoutFirstName(){
        var participant = new Participant("", "John");
        var validate = new ValidateParticipant();

        boolean result = validate.Validate(participant);

        Assertions.assertFalse(result);
    }

    @Test
    public void ShouldNotValidateWithParticipantWithoutLastName(){
        var participant = new Participant("Doe", "");
        var validate = new ValidateParticipant();

        boolean result = validate.Validate(participant);

        Assertions.assertFalse(result);
    }
}
