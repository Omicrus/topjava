package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);
    private static final String INSERT_OR_EDIT = "/meal.jsp";
    private static final String LIST_USER = "/meals.jsp";
    private final MealDao mealDao;

    public MealServlet() {
        super();
        mealDao = new MealDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        log.debug("redirect to meals");

        String pathJsp;

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("mealId"));
            mealDao.deleteById(id);
            pathJsp = LIST_USER;
            request.setAttribute("mealsTo", getMealTos());
        } else if (action.equalsIgnoreCase("update")) {
            pathJsp = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("mealId"));

            Meal meal = mealDao.getById(id);
            request.setAttribute("meal", meal);

        } else if (action.equalsIgnoreCase("listMeal")) {
            pathJsp = LIST_USER;
            request.setAttribute("mealsTo", getMealTos());
        } else {
            pathJsp = INSERT_OR_EDIT;
        }

        request.getRequestDispatcher(pathJsp).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"), formatter);

        String description = request.getParameter("description");
        int calories = Integer.parseInt(request.getParameter("calories"));

        String id = request.getParameter("mealId");

        if (id == null || id.isEmpty()) {
            mealDao.addMeal(new Meal(0, dateTime, description, calories));
        } else {
            mealDao.update(new Meal(Integer.parseInt(id), dateTime, description, calories));
        }

        request.setAttribute("mealsTo", getMealTos());
        request.getRequestDispatcher(LIST_USER).forward(request, response);
    }

    private List<MealTo> getMealTos() {
        return MealsUtil.filteredByStreams(mealDao.getAll(), LocalTime.MIN, LocalTime.MAX, mealDao.getCaloriesPerDay());
    }
}
