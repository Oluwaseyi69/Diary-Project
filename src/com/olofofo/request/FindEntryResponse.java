package dtos.request;

import lombok.Data;

@Data
public class FindEntryResponse {


    private String title;
    private String body;
    private String dateCreated;
    private String timeCreated;
}
