// Tema 2. Servlet, JSP e JDBC
// O Servlet recebe a requisicao HTTP, prepara os dados e encaminha pro JSP montar a pagina
// Esse arquivo precisa de um container como Tomcat pra rodar de verdade

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PacienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = "Manuela Alves";
        String convenio = "Unimed";

        request.setAttribute("nome", nome);
        request.setAttribute("convenio", convenio);

        request.getRequestDispatcher("/exemploJsp.jsp").forward(request, response);
    }
}
