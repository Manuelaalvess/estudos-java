// Tema 4. Servicos de mensageria
// Consumidor JMS, fica ouvindo a fila e processa a mensagem quando ela chega

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ConsumidorPedidoJMS {
    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        try (Connection conexao = factory.createConnection()) {
            conexao.start();

            Session sessao = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue fila = sessao.createQueue("fila.pedidos");
            MessageConsumer consumidor = sessao.createConsumer(fila);

            consumidor.setMessageListener(mensagem -> {
                try {
                    TextMessage textMessage = (TextMessage) mensagem;
                    System.out.println("Mensagem recebida: " + textMessage.getText());
                } catch (Exception e) {
                    System.out.println("Erro ao ler mensagem: " + e.getMessage());
                }
            });

            System.out.println("Aguardando mensagens em fila.pedidos...");
            Thread.sleep(60000);
        }
    }
}
