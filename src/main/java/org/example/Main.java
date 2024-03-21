package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.example.Manager.addSalary;
import static org.example.Manager.addSalaryPercent;


public class Main {
    public static void main(String[] args) {

        // Создание рабочих
        Worker[] workers = {
                new Manager("Altukhov", "Artem",
                        "Andreevich", "manager",
                        "+7-901-000-00-01", 1_000_000,
                        LocalDate.of(1987, 5,15)),

                new Worker("Ivanov", "Ivan",
                        "Ivanovich", "developer",
                        "+7-999-999-99-99", 150_000,
                        LocalDate.of(1957, 2, 28)),

                new Worker("Petrov", "Petr",
                        "Petrovich", "manager",
                        "+7-947-156-48-88", 135_000,
                        LocalDate.of(1986,5,17)),

                new Worker("Sidorov", "Sidor",
                        "Sidorovich", "frontend",
                        "+7-960-258-64-82", 235_000,
                        LocalDate.of(1998,8,31)),

                new Worker("Kulebyakin", "Artemiy",
                        "Aksakovich", "designer",
                        "+7-974-155-64-46", 185_000,
                        LocalDate.of(1975,1,1)),

                new Worker("Mitrofanofa", "Nataliya",
                        "Biktorovna", "frontend",
                        "+7-942-612-12-32", 285_000,
                        LocalDate.of(2000,4,12)),

                new Worker("Yarkov", "Oleg",
                        "Igorevich", "fullstack",
                        "+7-953-654-78-98", 312_000,
                        LocalDate.of(1948,4,7)),

                new Manager("Cupriyanov", "Konstantin",
                        "Albertovich", "manager",
                        "+7-901-123-40-32", 310_000,
                        LocalDate.of(1977, 5,15)),

                new Worker("Yarkov", "Oleg",
                        "Igorevich", "fullstack",
                        "+7-953-654-78-98", 312_000,
                        LocalDate.of(1948,4,7)),

                new Worker("Pturova", "Anna",
                        "Alekseevna", "designer",
                        "+7-951-555-33-11", 200_035,
                        LocalDate.of(1997,6,29))

        };

        // Создание задач
        Task task1 = new Task("Header one", "Text of task one");
        Task task2 = new Task("Header two", "Text of task two");
        Task task3 = new Task(workers[3].getId(),"Header three", "Text of task three");
        Task task4 = new Task("Header four", "Text of task four");
        Task task5 = new Task("Header five", "Text of task five");

        // Вывод списка всех задач
        List<Task> tasks = Task.getAllTasks();
        Task.printAllTasks(tasks);

        System.out.println("\n" + "-".repeat(20) + "\n");

        // Присвоение задач
        workers[2].assign(task1);
        workers[5].assign(task2);
        workers[9].assign(task5);
        workers[0].assign(task4);
        workers[3].assign(task3);

        Task.printAllTasks(tasks);

        System.out.println("\n" + "-".repeat(20) + "\n");


        // Переприсвоение задач менеджером
        Manager m = (Manager) workers[0];
        m.assign(task1, workers[0]);

        Task.printAllTasks(tasks);

        System.out.println("\n" + "-".repeat(20) + "\n");


        // Работа со списком рабочих


        printWorkerArray(workers); // Исходный список

        System.out.println();

        System.out.println("Average age: " + getAverageAge(workers));
        System.out.println("Average salary: " + getAverageSalary(workers));

        // Повышение зарплаты на 15000
        addSalary(workers, 30, 15000);

        printWorkerArray(workers); // Список рабочих после повышения ЗП

        // Повышение зарплаты на 25%
        addSalaryPercent(workers, 30, 23);

        printWorkerArray(workers); // Список рабочих после повышения ЗП

        System.out.println("\n" + "-".repeat(20) + "\n");


        // Сортировка рабочих

        List<Worker> workerList = Arrays.asList(workers);

        // Сортировка по возрасту
        Collections.sort(workerList);

        printWorkerList(workerList); // Список рабочих после сортировки

        // Сортировка рабочих по зарплате
        workerList.sort(new WorkerSalaryComparator());

        System.out.println("\n" + "-".repeat(20) + "\n");

        // Сортировка по фамилии
        workerList.sort(Worker.lastNameComparator);

        printWorkerList(workerList);

    }


    /**
     * Средний возраст сотрудников
     * @param array массив сотрудников
     * @return средний возраст double (округление до десятых)
     */
    public static double getAverageAge (Worker[] array) {
        int sumAge = 0;
        for (Worker w : array) {
            sumAge += w.getAge();
        }
        return (Math.round((double) sumAge / array.length * 100.0) / 100.0);
    }

    /**
     * Средняя зарплата сотрудников
     * @param array массив сотрудников
     * @return средняя зарплата double (округление до десятых)
     */
    public static double getAverageSalary (Worker[] array) {
        int sumSalary = 0;
        for (Worker w : array) {
            sumSalary += w.getSalary();
        }
        return (Math.round((double) sumSalary / array.length * 100.0) / 100.0);
    }

    /**
     * Вывод Array рабочих
     * @param workers Array рабочих
     */
    public static void printWorkerArray(Worker[] workers) {
        for (Worker w : workers) {
            System.out.println(w);
        }
    }

    /**
     * Вывод List<Worker> рабочих
     * @param workers List рабочих
     */
    public static void printWorkerList(List<Worker> workers) {
        for (Worker w : workers) {
            System.out.println(w);
        }
    }


}