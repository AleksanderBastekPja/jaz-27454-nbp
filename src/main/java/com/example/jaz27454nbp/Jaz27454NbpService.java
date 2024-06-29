package com.example.jaz27454nbp;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.util.Objects.requireNonNullElse;

@Service
public class Jaz27454NbpService {
    private final Jaz27454NbpRepository jaz27454NbpRepository;
    private final RestTemplate restTemplate;

    public Jaz27454NbpService(Jaz27454NbpRepository jaz27454NbpRepository, RestTemplate restTemplate) {
        this.jaz27454NbpRepository = jaz27454NbpRepository;
        this.restTemplate = restTemplate;
    }


    public Currency getAverageLastDaysRate(String currency, Instant startDate, Instant endDate) {
        Duration duration = Duration.between(startDate, endDate);
        Long days = duration.toDays();

        CurrencyNBP lastDaysRates = restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/rates/A/" + currency + "/" + startDate.toString().split("T")[0] + "/" + endDate.toString().split("T")[0] + "?format=json", CurrencyNBP.class);
        Double averageRate = lastDaysRates.getRates().stream().map(Rate::getMid).reduce(0D, Double::sum) / days;

        return new Currency(null, currency, startDate, endDate, averageRate, Instant.now());
    }

    public Currency getCurrency(String currencyCode, Instant startDate, Instant endDate) {
        Currency currency = getAverageLastDaysRate(currencyCode, startDate, endDate);
        jaz27454NbpRepository.save(currency);
        return currency;
    }
}
