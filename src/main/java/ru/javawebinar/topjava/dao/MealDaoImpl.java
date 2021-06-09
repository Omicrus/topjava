package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDaoImpl implements MealDao {
    private AtomicInteger id = new AtomicInteger();
    private final int CALORIES_PER_DAY = 2000;
    private CopyOnWriteArrayList<Meal> meals;
    {
        meals = new CopyOnWriteArrayList<>(Arrays.asList(
                new Meal(id.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)));
    }

    public MealDaoImpl() {
    }

    public int getCaloriesPerDay() {
        return CALORIES_PER_DAY;
    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }

    @Override
    public Meal getById(int id) {
        return meals.stream().filter(meal -> meal.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addMeal(Meal meal) {
        meal.setId(id.incrementAndGet());
        meals.add(meal);

    }

    @Override
    public void deleteById(int id) {
        meals.removeIf(meal -> meal.getId() == id);
    }

    @Override
    public void update(Meal meal) {
        deleteById(meal.getId());
        meals.add(meal);
    }
}
