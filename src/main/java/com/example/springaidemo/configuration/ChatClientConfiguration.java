package com.example.springaidemo.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfiguration {

    @Bean
    @Qualifier("genAIChatClient")
    public ChatClient genAIChatClient(GoogleGenAiChatModel googleGenAiChatModel) {
        return ChatClient
                .builder(googleGenAiChatModel)
                .build();
    }

    @Bean
    @Qualifier("openAIChatClient")
    public ChatClient openAIChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient
                .builder(openAiChatModel)
                .build();
    }
}
