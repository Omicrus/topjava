package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealDaoImpl implements MealDao {
    private final int CALORIES_PER_DAY = 2000;
    private List<Meal> meals;
    {
        meals = new ArrayList<>(Arrays.asList(
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)));
    }

    public MealDaoImpl() {
    }

    @Override
    public List<Meal> getAllMeals() {
        return meals;
    }

    @Override
    public Meal getMeal(int id) {
        return null;
    }

    @Override
    public void updateMeal(Meal meal) {

    }

    @Override
    public void deleteMeal(Meal meal) {

    }


    public int getCaloriesPerDay() {
        return CALORIES_PER_DAY;
    }
}
