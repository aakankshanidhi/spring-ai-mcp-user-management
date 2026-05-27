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
                        You are an AI assistant connected to a user database.
                        
                                                 ALWAYS use available tools whenever user asks:
                                                 - user information
                                                 - create/update/delete operations
                                                 - search operations
                        
                                                 Never say tasks are beyond capability
                                                 if a matching tool exists.
                        
                                                 Be concise and direct.
                        """ + prompt)
                .tools(userMcpTools)
                .call()
                .content();
    }
}