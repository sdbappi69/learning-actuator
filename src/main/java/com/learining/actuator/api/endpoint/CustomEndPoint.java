package com.learining.actuator.api.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "release-notes")
public class CustomEndPoint {
    Map<String, List<String>> releaseNotes = new LinkedHashMap<>();
    @PostConstruct
    public void init() {
        releaseNotes.put("1.0.0", List.of("First Release", "Bug fixing"));
        releaseNotes.put("1.0.1", List.of("Second Release"));
        releaseNotes.put("1.0.2", List.of("Third Release"));
    }
    @ReadOperation
    public Map<String, List<String>> getReleaseNotes() {
        return releaseNotes;
    }
    @ReadOperation
    public List<String> getReleaseNotesByVersion(@Selector String version) {
        return releaseNotes.get(version);
    }
    @WriteOperation
    public void addReleaseNotes(@Selector String version, String notes) {
        releaseNotes.put(version, Arrays.stream(notes.split(",")).collect(Collectors.toList()));
    }
    @DeleteOperation
    public void deleteReleaseNotes(@Selector String version) {
        releaseNotes.remove(version);
    }
}
