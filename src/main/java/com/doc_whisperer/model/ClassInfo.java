package com.doc_whisperer.model;

import java.util.List;

public class ClassInfo {

    private String className;
    private List<String> methods;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    public ClassInfo(String className, List<String> methods) {
        this.className = className;
        this.methods = methods;
    }

    public ClassInfo() {
        super();
    }
}
