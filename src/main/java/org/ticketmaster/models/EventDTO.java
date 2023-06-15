package org.ticketmaster.models;

import lombok.Data;

import java.util.List;

@Data
public class EventDTO {
    
    private String name;
    private String type;
    private String id;
    private boolean test;
    private String url;
    private String locale;
    private List<ImageDTO> images;
    private SalesDTO sales;
    private DatesDTO dates;
    private List<ClassificationDTO> classifications;
    private PromoterDTO promoter;
    private List<PromoterDTO> promoters;
    private LinksDTO _links;
    private EmbeddedDTO<VenueDTO> _embedded;
    
    // getters and setters
}




