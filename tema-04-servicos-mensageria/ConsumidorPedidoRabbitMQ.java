// Tema 4. Servicos de mensageria
// Consumidor RabbitMQ, escuta a fila e processa a mensagem assim que ela chega

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ConsumidorPedidoRabbitMQ {
    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection conexao = factory.newConnection();
        Channel canal = conexao.createChannel();

        canal.queueDeclare("fila.pedidos", false, false, false, null);

        DeliverCallback callback = (consumerTag, delivery) -> {
            String mensagem = new String(delivery.getBody(), "UTF-8");
            System.out.println("Mensagem recebida: " + mensagem);
        };

        canal.basicConsume("fila.pedidos", true, callback, consumerTag -> { });

        System.out.println("Aguardando mensagens em fila.pedidos...");
    }
}
