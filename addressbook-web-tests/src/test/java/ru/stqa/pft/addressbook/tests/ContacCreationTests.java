package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContacCreationTests extends TestBase{
    @Test
    public void testsContacCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContacHelper().getContactList();
        ContactData contact = new ContactData("Иван", "Иванов", null, null, null, null);
        app.getContacHelper().createContact(new ContactData("Иван", "Иванов", null, null, null, "test1"), true);
        List<ContactData> after = app.getContacHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}