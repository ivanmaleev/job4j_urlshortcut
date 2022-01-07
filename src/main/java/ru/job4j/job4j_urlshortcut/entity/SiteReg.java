package ru.job4j.job4j_urlshortcut.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SiteReg {
    @NotBlank(message = "Site name must be not empty")
    private String site;
}
