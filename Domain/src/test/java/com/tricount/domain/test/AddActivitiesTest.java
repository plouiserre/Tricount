package com.tricount.domain.test;

import com.tricount.domain.AddActivities;
import com.tricount.domain.entities.Travel;
import com.tricount.domain.validate.ValidateTravel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AddActivitiesTest {

    private Travel _travel;

    public AddActivitiesTest() {
        _travel = new Travel("Honey moon", null);
    }

    @Test
    public void ShouldSuccessIfTravelValidateSuccess(){
        var addActivities = InitiateAddActivities(true);

        boolean resultAdding = addActivities.AddActivities(_travel);

        Assertions.assertTrue(resultAdding);
    }

    @Test
    public void ShouldFailsIfTravelValidateFails(){
        var addActivities = InitiateAddActivities(false);

        boolean resultAdding = addActivities.AddActivities(_travel);

        Assertions.assertFalse(resultAdding);
    }


    private AddActivities InitiateAddActivities(boolean returnValidateTravel){
        var validateTravel = Mockito.mock(ValidateTravel.class);
        Mockito.when(validateTravel.Validate(_travel)).thenReturn(returnValidateTravel);
        var addActivities = new AddActivities(validateTravel);
        return addActivities;
    }
}
