package servlets.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.dto.BranchDto;
import itacademy.services.BranchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@WebServlet("/api/email")
public class EmailApi extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    BranchDto branchDto = null;
    resp.setContentType("application/json");

    Optional<Branch> optionalBranch = BranchDaoImpl.getInstance().findById(3L);
    branchDto = BranchServiceImpl.getInstance().mapperBranch(optionalBranch.get());
    saveJSONInFile(branchDto);
    String json = getStringJSON(branchDto);
    ServletOutputStream out = resp.getOutputStream();
    out.write(json.getBytes(StandardCharsets.UTF_8));
    out.flush();
    out.close();
  }

  private String getStringJSON(Object object) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void saveJSONInFile(Object object) {
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("branch.json");
    try {
      file.createNewFile();
      objectMapper.writeValue(file, object);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
