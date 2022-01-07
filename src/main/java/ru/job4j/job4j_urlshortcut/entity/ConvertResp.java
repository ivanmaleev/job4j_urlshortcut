package ru.job4j.job4j_urlshortcut.entity;

import lombok.Getter;

@Getter
public class ConvertResp {
    private String code;

    public ConvertResp(String code) {
        this.code = code;
    }
}
