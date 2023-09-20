package com.anya.crudapp.view;

import com.anya.crudapp.controller.SpecialtyController;
import com.anya.crudapp.model.Specialty;

import java.util.Scanner;

public class SpecialtyView {
    SpecialtyController specialtyController = new SpecialtyController();

    Scanner scanner = new Scanner(System.in);
    private final String SPEC_NAME = "Введите название специалиности";
    private final String SPEC_ID = "Введите ID";

    public void getSpecialty() {
        System.out.println(SPEC_ID);
        int id = scanner.nextInt();
        Specialty specialty = specialtyController.getSpecialtyById(id);
        System.out.println(specialty);
    }

    public void createSpecialty() {
        System.out.println(SPEC_NAME);
        String name = scanner.nextLine();
        Specialty specialty = specialtyController.saveSpecialty(name);
        System.out.println("Запись создана: " + specialty);
    }

    public void changeSpecialty() {
        System.out.println(SPEC_ID);
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(SPEC_NAME);
        String name = scanner.nextLine();
        System.out.println("Запись изменена: \n" + specialtyController.updateSpecialty(id, name));
    }

    public void deleteSpecialty() {
        System.out.println(SPEC_ID);
        int id = scanner.nextInt();
        specialtyController.deleteSpecialty(id);
        System.out.println("Элемент удален");
    }

    public void getAll() {
        System.out.println("Список всех специальностей: ");
        System.out.println(specialtyController.getAll());
    }
}
