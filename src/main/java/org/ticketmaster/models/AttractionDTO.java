package org.ticketmaster.models;

import lombok.Data;

import java.util.List;

@Data
public class AttractionDTO {
    
    private String name;
    private String type;
    private String id;
    private boolean test;
    private String url;
    private String locale;
    private List<ImageDTO> images;
    private List<ClassificationDTO> classifications;
    private UpcomingEventsDTO upcomingEvents;
    private LinksDTO _links;
    
    // getters and setters
}
