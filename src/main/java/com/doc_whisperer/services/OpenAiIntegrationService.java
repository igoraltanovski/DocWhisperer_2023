package com.doc_whisperer.services;

import com.hw.langchain.chat.models.openai.ChatOpenAI;
import com.hw.langchain.schema.HumanMessage;
import com.hw.langchain.schema.SystemMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenAiIntegrationService {


    public String completeCode(String sysMessage, String template,  String code) {

        var chat = ChatOpenAI.builder()
                .openaiApiKey("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")
                .model("gpt-4")
                .temperature(0.5f)
                .maxTokens(2000)
                .requestTimeout(120)
                .build()
                .init();

        SystemMessage systemMessage = new SystemMessage(sysMessage);
        HumanMessage message = new HumanMessage(template + code);
        System.out.println("System message: " + systemMessage);
        System.out.println("Human message: " + message);
        var result = chat.predictMessages(List.of(systemMessage, message));
        System.out.println(result);
        return result.getContent();
    }
}
