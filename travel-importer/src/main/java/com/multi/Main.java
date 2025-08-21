package com.multi;

import java.nio.charset.Charset;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        System.out.println("Default file.encoding: " + System.getProperty("file.encoding"));

        // JVM 기본 Charset 확인
        System.out.println("Default Charset: " + Charset.defaultCharset());

        // MS949 여부 판별
        if ("MS949".equalsIgnoreCase(System.getProperty("file.encoding"))
                || "MS949".equalsIgnoreCase(Charset.defaultCharset().name())) {
            System.out.println("👉 current console output encoding is MS949");
        } else {
            System.out.println("👉 current console output encoding is not MS949");
        }

        // 테스트 문자 출력
        System.out.println("테스트 문자열: 안녕하세요 😊");
    }
}