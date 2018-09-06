package servlets;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.dao.impl.ProblemDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.dto.TaskDto;
import itacademy.services.SystemUserServiceImpl;
import itacademy.services.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPage")
public class AdminPageController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminPage.jsp").forward(req, resp);
//        resp.sendRedirect("/adminPage");
    }
}


