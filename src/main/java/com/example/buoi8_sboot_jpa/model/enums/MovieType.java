package com.example.buoi8_sboot_jpa.model.enums;

import lombok.Getter;

@Getter
public enum MovieType {
    PHIM_LE("phim le"),
    PHIM_BO("Phim bo"),
    PHIM_CHIEU_RAP("Phim chieu rap");

    private final String value;
    MovieType(String value){
        this.value=value;
    }



}
