package com.luminary.apiedenmongo.Models.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LikeRequest {
    private int engagerId;

    public LikeRequest(int engagerId) {
        this.engagerId = engagerId;
    }

    public LikeRequest() {
    }
}
