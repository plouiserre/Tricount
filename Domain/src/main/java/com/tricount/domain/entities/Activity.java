package com.tricount.domain.entities;

import java.util.List;

public record Activity(String name, Double Price, List<Participant> participants) {
}
