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

                .advisors(
                        MessageChatMemoryAdvisor.builder(chatMemory)
                                .conversationId(conversationId)
                                .build()
                )

                .user("""
                        You are an AI assistant connected to a user database.

                        ALWAYS use available tools whenever user asks:
                        - user information
                        - create/update/delete operations
                        - search operations

                        Never say tasks are beyond capability
                        if a matching tool exists.

                        Use previous conversation context.

                        Be concise and direct.
                        """ + prompt)

                .tools(userMcpTools)

                .call()

                .content();
    }
}