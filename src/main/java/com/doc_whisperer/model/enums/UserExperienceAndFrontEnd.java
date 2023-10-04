package com.doc_whisperer.model.enums;

public enum UserExperienceAndFrontEnd {

    RESPONSIVE_DESIGN("Responsive Design"),
    PROGRESSIVE_WEB_APPS("Progressive Web Apps (PWA)"),
    NATIVE_MOBILE_APPS("Native Mobile Apps"),
    CROSS_PLATFORM_DEVELOPMENT("Cross-Platform Development (e.g., React Native, Flutter)");

    private final String description;

    UserExperienceAndFrontEnd(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static UserExperienceAndFrontEnd fromDisplayName(String displayName) {
        for (UserExperienceAndFrontEnd value : UserExperienceAndFrontEnd.values()) {
            if (value.getDescription().equals(displayName)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown display name: " + displayName);
    }

    @Override
    public String toString() {
        return getDescription();
    }
}

