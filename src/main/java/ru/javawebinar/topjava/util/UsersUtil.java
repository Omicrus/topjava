package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(null, "Jhon", "email1@mail.ru", "22222",Role.USER),
            new User(null, "boris", "email1@mail.ru", "33333",Role.USER),
            new User(null, "Boris", "email1@mail.ru", "44444",Role.USER),
            new User(null, "Иван", "email1@mail.ru", "55555",Role.USER),
            new User(null, "иван", "amail1@mail.ru", "55555",Role.USER),
            new User(null, "Сергей", "email1@mail.ru", "66666",Role.USER)
    );

    public static List<User> filteredByName(Collection<User> users){

        return users.stream()
                .sorted(Comparator
                        .comparing(User::getName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(User::getEmail, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}
