package todolist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static final TodoList TODO_LIST = new TodoList();
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH.mm");


    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.println("Введите пункт меню:");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask(scanner);
                            break;
                        case 2:
                            printTaskForDate(scanner);
                            break;
                        case 3:
                            removeTasks(scanner);
                        case 0:
                            break label;

                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                Добрый день!\s
                Вы находитесь в меню планирования задач.\s
                Меню планирования задач:\s
                Если Вы хотите создать новую задачу, нажмите: 1\s
                Если Вы хотите посмотреть список задач, нажмите: 2\s
                Если Вы хотите удалить задачу, нажмите: 3\s
                Сохранить и выйти: 0\s
                """);

    }

    private static void addTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();
        System.out.println("Введите содержание задачи: ");
        String taskContent = scanner.nextLine();
        TypeTask typeTask = readType(scanner);
        LocalDate taskDate = readDate(scanner);
        RepeatTask repeatTask = readRepeatTask(scanner);
        Task task = switch (repeatTask) {
            case SINGLE -> new SinglTask(title, typeTask, taskContent, taskDate.atStartOfDay());
            case EVERYDAY -> new EverydayTask(title, typeTask, taskContent, taskDate.atStartOfDay());
            case WEEKLY -> new WeeklyTask(title, typeTask, taskContent, taskDate.atStartOfDay());
            case MONTHLY -> new MonthlyTask(title, typeTask, taskContent, taskDate.atStartOfDay());
            case YEARLY -> new YearlyTask(title, typeTask, taskContent, taskDate.atStartOfDay());

        };
        TODO_LIST.addTask(task);

    }

    private static LocalDate readDate(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите дату в формате dd.MM.yyyy: ");
                String dateLine = scanner.nextLine();
                return LocalDate.parse(dateLine, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Введена дата в неверном формате ");
            }
        }

    }

    private static TypeTask readType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Выберите тип задачи: ");
                for (TypeTask typeTask : TypeTask.values()) {
                    System.out.println(typeTask.ordinal() + " , " + localizeType(typeTask));
                }
                System.out.print("Введите тип задачи: ");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return TypeTask.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Введен неверный тип задачи ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип задачи не неайден ");
            }
        }
    }

    private static String localizeType(TypeTask typeTask) {
        return switch (typeTask) {
            case WORK -> " Рабочая задача ";
            case PERSONAL -> "Личная задача ";

        };
    }

    private static String localizeRepeatabilityTask(RepeatTask repeatTask) {
        return switch (repeatTask) {
            case SINGLE -> "Единичная задача";
            case EVERYDAY -> "Ежедневная задача";
            case WEEKLY -> "Еженедельная задача";
            case MONTHLY -> "Ежемесячная задача";
            case YEARLY -> "Ежегодная задача";

        };
    }

    private static RepeatTask readRepeatTask(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Выберите тип повторяемости: ");
                for (RepeatTask repeatTask : RepeatTask.values()) {
                    System.out.println(repeatTask.ordinal() + " , " + localizeRepeatabilityTask(repeatTask));
                }
                System.out.println("Введите тип повторяемости задачи: ");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return RepeatTask.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Введен неверный тип повторяемости задачи ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип повторяемости не найден ");
            }
        }

    }

    public static void printTaskForDate(Scanner scanner) {
        LocalDate localDate = readDate(scanner);
        Collection<Task> tasksForDate = TODO_LIST.geTasksForDate(localDate);
        System.out.println("Задачи на " + localDate.format(DATE_FORMAT));
        for (Task task : tasksForDate) {
            System.out.printf("[%s]%s: %s (%s)%n", localizeType(task.getTypeTask()), task.getTitle(),
                    task.getTaskContent(), task.getTaskDateTime().format(TIME_FORMAT));
        }

    }

    public static void removeTasks(Scanner scanner) {
        System.out.println("Показать все задачи: ");
        for (Task task : TODO_LIST.getAllTasks()) {
            System.out.printf("%d. %s [%s](%s)%n", task.getId(), task.getTitle(), localizeType(task.getTypeTask()),
                    localizeRepeatabilityTask(task.getRepeatabilityType()));
        }
        while (true) {
            try {
                System.out.println("Выбрать задачу для удаления: ");
                String idLine = scanner.nextLine();
                int id = Integer.parseInt(idLine);
                TODO_LIST.removeTask(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введен неверный id задачи ");
            } catch (TodoList.TaskNotFoundException e) {
                System.out.println("Задача для удаления не найдена ");
            }
        }

    }


}




