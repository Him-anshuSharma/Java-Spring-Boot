package project;

class Task {
    private static int _id = 0;
    private int id;
    private String title;
    private String description;
    private String dueDateTime;
    private Priority priority;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(String dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    Task(String title, String description, String dueDateTime, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDateTime = dueDateTime;
        this.priority = priority;
        this.status = Status.NOT_STARTED;
        id = _id++;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nDue Date: " + dueDateTime + "\nPriority: "
                + priority + "\nStatus: " + status;
    }

}

enum Priority {
    LOW, MEDIUM, HIGH
}

enum Status {
    NOT_STARTED, IN_PROGRESS, DONE
}