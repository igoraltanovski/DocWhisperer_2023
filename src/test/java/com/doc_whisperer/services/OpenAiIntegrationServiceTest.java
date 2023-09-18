package com.doc_whisperer.services;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class OpenAiIntegrationServiceTest {


        private OpenAiIntegrationService service = new OpenAiIntegrationService();

        @Test
        public void testCompleteCode() throws Exception {
            // Read the code from the file
/*            String code = new String(Files.readAllBytes(Paths.get("C:\\pet_clinic\\DocWhisperer\\src\\main\\resources\\code\\1.txt")));

            // Call the completeCode method
            String result = service.completeCode("Channel the experience and knowledge of a senior developer and technical writer. Given the code or technical topic below, provide a detailed, comprehensive, and technically accurate explanation, walkthrough, or documentation, as if explaining to a fellow developer. Make sure to address nuances, best practices, and potential pitfalls.",
                    "Given the code provided below, generate a concise yet comprehensive documentation based on the following topic model:\\n\\nFunctionality Overview: A brief description of what the code does .\\nUsage: How to use or implement the code.\\nParameters and Returns: Details about the input parameters and return values.\\n\\n Code:\\n",
                    code);
            System.out.println(result);

            // Assert that a response is retrieved
            assertNotNull(result);
            assertFalse(result.isEmpty());*/
        }

}