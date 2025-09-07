package project.jdbc.database.models;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDateTime dueDateTime;
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

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
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

    public Task(String title, String description, LocalDateTime dueDateTime, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDateTime = dueDateTime;
        this.priority = priority;
        this.status = Status.NOT_STARTED;
    }

    public Task(int id, String title, String description, LocalDateTime dueDateTime, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDateTime = dueDateTime;
        this.priority = priority;
        this.status = Status.NOT_STARTED;
    }

    public Task(int id, String title, String description, LocalDateTime dueDateTime, Priority priority, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDateTime = dueDateTime;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n\nTitle: " + title + "\nDescription: " + description + "\nDue Date: " + dueDateTime + "\nPriority: "
                + priority + "\nStatus: " + status + "\n\n";
    }

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public enum Status {
        NOT_STARTED, IN_PROGRESS, DONE
    }

}
