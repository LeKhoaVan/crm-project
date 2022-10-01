package cybersoft.java18.crm.api;

import com.google.gson.Gson;
import cybersoft.java18.crm.model.ReponseData;
import cybersoft.java18.crm.model.RoleModel;
import cybersoft.java18.crm.service.RoleService;
import cybersoft.java18.crm.utils.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "role", urlPatterns = {
        UrlUtils.URL_ROLE
})
public class RoleController extends HttpServlet {
    Gson gson = new Gson();
    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        super.init();
        roleService = RoleService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        List<RoleModel> roleModelList = roleService.getAllRole();
        String json = gson.toJson(roleModelList);  // chuyển sang json
        //resp.addHeader("Access-Control-Allow-Origin", "*"); // cấp quyền cho font end
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json); // in ra màn hình;
        printWriter.flush(); // xóa toàn bộ sau khi run xong
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("roleName");
        String description = req.getParameter("description");
        int result = roleService.createRole(roleName, description);
        ReponseData reponseData = new ReponseData();
        if (result == 1) {
            reponseData.setStatusCode(200);
            reponseData.setSucces(true);
            reponseData.setMessage("Add Role Success!");
        } else {
            reponseData.setStatusCode(200);
            reponseData.setSucces(false);
            reponseData.setMessage("Add Role Fail!");
        }
        String json = gson.toJson(reponseData);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json);
        printWriter.flush();
        System.out.println("doPost");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        int result = roleService.deleteById(id);
        ReponseData reponseData = new ReponseData(0, "", false, "");
        if (result == 1) {
            reponseData = new ReponseData(200, "Delete Success", true, "");

        } else {
            reponseData = new ReponseData(200, "Delete fail", false, "");
        }
        String json = gson.toJson(reponseData);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json);
        printWriter.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(req.getReader());
        StringBuffer builder = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }
        String data = builder.toString();
        RoleModel roleModel = gson.fromJson(data, RoleModel.class);
        int result = roleService.updateById(roleModel);
        ReponseData reponseData = new ReponseData();
        if (result == 1) {
            reponseData.setStatusCode(200);
            reponseData.setMessage("Update success");
            reponseData.setSucces(true);
        } else {
            reponseData.setStatusCode(200);
            reponseData.setMessage("Update fail");
            reponseData.setSucces(false);
        }
        String json = gson.toJson(reponseData);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json);
        printWriter.flush();
    }
}
