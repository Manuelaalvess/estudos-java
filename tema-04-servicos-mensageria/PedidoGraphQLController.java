// Tema 4. Servicos de mensageria
// Resolver GraphQL usando Spring GraphQL
// O cliente pode pedir so o campo "paciente", so o "status", ou tudo junto,
// numa unica requisicao, sem precisar de varios endpoints REST diferentes

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PedidoGraphQLController {

    @QueryMapping
    public Pedido pedido(@Argument String id) {
        return new Pedido(id, "Manuela Alves", "Unimed", "confirmado");
    }

    @QueryMapping
    public List<Pedido> pedidos() {
        return List.of(new Pedido("123", "Manuela Alves", "Unimed", "confirmado"));
    }
}

class Pedido {
    private String id;
    private String paciente;
    private String convenio;
    private String status;

    public Pedido(String id, String paciente, String convenio, String status) {
        this.id = id;
        this.paciente = paciente;
        this.convenio = convenio;
        this.status = status;
    }

    public String getId() { return id; }
    public String getPaciente() { return paciente; }
    public String getConvenio() { return convenio; }
    public String getStatus() { return status; }
}
