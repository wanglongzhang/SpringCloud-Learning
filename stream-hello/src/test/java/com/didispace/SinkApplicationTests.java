package com.didispace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@EnableBinding(value = {SinkApplicationTests.SinkSender.class})
public class SinkApplicationTests {

	@Autowired
	private SinkSender sinkSender;

	@Test
	public void sinkSenderTester() {
		Map<String, String> headers = new HashMap<>();
		headers.put("test", "some");
		int threads = 3;
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(threads);
        for (int i=0;i<threads;i++){
            executor.execute(() -> {
                for(int j=0; j<100000;j++){
                    sinkSender.output().send(MessageBuilder.
                            withPayload("produce a message ：http://blog.didispace.com").
                            copyHeadersIfAbsent(headers).
                            setCorrelationId(UUID.randomUUID()).
                            build());
                    System.out.println("here sent"+j);
                }


            });
            System.out.println("sssssssssssssssxxxx"+i);
        }

        System.out.println("sssssssssssssssxxxx");
	}

	public interface SinkSender {

		String OUTPUT = "license";

		@Output(SinkSender.OUTPUT)
		MessageChannel output();

	}

}
