// Tema 5. Web Services em Java
// Publica o servico SOAP num endpoint HTTP
// Depois de rodar, o WSDL fica disponivel em http://localhost:8081/paciente?wsdl

import javax.xml.ws.Endpoint;

public class PublicadorSoap {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/paciente", new PacienteSoapServiceImpl());
        System.out.println("Servico SOAP publicado em http://localhost:8081/paciente");
    }
}
