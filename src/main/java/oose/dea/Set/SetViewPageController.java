package oose.dea.Set;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Singleton
@WebServlet(urlPatterns = "/sets")
public class SetViewPageController extends HttpServlet {
    @Inject
    SetModel setModel;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String owner = (String) request.getSession().getValue("owner");

        ArrayList<Set> sets = setModel.getAllSets(owner);
        request.setAttribute("sets", sets);
        request.getRequestDispatcher("Set/SetView/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String owner = (String) request.getSession().getValue("owner");

        switch (request.getParameter("action")) {

            case "manage":
                int setId = Integer.parseInt(request.getParameter("setId"));
                request.getSession().setAttribute("setId", setId);

                String setName = request.getParameter("setName");
                request.getSession().setAttribute("setName", setName);

                break;

            case "insert":
                setModel.insertSet(request.getParameter("name"), owner);
                break;

        }


        ArrayList<Set> sets = setModel.getAllSets(owner);
        request.setAttribute("sets", sets);
        request.getRequestDispatcher("Set/SetView/show.jsp").forward(request, response);

    }
}
