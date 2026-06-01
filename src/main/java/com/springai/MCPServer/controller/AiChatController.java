package com.springai.MCPServer.controller;

import com.springai.MCPServer.mcptools.UserMcpTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AiChatController {

    private final ChatClient chatClient;

    private final UserMcpTools userMcpTools;

    private final ChatMemory chatMemory;

    @GetMapping("/ai/chat")
    public String askAi(
            @RequestParam String prompt,
            @RequestParam String conversationId) {

        return chatClient.prompt()
                .user("""
                You are an AI assistant connected to a user database.

                RULES:
                - Always use tools when a matching tool exists.
                - After calling a tool, return the actual tool result.
                - Do not describe the tool call.
                - Do not explain that you used a tool.
                - Do not say "you have accessed information".
                - Show the retrieved data directly.

                User request:
                """ + prompt)
                .tools(userMcpTools)
                .call()
                .content();
    }
}