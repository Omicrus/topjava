package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealDao {
    public List<Meal> getAll();
    public int getCaloriesPerDay();
    public Meal getById(int id);
    public void addMeal(Meal meal);
    public void deleteById(int id);
    public void update(Meal meal);

}
