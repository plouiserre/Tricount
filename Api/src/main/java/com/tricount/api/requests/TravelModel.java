package com.tricount.api.requests;

import java.util.List;

public record TravelModel(String Name, List<ActivityModel> Activities) {
}
