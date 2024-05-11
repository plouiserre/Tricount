package com.tricount.domain.test.validate;

import com.tricount.domain.entities.Activity;
import com.tricount.domain.entities.Participant;
import com.tricount.domain.validate.ValidateActivities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateActivityTest {
    List<Participant> _participants;
    List<Activity> _goodActivities;

    public ValidateActivityTest(){
        FillParticipants();
        FillActivities();
    }

    private void FillParticipants(){
        var firstParticipant = new Participant("Doe", "John");
        var secondParticipant = new Participant("Doe", "Jane");
        _participants = Arrays.asList(firstParticipant, secondParticipant);
    }

    private void FillActivities(){
        var firstGoodActivity = new Activity("Movie", 23.5, _participants);
        var secondGoodActivity = new Activity("Bar", 65.5, _participants);
        _goodActivities = Arrays.asList(firstGoodActivity, secondGoodActivity);
    }

    @Test
    public void ShouldValidateActivityComplete(){
        var validateActivity = new ValidateActivities();

        boolean result = validateActivity.Validate(_goodActivities);

        Assertions.assertTrue(result);
    }

    @Test
    public void ShouldNotValidateActivityBecauseActivityNameIsMissing(){
        var activity = new Activity("", 23.5, _participants);
        var badActivities = CreateBadActivity(activity);
        var validateActivity = new ValidateActivities();

        boolean result = validateActivity.Validate(badActivities);

        Assertions.assertFalse(result);
    }

    @Test
    public void ShouldNotValidateActivityBecausePriceActivityIsNotDefined(){
        var activity = new Activity("Movie", 0.0, _participants);
        var badActivities = CreateBadActivity(activity);
        var validateActivity = new ValidateActivities();

        boolean result = validateActivity.Validate(badActivities);

        Assertions.assertFalse(result);
    }

    @Test
    public void ShouldNotValidateActivityBecauseNoneParticipants(){
        var validateActivity = new ValidateActivities();
        var firstActivity = new Activity("Movie", 23.5, null);
        var firstBadActivities = CreateBadActivity(firstActivity);
        var participants = new ArrayList<Participant>();
        var secondActivity =  new Activity("Movie", 23.5, participants);
        var secondBadActivities = CreateBadActivity(secondActivity);

        boolean firstResult = validateActivity.Validate(firstBadActivities);
        boolean secondResult = validateActivity.Validate(secondBadActivities);

        Assertions.assertFalse(firstResult);
        Assertions.assertFalse(secondResult);
    }

    private List<Activity> CreateBadActivity(Activity badActivity){
        var badActivities = new ArrayList<Activity>(_goodActivities);
        badActivities.add(badActivity);
        return badActivities;
    }
}
