package org.ticketmaster.models;

import lombok.Data;

@Data
public class DatesDTO {
    
    private StartDTO start;
    private String timezone;
    private StatusDTO status;
    private boolean spanMultipleDays;
    
    // getters and setters
}
