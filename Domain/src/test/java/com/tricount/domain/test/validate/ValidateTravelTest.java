package com.tricount.domain.test.validate;

import com.tricount.domain.entities.Activity;
import com.tricount.domain.entities.Participant;
import com.tricount.domain.entities.Travel;
import com.tricount.domain.validate.ValidateActivities;
import com.tricount.domain.validate.ValidateParticipant;
import com.tricount.domain.validate.ValidateTravel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateTravelTest {

    ValidateParticipant _validateParticipant;

    ValidateActivities _validateActivities;

    List<Activity> _activities;

    public ValidateTravelTest(){
        _validateActivities = Mockito.mock(ValidateActivities.class);
        _validateParticipant = Mockito.mock(ValidateParticipant.class);
        var participants = new ArrayList<Participant>();
        var firstActivity = new Activity("bar", 23.67, participants);
        var secondActivity = new Activity("restaurant",125.54, participants);
        _activities = Arrays.asList(firstActivity, secondActivity);
    }

    @Test
    public void ShouldValidateTravelComplete(){
        var travel = new Travel("Summer vacation", _activities);
        MockBehaviorValidates(true, true);
        var validate = new ValidateTravel(_validateParticipant, _validateActivities);

        var result = validate.Validate(travel);

        Assertions.assertTrue(result);
    }


    @Test
    public void ShouldNotValidateTravelWithoutName(){
        var travel = new Travel("", _activities);
        MockBehaviorValidates(true, true);
        var validate = new ValidateTravel(_validateParticipant, _validateActivities);

        var result = validate.Validate(travel);

        Assertions.assertFalse(result);
    }


    @Test
    public void ShouldNotValidateTravelWithoutActivites(){
        var firstTravel = new Travel("Summer vacation", null);
        var activities = new ArrayList<Activity>();
        var secondTravel = new Travel("Winter vacation", activities);
        MockBehaviorValidates(true, true);
        var validate = new ValidateTravel(_validateParticipant, _validateActivities);

        var firstResult = validate.Validate(firstTravel);
        var secondResult = validate.Validate(secondTravel);

        Assertions.assertFalse(firstResult);
        Assertions.assertFalse(secondResult);
    }

    @Test
    public void ShouldNotValidateTravelBecauseValidationActivitiesFailed(){
        var travel = new Travel("Summer vacation", _activities);
        MockBehaviorValidates(false, true);
        var validate = new ValidateTravel(_validateParticipant, _validateActivities);

        var result = validate.Validate(travel);

        Assertions.assertFalse(result);
    }


    private void MockBehaviorValidates(Boolean activityValidateResponse, Boolean participantValidateResponse){
        Mockito.when(_validateParticipant.Validate(Mockito.anyList())).thenReturn(participantValidateResponse);
        Mockito.when(_validateActivities.Validate(Mockito.anyList())).thenReturn(activityValidateResponse);
    }
}
