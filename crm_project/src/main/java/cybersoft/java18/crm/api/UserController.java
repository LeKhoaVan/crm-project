package cybersoft.java18.crm.api;

import com.google.gson.Gson;
import cybersoft.java18.crm.model.UserModel;
import cybersoft.java18.crm.service.UserService;
import cybersoft.java18.crm.utils.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "user", urlPatterns = {
        UrlUtils.URL_USER
})
public class UserController extends HttpServlet {
    Gson gson = new Gson();
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = UserService.getInstanceUser();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<UserModel> listUser = userService.findAllUser();
        String json = gson.toJson(listUser);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json);
        printWriter.flush();
        ;
    }
}
