package br.com.alura.jornadamilhas.util;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatGPTClient {

    private final OpenAiService openAiService;

    public ChatGPTClient(@Value("${openai.api.key}") String apiKey) {
        openAiService = new OpenAiService(apiKey);
    }

    public String gerarTextoDescritivo(String nomeDestino) {
        var prompt = String.format("Faça um resumo sobre %s enfatizando o porque este lugar é incrível. Utilize uma " +
                "linguagem informal e até 100 caracteres no máximo em cada parágrafo. " +
                "Crie 2 parágrafos neste resumo.", nomeDestino);

        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(prompt)
                .maxTokens(1000)
                .build();

        var response = openAiService.createCompletion(request);
        return response.getChoices().get(0).getText();
    }
}
