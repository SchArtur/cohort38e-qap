package com.phonebook.testsRA;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoic2FzaGFAZ2FtaWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MTU5Njg2NzUsImlhdCI6MTcxNTM2ODY3NX0.xDiQ1kUAhg_6eiYvnSamI_8zzkkWGy1nI9ABfmm17hY"; // Финальная переменная, которая хранит токен
    public static final String AUTH = "Authorization";

    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com"; // Переменная для домена свагера
        RestAssured.basePath = "v1"; // Переменная пути которая чапсто повторяется
    }
}
