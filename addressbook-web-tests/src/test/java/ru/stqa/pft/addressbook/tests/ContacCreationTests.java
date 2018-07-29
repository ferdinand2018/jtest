package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContacCreationTests extends TestBase{
    @Test
    public void testsContacCreation() {
        app.getNavigationHelper().gotoHomePage();
        app.getContacHelper().initContactCreation();
        app.getContacHelper().fillContactForm(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com"));
        app.getContacHelper().submitContactCreation();
        app.getContacHelper().returnToHomePage();
    }
}