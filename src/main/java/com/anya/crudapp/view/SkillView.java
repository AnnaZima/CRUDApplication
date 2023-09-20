package com.anya.crudapp.view;

import com.anya.crudapp.controller.SkillController;
import com.anya.crudapp.model.Skill;

import java.util.Scanner;

public class SkillView {
    SkillController skillController = new SkillController();

    Scanner scanner = new Scanner(System.in);
    private final String SKILL_NAME = "Введите название умения";
    private final String SKILL_ID = "Введите ID";

    public void getSkillById() {
        System.out.println(SKILL_ID);
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(skillController.getSkillById(id));
    }

    public void createSkill() {
        System.out.println(SKILL_NAME);
        String name = scanner.nextLine();
        Skill skill = skillController.saveSkill(name);
        System.out.println("Запись создана: " + skill);
    }

    public void updateSkill() {
        System.out.println(SKILL_ID);
        int id = scanner.nextInt();
        scanner.skip("\n");
        System.out.println(SKILL_NAME);
        String name = scanner.nextLine();
        System.out.println(skillController.updateSkill(id, name));
    }

    public void deleteSkill() {
        System.out.println(SKILL_ID);
        int id = scanner.nextInt();
        skillController.deleteSkill(id);
        System.out.println("Элемент удален");
    }

    public void getAll() {
        System.out.println("Список всех умений: ");
        System.out.println(skillController.getAll());
    }

}