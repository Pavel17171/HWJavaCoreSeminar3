package org.example;

import java.time.LocalDate;

public class Manager extends Worker {
    final static int START_ID = 11;
    final static int FINISH_ID = 999;
    private static int nextIdMan = START_ID;


    public Manager(String lastName, String firstName, String middleName, String position, String phoneNumber, int salary, LocalDate birthday) {
        super(lastName, firstName, middleName, position, phoneNumber, salary, birthday);
        this.setId(nextIdMan++);

    }

    public Manager(String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
    }

    @Override
    public String toString() {
        return "Manager: "
               + "id: " + getId() + ", "
               + getLastName() + " "
               + getFirstName() + " "
               + getMiddleName() + ", "
               + "position: " + getPosition()
               + ", phone number: " + getPhoneNumber()
               + ", salary: " + getSalary()
               + ", age (of full years): " + getAge();
    }


    static void addSalary(Worker[] workers, int age, int addAmount) {
        for (Worker worker : workers) {
            if (worker.getId() > FINISH_ID && worker.getAge() >= age) {
                worker.setSalary(worker.getSalary() + addAmount);
                System.out.println(worker.getId());
            }
        }
        System.out.printf("\nПовышение зарплаты на %s ед. прошла успешно! \n\n", addAmount);
    }



    static void addSalaryPercent (Worker[] workers, int age, int addPercent) {
        for (Worker worker : workers) {
            if (worker.getId() > FINISH_ID && worker.getAge() >= age) {
                worker.setSalary(worker.getSalary() * (100 + addPercent) /100);
            }
        }
        System.out.printf("\nИндексация зарплаты на %s%% прошла успешно! \n\n", addPercent);
    }

    /**
     * Присвоение задачи рабочему или менеджеру
     * @param task задача
     * @param worker id рабочего
     */
    public void assign(Task task, Worker worker) {
        task.setWorkerId(worker.getId());
    }
}
