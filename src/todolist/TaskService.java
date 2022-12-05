package todolist;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
public class TaskService extends Task {


    public static LocalDate now;

    public TaskService(int id, String title, boolean type, String taskContent, LocalDate dueDate, Date now) {
        super(id, title, type, taskContent, dueDate);
    }

    public static boolean addTask() {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("Введите тип задачи: личная/рабочая ");
        String type = scanner.nextLine();
        System.out.println("Введите заголовок задачи ");
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи ");
        String taskContent = scanner.nextLine();
        System.out.println("Введите дату выполнения");
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate.now(): " + localDate); // 2022-12-05
        System.out.println("Периодичность задачи");
        String repeatability = scanner.nextLine();

        return false;
    }



    //TaskService.seeTask();смотреть список задач по дате / по проекту
    public static boolean seeTask() {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerLine = new Scanner(System.in);
        System.out.println("\n Отображать все задачи ");
        System.out.println("=====================\n ");
        System.out.println("Выберите вариант - ");
        System.out.println(" (1) Показать список задач по дате ");
        System.out.println(" (2) Показать список задач по проекту ");
        System.out.println(" \n Укажите свой выбор [1-2]: ");
        return true;
    }

    // TaskService.editTask(); радактировать( изменить, отменить, удалить)
    public static boolean editTask() {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        System.out.println(" Введите номер задачи для редактирования ");
        int id = scanner.nextInt();
        System.out.println("\n Параметры редактирования задачи ");
        System.out.println("=====================\n");
        System.out.println("Выберите вариант - ");
        System.out.println("(1)Изменить выбранную задачу ");
        System.out.println("(2)Отменить выбранную задачу ");
        System.out.println("(3)Удалить выбранную задачу ");
        System.out.println("(4)Вернуться в главное меню ");
        System.out.println(" \n Укажите свой выбор [1-4]: ");
        return true;
    }


    // TaskService.removeTask();удалить задачу по id
    public static boolean removeTask() {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Введите номер задачи ");
        int id = scanner.nextInt();
        System.out.println("Удалите задачу");
        return true;
    }




}








