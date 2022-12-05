package todolist;

import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
public abstract class Task {

    private String title;
    private boolean project;
    int id;
    public static int idCounter = 0;
    private boolean type;
    String taskContent;
    private final LocalDate dateCreate = LocalDate.now();
    private LocalDate dueDate;


    public Task(int id, String title, boolean type, String taskContent, LocalDate dueDate) {
        if (title == null || title.isEmpty() || title.isBlank())
            throw new IllegalArgumentException("Напишите заголовок!");
        this.title = title;
        this.project = false;
        this.id = idCounter++;
        this.type = false;
        if (taskContent == null || taskContent.isEmpty() || taskContent.isBlank())
            throw new IllegalArgumentException("Напишите,  что Вы хотите сделать");
        this.taskContent = taskContent;
        this.dueDate = dueDate;
    }

    public boolean finishTheProject() {
        return true;
    }

    public boolean notFinishTheProject() {
        return false;
    }

    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        if (dueDate.compareTo(LocalDate.now()) < 0) {
            throw new DateTimeException("Прошедшая дата исключается");


        }
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Задача: номер " + id +
                ", заголовок " + title +
                ", тип задачи: личная/рабочая " + type +
                ", содержание " + taskContent +
                " , статус " + (project ? "Завершено" : "Не завершено") +
                ", дата создания" + dateCreate +
                ", дата выполнения " + dueDate;
    }


}
