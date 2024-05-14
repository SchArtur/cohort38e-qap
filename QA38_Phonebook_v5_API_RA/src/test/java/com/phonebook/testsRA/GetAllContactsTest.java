package com.phonebook.testsRA;

import com.phonebook.AllContactsDto;
import com.phonebook.ContactDto;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("@Contact")
@Tag("@ALL")
public class GetAllContactsTest extends TestBase {
    @Test
    @Tag("@SMOKE")
    public void getAllContactsPositiveTest() {
        AllContactsDto contactsDto = given()
                .header(AUTH, TOKEN)
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDto.class);
        for (ContactDto contact : contactsDto.getContacts()) {
            System.out.println(contact.getId() + "999999999999" + contact.getName());
            System.out.println("======================================================");
        }
    }
    //TODO: написать тест на получение всех контактов с неверным токеном
}
