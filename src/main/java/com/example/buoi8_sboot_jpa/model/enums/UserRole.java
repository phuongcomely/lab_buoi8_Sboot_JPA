package com.example.buoi8_sboot_jpa.model.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("user"),
    ADMIN("admin");
    private final String value;
    UserRole(String value){
        this.value=value;
    }


    }
