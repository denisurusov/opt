package data.model;

public enum Unit {
    DAYS("Days", "Work (billable) days"),
    Hours("Hours", "Work (billable) hours"),
    MTP("Manual touches", "Smallest measurable manual action taken towards request completion"),
    DOLLARS("Dollar amount", "Dollar amount"),
    PEOPLE("Headcount", "Number of people producing work");
    //
    private String name;
    private String description;

    //
    Unit(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
