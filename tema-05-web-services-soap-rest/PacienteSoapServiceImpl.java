// Tema 5. Web Services em Java
// Implementacao do servico SOAP, quem realmente responde a requisicao

import javax.jws.WebService;

@WebService(endpointInterface = "PacienteSoapService")
public class PacienteSoapServiceImpl implements PacienteSoapService {

    @Override
    public String consultarConvenio(String nomePaciente) {
        if (nomePaciente.equals("Manuela Alves")) {
            return "Unimed";
        }
        return "Convenio nao encontrado";
    }
}
