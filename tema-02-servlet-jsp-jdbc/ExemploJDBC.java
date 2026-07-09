// Tema 2. Servlet, JSP e JDBC
// JDBC e a camada que conecta a aplicacao Java com o banco de dados
// Aqui abrimos uma conexao, montamos uma consulta parametrizada e lemos o resultado

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemploJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica";
    private static final String USUARIO = "root";
    private static final String SENHA = "senha123";

    public static void main(String[] args) {
        String sql = "SELECT nome, convenio FROM pacientes WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setInt(1, 1);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Convenio: " + resultado.getString("convenio"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}
