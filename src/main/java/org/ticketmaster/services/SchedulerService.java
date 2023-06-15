package org.ticketmaster.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SchedulerService {
    
    private final TicketMasterService ticketMasterService;
    
    public void checkForRecentReleases() {
        
        ticketMasterService.fetchEvents();
    }
}
