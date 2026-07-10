# Tema 3. Persistência com Spring Data

O Spring Data resolve um problema bem chato de persistência: escrever menos código repetitivo de acesso a banco. Em vez de implementar manualmente cada consulta, eu só crio uma interface estendendo `JpaRepository` (pra banco relacional) ou `MongoRepository` (pra banco de documento) e o Spring já gera as implementações de CRUD sozinho, incluindo consultas derivadas do nome do método, tipo `findByPacienteId`, sem eu escrever uma linha de SQL ou de query Mongo.

Nesse exemplo eu usei os dois bancos juntos no mesmo projeto, porque cada um resolve um problema diferente:

O `Paciente` fica no PostgreSQL, porque é um dado bem estruturado, com colunas fixas (nome, convênio), que se beneficia de relação e integridade que um banco relacional garante.

O `HistoricoAtendimento` fica no MongoDB, porque o histórico de atendimento varia de paciente pra paciente. Um pode ter uma lista de observações, outro pode ter uma estrutura totalmente diferente, e forçar isso numa tabela fixa ia gerar colunas nulas e migração toda hora. Documento resolve isso melhor.

O `PacienteController` expõe os dois num único serviço REST: um endpoint pra cadastrar e listar pacientes (Postgres) e outro pra puxar o histórico de atendimento de um paciente específico (Mongo). Na prática é isso que dá agilidade: eu não preciso escolher um banco só pra aplicação inteira, escolho o banco certo pra cada tipo de dado e o Spring Data cuida da parte chata de conectar e persistir nos dois.

## Arquivos

- `Paciente.java`: entidade JPA mapeada pro PostgreSQL.
- `PacienteRepository.java`: repository JPA com CRUD pronto.
- `HistoricoAtendimento.java`: documento mapeado pro MongoDB.
- `HistoricoAtendimentoRepository.java`: repository Mongo com uma consulta derivada (`findByPacienteId`).
- `PacienteController.java`: endpoints REST usando os dois repositories juntos.

Esse código precisa de um projeto Spring Boot com as dependências `spring-boot-starter-data-jpa`, `spring-boot-starter-data-mongodb` e o driver do PostgreSQL no `pom.xml` (ou `build.gradle`) pra rodar de verdade, além dos bancos PostgreSQL e MongoDB configurados no `application.properties`.
