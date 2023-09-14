package com.anya.crudapp.view;

import com.anya.crudapp.controller.DeveloperController;
import com.anya.crudapp.model.Developer;

import java.util.Scanner;

public class DeveloperView {
    Scanner scanner = new Scanner(System.in);
    private final String DEV_NAME = "Введите имя";
    private final String DEV_SURNAME = "Введите фамилию";
    private final String DEV_ID = "Введите ID";
    private final String DEV_SKILLS = "Введите навыки через пробел";
    private final String DEV_SPEC = "Введите специализацию";

    DeveloperController developerController = new DeveloperController();

    public void getDeveloperById() {
        System.out.println(DEV_ID);
        int id = scanner.nextInt();
        developerController.getDeveloperById(id);
    }

    public void createDeveloper() {
        System.out.println(DEV_NAME);
        String name = scanner.nextLine();
        System.out.println(DEV_SURNAME);
        String surname = scanner.nextLine();
        System.out.println(DEV_SKILLS);
        String skills = scanner.nextLine();
        System.out.println(DEV_SPEC);
        String specialty = scanner.nextLine();
        developerController.saveDeveloper(name, surname, skills, specialty);
    }

    public void deleteDeveloper() {
        System.out.println(DEV_ID);
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(DEV_NAME);
        String name = scanner.nextLine();
        System.out.println(DEV_SURNAME);
        String surname = scanner.nextLine();
        System.out.println(DEV_SKILLS);
        String skills = scanner.nextLine();
        System.out.println(DEV_SPEC);
        String specialty = scanner.nextLine();
        developerController.deleteDeveloper(id, name, surname, skills, specialty);
        System.out.println("Элемент удален");

    }

    public void updateDeveloper() {
        System.out.println(DEV_ID);
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(DEV_NAME);
        String name = scanner.nextLine();
        System.out.println(DEV_SURNAME);
        String surname = scanner.nextLine();
        System.out.println(DEV_SKILLS);
        String skills = scanner.nextLine();
        System.out.println(DEV_SPEC);
        String specialty = scanner.nextLine();
        developerController.updateDeveloper(id, name, surname, skills, specialty);
    }
}
