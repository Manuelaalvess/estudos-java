// Tema 3. Persistencia com Spring Data
// Mesma ideia do JpaRepository, mas pro MongoDB
// O Spring Data troca a implementacao por baixo, a interface que eu escrevo e parecida

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface HistoricoAtendimentoRepository extends MongoRepository<HistoricoAtendimento, String> {

    List<HistoricoAtendimento> findByPacienteId(Long pacienteId);
}
