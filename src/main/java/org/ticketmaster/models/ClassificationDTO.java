package org.ticketmaster.models;

import lombok.Data;

@Data
public class ClassificationDTO {
    
    private boolean primary;
    private SegmentDTO segment;
    private GenreDTO genre;
    private SubGenreDTO subGenre;
    private boolean family;
    
    // getters and setters
}
