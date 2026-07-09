// Tema 1. Formatos de transmissao de dados
// JSON e o formato mais usado em APIs modernas
// Exemplo: ficha de paciente em formato texto

public class FormatosDados {
    public static void main(String[] args) {

        // Simulando um dado JSON como String em Java
        String fichaJSON = "{"
            + "\"nome\": \"Manuela Alves\","
            + "\"idade\": 23,"
            + "\"convenio\": \"Unimed\""
            + "}";

        System.out.println("Ficha em JSON:");
        System.out.println(fichaJSON);
    }
}
