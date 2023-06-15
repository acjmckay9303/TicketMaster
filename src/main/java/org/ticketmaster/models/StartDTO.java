package org.ticketmaster.models;

import lombok.Data;

@Data
public class StartDTO {
    
    private String localDate;
    private String localTime;
    private String dateTime;
    private boolean dateTBD;
    private boolean dateTBA;
    private boolean timeTBA;
    private boolean noSpecificTime;
    
    // getters and setters
}
