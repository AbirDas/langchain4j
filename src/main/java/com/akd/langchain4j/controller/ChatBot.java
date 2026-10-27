package com.akd.langchain4j.controller;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/langchain4j")
public class ChatBoot {

    private final ChatModel chatModel;

    /*public ChatBoot(ChatModel chatModel) {
        this.chatModel = chatModel;
    }*/

    public ChatBoot(OpenAiChatModel.OpenAiChatModelBuilder openAiChatModelBuilder) {
        this.chatModel = openAiChatModelBuilder
                .build();
    }

    @GetMapping
    public String chatWithMe(@RequestParam("message") String message) {
        String response = chatModel.chat(message);
        return "OpenAPI response : " + response;
    }

}
