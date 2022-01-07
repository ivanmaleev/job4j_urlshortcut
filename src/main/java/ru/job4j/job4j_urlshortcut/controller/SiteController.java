package ru.job4j.job4j_urlshortcut.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_urlshortcut.entity.SiteReg;
import ru.job4j.job4j_urlshortcut.entity.SiteRegResp;
import ru.job4j.job4j_urlshortcut.service.SiteService;

import javax.validation.Valid;

@RestController
@RequestMapping("/sites")
@AllArgsConstructor
public class SiteController {

    private SiteService siteService;

    @PostMapping("/registration")
    public ResponseEntity<SiteRegResp> registration(@RequestBody @Valid SiteReg siteReg) throws IllegalArgumentException {
        SiteRegResp response = this.siteService.register(siteReg.getSite());
        return new ResponseEntity<>(response,
                HttpStatus.CREATED
        );
    }
}
