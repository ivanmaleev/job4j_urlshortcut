package ru.job4j.job4j_urlshortcut.entity;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UrlReq {
    @NotBlank
    private String url;
}
