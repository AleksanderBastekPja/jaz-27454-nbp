package com.example.jaz27454nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class Jaz27454RestController {
    Jaz27454NbpService jaz27454NbpService;

    public Jaz27454RestController(Jaz27454NbpService jaz27454NbpService) {
        this.jaz27454NbpService = jaz27454NbpService;
    }

    @Operation(summary = "Get average currency rate from range of start and end date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200", description = "Currency average rate retrieved Successfully"),
            @ApiResponse(responseCode = "400", description = "Wrong data was passed or days amount limit exceeded.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Currency not found.", content = @Content)
    })
    @GetMapping("/currency/{code}")
    public ResponseEntity<Currency> getCurrency(@PathVariable("code") String code, @RequestBody DateRequest dateRequest) {
        return ResponseEntity.ok(jaz27454NbpService.getCurrency(code, dateRequest.getStartDate(), dateRequest.getEndDate()));
    }


}
