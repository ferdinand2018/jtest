package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContacCreationTests extends TestBase{
    @Test
    public void testsContacCreation() {
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContacHelper().getContactCount();
        app.getContacHelper().createContact(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", "test1"), true);
        int after = app.getContacHelper().getContactCount();
        Assert.assertEquals(after,before + 1);
    }
}