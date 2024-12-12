package servlet;
import java.io.IOException;
import java.util.List;

import dao.BasicSettingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.JobType;

@WebServlet("/JobTypeServlet")
public class JobTypeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JobType> jobTypes = BasicSettingDAO.getJobTypes();
        request.setAttribute("jobTypes", jobTypes);
        request.getRequestDispatcher("/jobTypeForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jobName = request.getParameter("jobName");
        BasicSettingDAO.addJobType(jobName);

        response.sendRedirect("basicSetting.jsp");
    }
}
