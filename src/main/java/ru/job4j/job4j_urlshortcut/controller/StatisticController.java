package ru.job4j.job4j_urlshortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.job4j_urlshortcut.entity.LinkCounterResp;
import ru.job4j.job4j_urlshortcut.service.LinkCounterService;

import java.util.Collection;

@Controller
@RequestMapping("/statistic")
@AllArgsConstructor
public class StatisticController {

    private LinkCounterService linkCounterService;

    @GetMapping("/")
    public ResponseEntity<Collection<LinkCounterResp>> findAll() {
        return new ResponseEntity<>(
                linkCounterService.findAll(),
                HttpStatus.OK
        );
    }
}
