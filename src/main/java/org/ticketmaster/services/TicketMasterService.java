package org.ticketmaster.services;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.ticketmaster.models.EventDTO;
import org.ticketmaster.models.PageableDTO;

import javax.management.Notification;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketMasterService {
    
    private static final String API_KEY = "JDPgGUuRy9gDkZbAo4t2QqXGlxPqmOU4";
    private static final String URL = "https://app.ticketmaster.com/discovery/v2/events.json";
    private static final String API_URL = "https://app.ticketmaster.com/discovery/v2/events" +
                                              ".json?apikey={apikey}&locale=*&publicVisibilityStartDateTime" +
                                              "={startDateTime}";
    private final EmailService emailService;
    
    private Set<String> processedEventIds = new HashSet<>();
    public String fetchEvents() {
        
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("apikey", API_KEY);
        String url = URL + "?apikey=" + API_KEY;
        
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        return response.getBody();
    }
    
    @Scheduled(fixedRate = 50000) // 180000 ms = 3 minutes
    public void checkForNewEvents() {
        RestTemplate restTemplate = new RestTemplate();
    
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        String startDateTime = now.minusMinutes(1).atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME) + ",*";
        String url = API_URL.replace("{apikey}", API_KEY)
                            .replace("{startDateTime}", startDateTime);
    
        PageableDTO<EventDTO> events = restTemplate.getForObject(url, PageableDTO.class);
        if(events.get_embedded() != null) {
            for (EventDTO event : events.get_embedded().getEvents()) {
                if (!processedEventIds.contains(event.getId())) {
                    // This is a new event.
                    try {
                        emailService.sendEventNotification(event); // you need to inject EmailService and call the method we created in the previous step.
                        processedEventIds.add(event.getId());
                        log.info("Notification sent for event: " + event);
                    } catch (MessagingException e) {
                        log.error("Error while sending email notification for event id: " + event.getId(), e);
                    }
                } else {
                    log.debug("Notification already sent for event: " + event);
                }
            }
        } else
            log.info("No new events as of : " + startDateTime);
    }

}
