package com.example.springaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("genAIChatClientService")
public class GenAIChatClientServiceImpl implements ChatClientService {


    private final ChatClient chatClient;

    public GenAIChatClientServiceImpl(
            @Qualifier("genAIChatClient") ChatClient chatClient
    ) {
        this.chatClient = chatClient;
    }

    @Override
    public String chat(String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }
}
