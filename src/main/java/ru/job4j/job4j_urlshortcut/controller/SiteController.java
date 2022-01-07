package ru.job4j.job4j_urlshortcut.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_urlshortcut.entity.SiteReg;
import ru.job4j.job4j_urlshortcut.entity.SiteRegResp;
import ru.job4j.job4j_urlshortcut.service.impl.SiteServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/sites")
public class SiteController {

    private static final Logger LOGGER = LoggerFactory.
            getLogger(SiteController.class.getSimpleName());

    private SiteServiceImpl siteService;
    private final ObjectMapper objectMapper;

    @Autowired
    public SiteController(SiteServiceImpl siteService, ObjectMapper objectMapper) {
        this.siteService = siteService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<SiteRegResp> registration(@RequestBody SiteReg siteReg) throws IllegalArgumentException {
        SiteRegResp response = this.siteService.register(siteReg.getSite());
        return new ResponseEntity<>(response,
                HttpStatus.CREATED
        );
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public void exceptionHandler(Exception e, HttpServletRequest request,
                                 HttpServletResponse response)
            throws IOException {
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {
            {
                put("message", e.getMessage());
                put("type", e.getClass());
            }
        }));
        LOGGER.error(e.getLocalizedMessage());
    }
}
