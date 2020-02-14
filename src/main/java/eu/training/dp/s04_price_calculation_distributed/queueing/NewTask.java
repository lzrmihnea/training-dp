package eu.training.dp.s04_price_calculation_distributed.queueing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";
    private static final String PREFIX_TASK = "[T]";

    private String name;

    private Connection connection;
    private static Channel channel;

    public NewTask(String name) throws IOException, TimeoutException {
        this.name = name;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

        sendMessage(new String[]{"Test initialization message!"});
    }

    @PreDestroy
    public void destroy() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }


    public void sendMessage(String[] argv) {
        String message = getMessage(argv);
        try {
            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes("UTF-8"));
            System.out.println(PREFIX_TASK + " " + this.name + " Sent '" + message + "'\n");
        } catch (IOException e) {
            System.err.println(PREFIX_TASK + " " + this.name + "Error in sending message: " + e.getMessage());
        }
    }

    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
