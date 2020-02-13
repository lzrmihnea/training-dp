package eu.training.dp.s04_price_calculation_distributed.queueing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessagingTest {

    private NewTask newTask;

    @Before
    public void setup() throws IOException, TimeoutException, InterruptedException {
        newTask = new NewTask("Tasker");
        new Worker("w1");
        new Worker("w2");
        new Worker("w3");
        Thread.sleep(1000);
    }

    @After
    public void after() throws IOException, TimeoutException {
        newTask.destroy();
    }

    @Test
    public void testSendingSomeMessages_expectedWorkersDistributeMessages() throws InterruptedException {
        sendMessage("I'm randomly sending messages to my 3 workers!");
        Thread.sleep(1000);

        sendMessage("And I don't care which one will handle which!");
        Thread.sleep(1000);

        sendMessage("Who will do it?");
        Thread.sleep(1000);

        sendMessage("So many willing!");
        Thread.sleep(1000);

        sendMessage("The idea is that they'll share the workload!");
        Thread.sleep(1000);

        sendMessage("And each will do an equal share of the work!");
        Thread.sleep(1000);
    }

    private void sendMessage(String s) {
        newTask.sendMessage(new String[]{s});
    }
}
