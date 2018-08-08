package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testsContacModification(){
        app.getNavigationHelper().gotoHomePage();
        if(!app.getContacHelper().isThereAContact()){
            app.getContacHelper().createContact(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", "test1"), true);
        }
        app.getContacHelper().selectContact();
        app.getContacHelper().initContactModification();
        app.getContacHelper().fillContactForm(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", null), false);
        app.getContacHelper().submitContactModification();
        app.getContacHelper().returnToHomePage();
    }
}