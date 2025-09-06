package project;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class TaskManager {
    private List<Task> tasks;

    TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> viewAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> searchTask(String keyword) {
        final String _keyword = keyword;
        List<Task> matches = tasks.stream()
                .filter(t -> t.getTitle().contains(_keyword) || t.getDescription().contains(_keyword))
                .collect(Collectors.toList());
        return matches;
    }

    private int getIndexByTaskId(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public void deleteTask(int id) {
        int index = getIndexByTaskId(id);
        if (index != -1)
            tasks.remove(index);
    }

    public void updateTask(int id, Task task) {
        int index = getIndexByTaskId(id);
        tasks.set(index, task);
    }

    public List<Task> filterTasks(Predicate<Task> filter) {
        List<Task> filteredTasks = tasks.stream().filter(filter).collect(Collectors.toList());
        return filteredTasks;
    }

}
