// Tema 3. Persistencia com Spring Data
// Endpoint REST que usa as duas fontes de dados ao mesmo tempo:
// o cadastro do paciente vem do PostgreSQL, o historico vem do MongoDB

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HistoricoAtendimentoRepository historicoRepository;

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @GetMapping("/{id}/historico")
    public List<HistoricoAtendimento> listarHistorico(@PathVariable Long id) {
        return historicoRepository.findByPacienteId(id);
    }
}
