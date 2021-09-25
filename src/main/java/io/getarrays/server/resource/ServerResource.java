package io.getarrays.server.resource;

import io.getarrays.server.model.Response;
import io.getarrays.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
    private final ServerService serverService;

    public ResponseEntity<Response> getServers() {
        Response.builder()
                .timeStamp(now())
                .data(Map.of("servers", serverService.list()))
    }
}
