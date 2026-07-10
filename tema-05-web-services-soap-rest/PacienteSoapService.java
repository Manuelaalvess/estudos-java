// Tema 5. Web Services em Java
// Interface do servico SOAP usando JAX-WS
// O contrato fica definido aqui, o WSDL e gerado automaticamente a partir dela

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PacienteSoapService {

    @WebMethod
    String consultarConvenio(String nomePaciente);
}
