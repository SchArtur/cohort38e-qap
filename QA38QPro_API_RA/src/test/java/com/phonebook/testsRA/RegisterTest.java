package com.phonebook.testsRA;

import com.phonebook.AuthRequestDto;
import com.phonebook.AuthResponseDto;
import com.phonebook.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class RegisterTest extends TestBase {
    AuthRequestDto auth =  AuthRequestDto.builder()
            .username("sasha567888@gamil.com")
            .password("Maus3123452233#$")
            .build();

    @Test
    public void registerSuccessTest() {
        AuthResponseDto dto = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("/user/registration/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(dto);
    }

    @Test
    public void registerDuplicateUserTest() {
        ErrorDto errorDto = given().body(AuthRequestDto.builder()
                        .username("sasha56788@gamil.com")
                        .password("Maus3123452233#$").build())
                .post("/user/registration/usernamepassword")
                .then()
                .assertThat().statusCode(409)
                .body(containsString("Duplicate user"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
        System.out.println(errorDto.getError());
    }
}
