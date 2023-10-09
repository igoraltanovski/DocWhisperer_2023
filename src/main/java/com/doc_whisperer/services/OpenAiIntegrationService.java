package com.doc_whisperer.services;

import com.hw.langchain.chat.models.openai.ChatOpenAI;
import com.hw.langchain.schema.HumanMessage;
import com.hw.langchain.schema.SystemMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenAiIntegrationService {

    public static final  String gtp_4_model = "gpt-4";
    public static final  String gtp_3_5_model = "gpt-3.5-turbo";
    public static final  String gtp_3_5_model_16k = "gpt-3.5-turbo-16k";



    public String completeCode(String sysMessage, String template,  String code, String model) {
        return completeCode(sysMessage, template, code, 2000, model);
    }


    public String completeCode(String sysMessage, String template,  String code, Integer maxTokens, String model) {

        var chat = ChatOpenAI.builder()
                .openaiApiKey(System.getenv("OPENAI_API_KEY"))
                .model(model)
                .temperature(0.5f)
                .maxTokens(maxTokens)
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
