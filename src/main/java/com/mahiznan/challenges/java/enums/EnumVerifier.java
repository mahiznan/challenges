package com.mahiznan.challenges.java.enums;

enum WorkDay {
    MONDAY("09-06"),
    TUESDAY("09-06"),
    WEDNESDAY("09-06"),
    THURSDAY("09-06"),
    FRIDAY("09-06"), SATURDAY("10-01") {
        @Override
        public String getWorkingLocation() {
            return "Home";
        }
    };

    private final String workingHours;

    WorkDay(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public String getWorkingLocation() {
        return "Office";
    }
}


public class EnumVerifier {
    static void main() {
        WorkDay day = WorkDay.FRIDAY;
        System.out.println(day.getWorkingHours());
        System.out.println(day.getWorkingLocation());
        System.out.println(WorkDay.SATURDAY.getWorkingLocation());
        System.out.println(WorkDay.SATURDAY.getWorkingHours());
    }
}
