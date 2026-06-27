package com.example.springaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("openAIChatClientService")
public class OpenAIChatClientServiceImpl implements ChatClientService {


    private final ChatClient chatClient;

    public OpenAIChatClientServiceImpl(
            @Qualifier("openAIChatClient") ChatClient chatClient
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
