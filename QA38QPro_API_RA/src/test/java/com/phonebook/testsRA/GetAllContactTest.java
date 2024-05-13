package com.phonebook.testsRA;

import com.phonebook.AllContactsDto;
import com.phonebook.ContactDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class GetAllContactTest extends TestBase{
    @Test
    public void getAllContactsPositiveTest() {
        AllContactsDto contactsDto = given()
            .header(AUTH, TOKEN)
            .when()
            .get("contacts")
            .then()
            .assertThat().statusCode(200)
            .extract().body().as(AllContactsDto.class);
        for(ContactDto contact: contactsDto.getContacts()) {
            System.out.println(contact.getId() + "***" + contact.getName());
            System.out.println("===========================================");
        }
    }

    @Test
    public void getAllContactsNegativeTest() {
        given()
            .header(AUTH, "Invalid Token")
            .when()
            .get("contacts")
            .then()
            .assertThat().statusCode(401)
            .body(containsString("Unauthorized"));
    }
}

