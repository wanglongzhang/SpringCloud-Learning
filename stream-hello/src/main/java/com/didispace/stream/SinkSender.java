package com.didispace.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.UUID;

@EnableBinding(value = {Source.class})
public class SinkSender {

    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);

    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel channel;

    public void send(String payload) {
        String dataToSend = payload + UUID.randomUUID();
        logger.info("sent: %s", dataToSend);
        channel.send(MessageBuilder.withPayload(dataToSend).build());
    }



//        @Bean
//    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<String> timerMessageSource() {
//        return () -> new GenericMessage<>("{\"name\":\"didi\", \"age\":30}");
//    }

}
