package com.doc_whisperer.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaClassExtractor {

    public static void extract(String srcDir) throws IOException {
        List<Path> javaFiles = Files.walk(Paths.get(srcDir))
                .filter(p -> p.toString().endsWith(".java"))
                .collect(Collectors.toList());

        Pattern packagePattern = Pattern.compile("package\\s+(.*?);");
        Pattern classPattern = Pattern.compile("class\\s+(\\w+)");
        Pattern methodPattern = Pattern.compile("(public\\s|protected\\s|private\\s|static\\s|\\s)*+\\w+([<>,\\s]*\\w+)*\\s+([a-z]\\w*)\\s*\\(.*?\\)\\s*\\{?");

        StringBuilder output = new StringBuilder();

        for (Path javaFile : javaFiles) {
            String content = new String(Files.readAllBytes(javaFile));

            Matcher packageMatcher = packagePattern.matcher(content);
            if (packageMatcher.find()) {
                String packageName = packageMatcher.group(1);
                Matcher classMatcher = classPattern.matcher(content);
                if (classMatcher.find()) {
                    String className = classMatcher.group(1);
                    output.append("class: ").append(packageName).append(".").append(className).append("\n");

                    Matcher methodMatcher = methodPattern.matcher(content);
                    while (methodMatcher.find()) {
                        String methodName = methodMatcher.group(3);
                        output.append("\tmethod: ").append(methodName).append("();\n");
                    }
                }
            }
        }

        Files.write(Paths.get("output.txt"), output.toString().getBytes());
    }
}
