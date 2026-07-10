// Tema 3. Persistencia com Spring Data
// Documento do MongoDB, faz sentido aqui porque o historico de atendimento
// varia de estrutura de paciente pra paciente (nem todo atendimento tem os mesmos campos)
// e isso e dificil de encaixar numa tabela relacional fixa

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "historico_atendimento")
public class HistoricoAtendimento {

    @Id
    private String id;

    private Long pacienteId;
    private String data;
    private List<String> observacoes;

    public String getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        this.observacoes = observacoes;
    }
}
