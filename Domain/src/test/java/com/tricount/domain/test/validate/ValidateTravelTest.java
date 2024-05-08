package com.tricount.domain.test.validate;

import com.tricount.domain.entities.Activity;
import com.tricount.domain.entities.Participant;
import com.tricount.domain.entities.Travel;
import com.tricount.domain.validate.ValidateActivity;
import com.tricount.domain.validate.ValidateTravel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateTravelTest {

    List<Activity> _activities;

    public ValidateTravelTest(){
        var participants = new ArrayList<Participant>();
        var firstActivity = new Activity("bar", 23.67, participants);
        var secondActivity = new Activity("restaurant",125.54, participants);
        _activities = Arrays.asList(firstActivity, secondActivity);
    }

    @Test
    public void ShouldValidateTravelComplete(){
        var travel = new Travel("Summer vacation", _activities);
        var validate = new ValidateTravel();

        var result = validate.Validate(travel);

        Assertions.assertTrue(result);
    }


    @Test
    public void ShouldNotValidateTravelWithoutName(){
        var travel = new Travel("", _activities);
        var validate = new ValidateTravel();

        var result = validate.Validate(travel);

        Assertions.assertFalse(result);
    }


    @Test
    public void ShouldNotValidateTravelWithoutActivites(){
        var firstTravel = new Travel("Summer vacation", null);
        var activities = new ArrayList<Activity>();
        var secondTravel = new Travel("Winter vacation", activities);
        var validate = new ValidateTravel();

        var firstResult = validate.Validate(firstTravel);
        var secondResult = validate.Validate(secondTravel);

        Assertions.assertFalse(firstResult);
        Assertions.assertFalse(secondResult);
    }
}
