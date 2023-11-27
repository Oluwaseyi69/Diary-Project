package com.olofofo.dtos.request.request;


import lombok.Data;

@Data
public class FindEntryRequest {
    private String username;
    private String title;
}
