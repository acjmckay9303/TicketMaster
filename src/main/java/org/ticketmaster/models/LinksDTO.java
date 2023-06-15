package org.ticketmaster.models;

import lombok.Data;

import java.util.List;

@Data
public class LinksDTO {
    
    private HrefDTO self;
    private List<HrefDTO> attractions;
    private List<HrefDTO> venues;
    
    // getters and setters
}
