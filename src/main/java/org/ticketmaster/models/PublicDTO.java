package org.ticketmaster.models;

import lombok.Data;

@Data
public class PublicDTO {
    
    private String startDateTime;
    private boolean startTBD;
    private boolean startTBA;
    private String endDateTime;
    
    // getters and setters
}
