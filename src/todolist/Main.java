package todolist;

import java.util.Scanner;

public class Main {

    private static boolean dueDate;


    public static void main(String[] args) {

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    printMenu();
                    if (scanner.hasNextInt()) {
                        int menu = scanner.nextInt();
                        switch (menu) {
                            case 1 -> System.out.println(TaskService.addTask()); //"Создать";
                            case 2 -> System.out.println(TaskService.seeTask()); //"Показать список дел"
                            case 3 -> System.out.println(TaskService.editTask()); // Редактировать
                            case 4 -> System.out.println(TaskService.removeTask());// Удалить
                            default -> System.out.println("Сохранить и выйти");
                        }
                    } else {
                        scanner.next();
                        System.out.println("Выберите пункт меню из списка!");
                    }
                }
            }
        }



    private static void inputTask(Scanner scanner) {
            System.out.print("Введите название задачи: ");
            String taskName = scanner.next();
            // todo
        }

        private static void printMenu() {
        System.out.println("""
                Добрый день!\s
                Вы находитесь в меню планирования задач.\s
                Меню планирования задач:\s
                Если Вы хотите создать новую задачу, нажмите: 1\s
                Если Вы хотите посмотреть список задач, нажмите: 2\s
                Если Вы хотите редактировать задачу, нажмите: 3\s
                Если Вы хотите удалить задачу, нажмите: 4\s
                """);

        }

    }




