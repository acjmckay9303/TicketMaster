package org.ticketmaster.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmbeddedDTO<T> {
    
    private List<EventDTO> events = new ArrayList<>();
    
    // getters and setters
}
