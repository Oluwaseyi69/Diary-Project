package com.olofofo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Entry {
        private String id;
        private String title;
        private String ownerName;
        private String body;

}
