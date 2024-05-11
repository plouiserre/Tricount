package com.tricount.api.requests;

import java.util.List;

public record ActivityModel(String name, Double Price, List<ParticipantModel> participants) {
}
