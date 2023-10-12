package dtos.request;


import lombok.Data;

@Data
public class FindEntryRequest {
    private String username;
    private String title;
}
