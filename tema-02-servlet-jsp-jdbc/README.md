# Tema 2. Servlet, JSP e JDBC

O tema 2 fala de Servlet, JSP e JDBC, que juntos formam basicamente o esqueleto de qualquer aplicação Java rodando no servidor.

O Servlet é quem recebe a requisição HTTP (seja de um navegador ou de um app mobile), processa a lógica e devolve a resposta. É a parte que fica "escutando" o que o cliente pede.

O JSP entra na parte visual: mistura HTML com Java pra montar a página que o usuário vê. Na prática, o Servlet cuida da lógica e passa pro JSP montar a resposta, então cada um fica com sua responsabilidade e o código não vira uma bagunça só.

Já o JDBC é o que conecta tudo isso com o banco de dados, sem ele o Servlet não teria como buscar ou salvar informação nenhuma, ia ficar só recebendo e devolvendo requisição sem persistir nada.

O que eu achei interessante é que essa combinação ainda hoje sustenta sistemas que precisam atender vários tipos de cliente ao mesmo tempo (navegador, app, API), e o mesmo Servlet pode servir tanto uma página JSP quanto retornar dado pra um app mobile, usando a mesma conexão JDBC por trás. Isso mostra bem por que Java continua forte em sistema corporativo mesmo com tanta tecnologia nova saindo.

## Arquivos

- `ExemploJDBC.java`: conexão e consulta ao banco via JDBC. Compila e roda com JDK puro (precisa do driver do MySQL no classpath e do banco rodando pra de fato conectar).
- `PacienteServlet.java`: exemplo de Servlet recebendo a requisição e encaminhando pro JSP.
- `exemploJsp.jsp`: página que recebe os dados do Servlet e monta o HTML.
