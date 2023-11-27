package com.olofofo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Diary {
    private String username;
    private String password;
    private String id;
    private boolean isLocked;

}
