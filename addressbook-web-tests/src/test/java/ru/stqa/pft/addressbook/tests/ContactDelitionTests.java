package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDelitionTests extends TestBase {
    @Test
    public void testContactDelition(){
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContacHelper().getContactCount();
        if(!app.getContacHelper().isThereAContact()){
            app.getContacHelper().createContact(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", "test1"), true);
        }
        app.getContacHelper().selectContact(before - 1);
        app.getContacHelper().deleteSelectedContacts();
        app.getContacHelper().deletedAlert();
        app.getContacHelper().returnToHomePage();
        int after = app.getContacHelper().getContactCount();
        Assert.assertEquals(after,before - 1);
    }
}
