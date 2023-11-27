package com.olofofo.dtos.request.request;


import lombok.Data;

@Data
public class AddEntryRequest {
    String username;
    String body;
    String title;
}
