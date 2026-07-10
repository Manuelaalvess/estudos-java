# Tema 5. Web Services em Java

Esse tema é sobre como sistemas diferentes conversam entre si numa arquitetura SOA (Service-Oriented Architecture), onde cada parte do sistema é exposta como um serviço independente. Em Java, isso normalmente aparece de duas formas: SOAP com JAX-WS ou REST com JAX-RS. Fiz o mesmo exemplo (consultar o convênio de um paciente) nos dois estilos pra deixar a diferença bem concreta.

**SOAP** (`PacienteSoapService.java`, `PacienteSoapServiceImpl.java`, `PublicadorSoap.java`) segue um contrato rígido. A interface anotada com `@WebService` define exatamente quais operações existem e quais tipos de dado cada uma aceita e devolve, e a partir dela o Java gera automaticamente um WSDL, que é basicamente o "manual de instruções" do serviço. Isso é ótimo pra integração entre empresas diferentes, cada lado sabe exatamente o que esperar, e por isso SOAP ainda é comum em sistema bancário, governo e integrações corporativas onde o contrato formal importa mais que a agilidade.

**REST** (`PacienteRestService.java`) troca esse contrato rígido por simplicidade. Aqui não tem WSDL, não tem envelope XML obrigatório, o recurso é identificado direto por uma URL (`/pacientes/{nome}/convenio`) e a resposta pode ser texto simples, JSON, o que for mais prático. É mais leve de consumir, principalmente por aplicação mobile ou frontend, e por isso hoje é a escolha padrão pra API nova.

Na prática, a decisão entre os dois não é sobre qual é "melhor", é sobre o contexto: se o sistema precisa de contrato formal, transação complexa e segurança em nível de mensagem, SOAP ainda resolve melhor. Se o objetivo é entregar rápido e integrar com várias plataformas diferentes sem burocracia, REST ganha. Dominar os dois é o que garante que dá pra integrar com qualquer sistema legado ou moderno que apareça pela frente.

## Arquivos

- `PacienteSoapService.java` / `PacienteSoapServiceImpl.java` / `PublicadorSoap.java`: serviço SOAP completo usando JAX-WS, do contrato à publicação do endpoint.
- `PacienteRestService.java`: o mesmo serviço exposto como recurso REST usando JAX-RS.

O exemplo SOAP roda com JDK puro (JAX-WS faz parte do Java EE, em versões mais novas do JDK precisa da dependência `javax.xml.ws:jaxws-api` separada). O exemplo REST precisa de um servidor de aplicação ou de uma implementação JAX-RS como Jersey ou RESTEasy rodando por baixo.
