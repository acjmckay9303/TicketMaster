package org.ticketmaster.models;

import lombok.Data;

@Data
public class ImageDTO {
    
    private String ratio;
    private String url;
    private int width;
    private int height;
    private boolean fallback;
    
    // getters and setters
}
