// Tema 5. Web Services em Java
// Mesmo servico da versao SOAP, agora exposto como REST usando JAX-RS
// Sem contrato rigido tipo WSDL, sem envelope XML obrigatorio,
// so um recurso identificado por URL respondendo em JSON

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pacientes")
public class PacienteRestService {

    @GET
    @Path("/{nome}/convenio")
    @Produces(MediaType.TEXT_PLAIN)
    public String consultarConvenio(@PathParam("nome") String nomePaciente) {
        if (nomePaciente.equals("Manuela Alves")) {
            return "Unimed";
        }
        return "Convenio nao encontrado";
    }
}
