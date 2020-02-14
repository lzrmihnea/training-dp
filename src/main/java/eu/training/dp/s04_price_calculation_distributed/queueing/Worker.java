package eu.training.dp.s04_price_calculation_distributed.queueing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker {

    private static final String TASK_QUEUE_NAME = "task_queue";
    private static final String PREFIX_WORKER = "[W]";

    private String name;

    public Worker(String name) throws IOException, TimeoutException {
        this.name = name;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println(PREFIX_WORKER + " " + this.name + " Ready! \n");
        channel.basicQos(1);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(PREFIX_WORKER + " " + name + " Received '" + message + "'\n");
                try {
                    doWork(message);
                } finally {
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
    }

    private void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Worker worker = new Worker("pvsm worker");
    }
}

