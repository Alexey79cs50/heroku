package com.generate.users.utils;

import com.generate.users.application.model.Gender;
import com.generate.users.application.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

@Getter
@Component
public class Generator {

    private int namesDiversity = 20;
    private int surnameDiversity = 10;
    private int minAge = 18;
    private int maxAge = 55;

    @Getter
    @Setter
    class Names {
        String name;
        Gender gender;
    }

    public User generateUser() {
        Names[] names = initNamesGenderSet();
        String[] surnames = initSurnamesSet();

        User user = new User();

        Names nameGender = names[getRnd(0, namesDiversity)];
        String name = nameGender.getName();
        String surname = surnames[getRnd(0, surnameDiversity)];
        String email = name + "." + surname + "@gmail.com";

        user.setFirstName(name);
        user.setLastName(surname);
        user.setGender(nameGender.getGender());
        user.setEmail(email);
        user.setAge(getRnd(minAge, maxAge));
        return user;
    }

    private int getRnd(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private Names[] initNamesGenderSet() {
        Names[] names = new Names[40];
        int i = 0;
        Scanner scanner = getFile("dict/names.txt.");
        while (scanner.hasNextLine()) {
            Names nameGender = new Names();
            String[] lineContent = scanner.nextLine().split(",");
            Gender gender = lineContent[1].equals("M") ? Gender.MALE : Gender.FEMALE;
            nameGender.setName(lineContent[0]);
            nameGender.setGender(gender);
            names[i++] = nameGender;
        }
        return names;
    }

    private String[] initSurnamesSet() {
        String[] surnames = new String[20];
        int i = 0;
        Scanner scanner = getFile("dict/surnames.txt.");
        while (scanner.hasNextLine()) {
            surnames[i++] = scanner.nextLine();
        }
        return surnames;
    }

    private Scanner getFile(String path) {
        Scanner scanner = null;
        try {
            File file = ResourceUtils.getFile("classpath:" + path);
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }

    public void setNamesDiversity(int namesDiversity) {
        if (namesDiversity > 40) {
            namesDiversity = 40;
        }
        this.namesDiversity = namesDiversity;
    }

    public void setSurnameDiversity(int surnameDiversity) {
        if (surnameDiversity > 20) {
            surnameDiversity = 20;
        }
        this.surnameDiversity = surnameDiversity;
    }

    public void setMinAge(int minAge) {
        if (minAge > maxAge) {
            minAge = maxAge;
        }
        this.minAge = minAge;
    }

    public void setMaxAge(int maxAge) {
        if (maxAge > 60) {
            maxAge = 60;
        }
        this.maxAge = maxAge;
    }
}
