package org.ticketmaster.models;

import lombok.Data;

import java.util.List;

@Data
public class VenueDTO {
    
    private String name;
    private String type;
    private String id;
    private boolean test;
    private String url;
    private String locale;
    private List<ImageDTO> images;
    private String postalCode;
    private String timezone;
    private CityDTO city;
    private CountryDTO country;
    private AddressDTO address;
    private LocationDTO location;
    private UpcomingEventsDTO upcomingEvents;
    private LinksDTO _links;
    
    // getters and setters
}