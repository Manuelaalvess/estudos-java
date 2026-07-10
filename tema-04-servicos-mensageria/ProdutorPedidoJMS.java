// Tema 4. Servicos de mensageria
// JMS (Java Message Service) e a API padrao do Java pra mensageria
// Aqui o produtor manda uma mensagem pra uma fila, quem consome
// nao precisa estar online no mesmo momento em que a mensagem foi enviada

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ProdutorPedidoJMS {
    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        try (Connection conexao = factory.createConnection()) {
            conexao.start();

            Session sessao = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue fila = sessao.createQueue("fila.pedidos");
            MessageProducer produtor = sessao.createProducer(fila);

            TextMessage mensagem = sessao.createTextMessage("Pedido 123 confirmado para Manuela Alves");
            produtor.send(mensagem);

            System.out.println("Mensagem enviada para fila.pedidos");
        }
    }
}
