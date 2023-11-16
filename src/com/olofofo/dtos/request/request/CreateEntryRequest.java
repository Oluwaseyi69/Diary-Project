package com.olofofo.request;

import lombok.Data;

@Data
public class CreateEntryRequest {
    private String OwnerName;
    private String title;
    private String body;
}
