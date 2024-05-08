package com.tricount.domain.test.validate;

import com.tricount.domain.entities.Activity;
import com.tricount.domain.entities.Participant;
import com.tricount.domain.validate.ValidateActivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateActivityTest {
    List<Participant> _participants;

    public ValidateActivityTest(){
        var firstParticipant = new Participant("Doe", "John");
        var secondParticipant = new Participant("Doe", "Jane");
        _participants = Arrays.asList(firstParticipant, secondParticipant);
    }

    @Test
    public void ShouldValidateActivityComplete(){
        var activity = new Activity("Movie", 23.5, _participants);
        var validateActivity = new ValidateActivity();

        boolean result = validateActivity.Validate(activity);

        Assertions.assertTrue(result);
    }

    @Test
    public void ShouldNotValidateActivityBecauseActivityNameIsMissing(){
        var activity = new Activity("", 23.5, _participants);
        var validateActivity = new ValidateActivity();

        boolean result = validateActivity.Validate(activity);

        Assertions.assertFalse(result);
    }

    @Test
    public void ShouldNotValidateActivityBecausePriceActivityIsNotDefined(){
        var activity = new Activity("Movie", 0.0, _participants);
        var validateActivity = new ValidateActivity();

        boolean result = validateActivity.Validate(activity);

        Assertions.assertFalse(result);
    }

    @Test
    public void ShouldNotValidateActivityBecauseNoneParticipants(){
        var validateActivity = new ValidateActivity();
        var firstActivity = new Activity("Movie", 23.5, null);
        var participants = new ArrayList<Participant>();
        var secondActivity =  new Activity("Movie", 23.5, participants);

        boolean firstResult = validateActivity.Validate(firstActivity);
        boolean secondResult = validateActivity.Validate(secondActivity);

        Assertions.assertFalse(firstResult);
        Assertions.assertFalse(secondResult);
    }
}
