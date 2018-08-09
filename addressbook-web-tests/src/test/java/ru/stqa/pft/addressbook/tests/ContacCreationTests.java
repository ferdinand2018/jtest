package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContacCreationTests extends TestBase{
    @Test
    public void testsContacCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContacHelper().getContactList();
        app.getContacHelper().createContact(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", "test1"), true);
        List<ContactData> after = app.getContacHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);
    }
}