package com.phonebook.testsRA;

import com.phonebook.AuthRequestDto;
import com.phonebook.AuthResponseDto;
import com.phonebook.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class LoginTestRa extends TestBase{
    AuthRequestDto auth =  AuthRequestDto.builder()
            .username("sasha@gamil.com")
            .password("Maus3123452#$")
            .build();

    @Test
    public void loginSuccessTest() {
        AuthResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("/user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void loginSuccessTest2() {
        String responseToken = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("/user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("token"))
                .extract().path("token");
        System.out.println(responseToken);
    }

    @Test
    public void loginWithWrongPasswordTest() {
        ErrorDto errorDto = given().body(AuthRequestDto.builder()
                    .username("sasha@gamil.com")
                    .password("Maus3123452#").build())
                .post("/user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .body(containsString("Login or password incorrect"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
        System.out.println(errorDto.getError());
    }

    @Test
    public void loginWithWrongEmailTest() {
        ErrorDto errorDto = given().body(AuthRequestDto.builder()
                    .username("sash@gamil.com")
                    .password("Maus3123452#$").build())
                .post("/user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .body(containsString("Login or password incorrect"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
        System.out.println(errorDto.getError());
    }
}
