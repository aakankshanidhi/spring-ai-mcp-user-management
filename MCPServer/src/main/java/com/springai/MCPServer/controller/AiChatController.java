package com.springai.MCPServer.controller;

import com.springai.MCPServer.mcptools.UserMcpTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiChatController {

    private final ChatClient chatClient;
    private final UserMcpTools userMcpTools;

    @GetMapping
    public String askAi(@RequestParam String prompt) {

        return chatClient.prompt()
                .user("""
                        You are an AI assistant for user management system.
                        Always use available tools for CRUD operations.

                        User request:
                        """ + prompt)
                .tools(userMcpTools)
                .call()
                .content();
    }
}