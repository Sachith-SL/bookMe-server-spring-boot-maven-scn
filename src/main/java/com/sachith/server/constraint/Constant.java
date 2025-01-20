package com.sachith.server.constraint;

public class Constant {

    public enum UserRole {
        ADMIN("ADMIN"),
        CUSTOMER("CUSTOMER");

        private final String value;

        UserRole(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    public enum ReservationStatus {
        PENDING("PENDING"),
        CONFIRMED("CONFIRMED"),
        IN_PROGRESS("IN_PROGRESS"),
        COMPLETED("COMPLETED"),
        CANCELED("CANCELED"),
        UNKNOWN("UNKNOWN");

        private final String value;

        ReservationStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum ResponseStatus {
        SUCCESS("SUCCESS"),
        ERROR("ERROR");

        private final String value;

        ResponseStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
}
