package com.example.jaz27454nbp;

import jakarta.annotation.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZonedDateTime;

@RestController
@RequestMapping
public class Jaz27454RestController {
    Jaz27454NbpService jaz27454NbpService;

    public Jaz27454RestController(Jaz27454NbpService jaz27454NbpService) {
        this.jaz27454NbpService = jaz27454NbpService;
    }

    @GetMapping("/currency/{code}")
    public ResponseEntity<Currency> getCurrency(@PathVariable("code") String code, @RequestBody DateRequest dateRequest) {
//        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
//        Instant instant = zonedDateTime.toInstant();
        return ResponseEntity.ok(jaz27454NbpService.getAverageLastDaysRate(code, dateRequest.getStartDate(), dateRequest.getEndDate()));
    }


}
