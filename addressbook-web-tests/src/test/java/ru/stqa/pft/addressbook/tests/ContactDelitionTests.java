package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDelitionTests extends TestBase {
    @Test
    public void testContactDelition(){
        app.getNavigationHelper().gotoHomePage();
        if(!app.getContacHelper().isThereAContact()){
            app.getContacHelper().createContact(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", null), true);
        }
        List<ContactData> before = app.getContacHelper().getContactList();
        app.getContacHelper().selectContact(before.size() - 1);
        app.getContacHelper().deleteSelectedContacts();
        app.getContacHelper().deletedAlert();
        app.getContacHelper().returnToHomePage();
        List<ContactData> after = app.getContacHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
