package org.ticketmaster.models;

import lombok.Data;

@Data
public class PageableDTO<T> {
    
    private EmbeddedDTO<T> _embedded;
    private LinksDTO _links;
    private PageDTO page;
    
    // getters and setters
}
