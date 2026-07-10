# Tema 4. Serviços de mensageria

Esse tema junta três tecnologias que resolvem problemas parecidos, mas não são exatamente a mesma coisa. JMS e RabbitMQ são mensageria de verdade, comunicação assíncrona via fila. GraphQL é uma linguagem de consulta pra API, mais parecido com REST do que com fila. Vale separar isso porque misturar os três como se fossem a mesma categoria é o erro mais comum quando esse assunto cai em prova.

**JMS** é a API padrão do Java pra mensageria. Um produtor manda uma mensagem pra uma fila e um consumidor processa ela depois, sem precisar estar online no mesmo instante. Isso desacopla os sistemas: se o serviço que processa o pedido cair por alguns minutos, a mensagem fica esperando na fila em vez de se perder.

**RabbitMQ** faz basicamente a mesma coisa, mas implementa o protocolo AMQP e é mais flexível pra rotear mensagem. Em vez de mandar direto pra uma fila, dá pra publicar num exchange e deixar ele decidir pra qual fila (ou quais filas) a mensagem vai, dependendo do tipo de roteamento configurado. Isso ajuda muito quando um mesmo evento (tipo "pedido confirmado") precisa avisar vários sistemas diferentes ao mesmo tempo.

**GraphQL** não é mensageria, é uma forma de expor dado pra quem consome a API. A diferença pro REST tradicional é que o cliente escolhe exatamente quais campos quer na resposta, numa única requisição, em vez de bater em vários endpoints fixos ou receber um JSON gigante com campo que ele nem vai usar. No exemplo do schema, o cliente pode pedir só o status do pedido, ou pedido completo, sem eu precisar criar uma rota nova pra cada combinação.

Na prática, um sistema real costuma usar as duas coisas juntas: RabbitMQ ou JMS pra comunicação entre serviços internos (assíncrono, desacoplado), e GraphQL como a porta de entrada pro cliente final consultar dado (síncrono, sob demanda). É essa combinação que dá desempenho e flexibilidade pra integrar sistemas diferentes sem forçar todo mundo a falar exatamente a mesma língua.

## Arquivos

- `ProdutorPedidoJMS.java` / `ConsumidorPedidoJMS.java`: exemplo de fila usando JMS com ActiveMQ.
- `ProdutorPedidoRabbitMQ.java` / `ConsumidorPedidoRabbitMQ.java`: mesmo cenário usando RabbitMQ.
- `schema.graphqls`: schema GraphQL definindo o tipo `Pedido` e as queries disponíveis.
- `PedidoGraphQLController.java`: resolver Spring GraphQL respondendo as queries do schema.

Os exemplos de JMS precisam de um broker ActiveMQ rodando e da dependência `activemq-client` no projeto. Os de RabbitMQ precisam do RabbitMQ rodando e da dependência `amqp-client`. O GraphQL precisa de um projeto Spring Boot com `spring-boot-starter-graphql`.
