package com.bokaromart.rawnews.pojo.enums;

public enum NewsCategory {
    TOP_STORIES,
    MOST_RECENT_STORIES,
    INDIA,
    WORLD,
    NRI,
    BUSINESS,
    CRICKET,
    SPORTS,
    HEALTH,
    SCIENCE,
    ENVIRONMENT,
    TECHNOLOGY,
    EDUCATION,
    ENTERTAINMENT,
    LIFE_STYLE;

    private final int numVal;

    NewsCategory() {
        this.numVal = ordinal();
    }

}
