package com.tricount.domain.test.validate;

import com.tricount.domain.entities.Participant;
import com.tricount.domain.validate.ValidateParticipant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateParticipantTest {

    List<Participant> _badParticipants;

    @Test
    public void ShouldValidateParticipantWithFirstNameAndLastNameComplete(){
        var participant = new Participant("Doe", "John");
        var goodParticipants = Arrays.asList(participant);
        var validate = new ValidateParticipant();

        boolean result = validate.Validate(goodParticipants);

        Assertions.assertTrue(result);
    }

    @Test
    public void ShouldNotValidateWithParticipantWithoutFirstName(){
        var participant = new Participant("", "John");
        var badParticipant = MakeBadParticipantList(participant);
        var validate = new ValidateParticipant();

        boolean result = validate.Validate(badParticipant);

        Assertions.assertFalse(result);
    }

    @Test
    public void ShouldNotValidateWithParticipantWithoutLastName(){
        var participant = new Participant("Doe", "");
        var badParticipant = MakeBadParticipantList(participant);
        var validate = new ValidateParticipant();

        boolean result = validate.Validate(badParticipant);

        Assertions.assertFalse(result);
    }

    private List<Participant> MakeBadParticipantList(Participant badParticipant){
        var badParticipants = new ArrayList<Participant>();
        badParticipants.add(badParticipant);
        return badParticipants;
    }
}
