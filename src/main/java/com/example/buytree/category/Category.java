package com.example.buytree.category;

import com.example.buytree.offer.NoCategoryException;

import java.util.Arrays;

public enum Category {
    ELECTRONICS("Elektronika"),
    AGD("Agd"),
    MOTO("Moto");

    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public static Category findByDisplayName(String displayName) {
        return Arrays.stream(values())
                .filter(category -> category.getDisplayName().equals(displayName))
                .findFirst()
                .orElseThrow(() ->new NoCategoryException("Brak kategorii o nazwie: " + displayName));

    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
