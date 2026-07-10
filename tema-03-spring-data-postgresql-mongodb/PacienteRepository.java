// Tema 3. Persistencia com Spring Data
// Repository do Spring Data JPA, so de extender a interface ja ganha
// os metodos de CRUD prontos (save, findById, findAll, deleteById...)
// sem escrever uma linha de SQL

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
