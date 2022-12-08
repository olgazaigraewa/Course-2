package todolist;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Task implements Repeatability {

    private final String title;

    int id;
    public static int idCounter = 0;
    private final TypeTask typeTask;
    private final String taskContent;

    private final LocalDateTime taskDateTime;

    public Task(String title, TypeTask typeTask, String taskContent, LocalDateTime taskDateTime) {
        this.title = title;
        this.id = idCounter++;
        this.typeTask = typeTask;

        this.taskContent = taskContent;
        this.taskDateTime = taskDateTime;
    }

    public String getTitle() {
        return title;
    }


    public int getId() {
        return id;
    }


    public TypeTask getTypeTask() {
        return typeTask;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }

    public abstract boolean appearsIn(LocalDate localDate);

    public abstract RepeatTask getRepeatabilityType();

    @Override
    public String toString() {
        return "Задача: номер " + id +
                ", заголовок " + title +
                ", тип задачи: личная/рабочая " + typeTask +
                ", содержание " + taskContent +
                ", дата выполнения " + taskDateTime;
    }


}
