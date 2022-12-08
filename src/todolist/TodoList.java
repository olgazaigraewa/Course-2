package todolist;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;
@Getter
@Setter
public class TodoList  {
    private final  Map<Integer, Task > tasks = new HashMap<>();

    // добавить задачу
    public  void addTask (Task task){
        this.tasks.put(task.getId(), task);
    }
    //получить список задач
    public Collection<Task>getAllTasks() {
        return this.tasks.values();
    }
    //получить список задач на дату
    public Collection<Task>geTasksForDate(LocalDate date) {
         Set<Task> tasksForDate = new HashSet<>();
         for (Task task:tasks.values()){
             if (task.appearsIn(date)){
                 tasksForDate.add(task);
             }
         }

        return tasksForDate;
    }
    // удалить задачу
    public  void removeTask ( int id) throws TaskNotFoundException {
        if (this.tasks.containsKey(id)){
            this.tasks.remove(id);
        }else {
            throw new TaskNotFoundException();
        }
    }

    public static class TaskNotFoundException extends Exception {
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список дел - ").append("\n");
        for (Task task : tasks.values()) {
            stringBuilder.append(task).append("\n");
        }
        return stringBuilder.toString();
    }
}


