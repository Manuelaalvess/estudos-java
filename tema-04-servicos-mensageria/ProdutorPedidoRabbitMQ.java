// Tema 4. Servicos de mensageria
// RabbitMQ implementa o protocolo AMQP, e mais flexivel que JMS pra rotear mensagem
// (exchange decide pra qual fila a mensagem vai, dependendo do tipo de roteamento escolhido)

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProdutorPedidoRabbitMQ {
    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection conexao = factory.newConnection();
             Channel canal = conexao.createChannel()) {

            canal.queueDeclare("fila.pedidos", false, false, false, null);

            String mensagem = "Pedido 123 confirmado para Manuela Alves";
            canal.basicPublish("", "fila.pedidos", null, mensagem.getBytes());

            System.out.println("Mensagem enviada para fila.pedidos via RabbitMQ");
        }
    }
}
