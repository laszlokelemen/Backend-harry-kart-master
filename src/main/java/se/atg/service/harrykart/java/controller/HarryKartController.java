package se.atg.service.harrykart.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.java.model.HarryKart;
import se.atg.service.harrykart.java.model.Rank;
import se.atg.service.harrykart.java.response.ResponseHandler;
import se.atg.service.harrykart.java.service.HarryKartService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/java/api")
public class HarryKartController {

    private final HarryKartService harryKartService;

    public HarryKartController(HarryKartService harryKartService) {
        this.harryKartService = harryKartService;
    }

    @PostMapping(path = "/play", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> playHarryKart(@Valid @RequestBody HarryKart harryKart) {
        List<Rank> ranks = harryKartService.play(harryKart);
        return ResponseHandler.generateResponse(ranks, HttpStatus.OK);
    }
}
