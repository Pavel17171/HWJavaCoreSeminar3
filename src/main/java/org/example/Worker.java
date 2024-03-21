package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Worker implements Comparable<Worker>{

    static int nextId = 1001;
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private String phoneNumber;
    private int salary;
    private LocalDate birthday;

    public Worker(String lastName, String firstName, String middleName,
                  String position, String phoneNumber, int salary,
                  LocalDate birthday) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        setBirthday(birthday);
        this.id = nextId++;
        //nextId++;

    }

    public Worker(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return this.birthday == null ?
                -1 :
                (int) this.birthday.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday == null || birthday.isAfter((LocalDate.now().minusYears(14)))) {
            System.out.println("This worker is too young");
        } else {
            this.birthday = birthday;
        }
    }


    /**
     * Постановка задачи рабочему
     * (в задаче присваивается id рабочего)
     * @param task задача
     */
    public void assign(Task task) {
        task.setWorkerId(getId());
    }


    @Override
    public String toString() {
        return "Worker: "
               + "id: " + id + ", "
               + lastName + " "
               + firstName + " "
               + middleName + ", "
               + "position: " + position
               + ", phone number: " + phoneNumber
               + ", salary: " + salary
               + ", age (of full years): " + getAge();
    }

    @Override
    public int compareTo(Worker o) {
        return this.getAge() - o.getAge();
    }

    /**
     * Сортировка рабочих по фамилии
     */
    public static Comparator<Worker> lastNameComparator = Comparator.comparing(Worker::getLastName);

}
