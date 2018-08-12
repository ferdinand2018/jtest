package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testsContacModification(){
        app.getNavigationHelper().gotoHomePage();
        if(!app.getContacHelper().isThereAContact()){
            app.getContacHelper().createContact(new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", null), true);
        }
        List<ContactData> before = app.getContacHelper().getContactList();
        app.getContacHelper().selectContact(before.size() - 1);
        app.getContacHelper().initContactModification();
        ContactData contact = new ContactData("Иван", "Иванов", "г.Москва ул. Большая Ордынка", "+79772222333", "ivanov@mail.com", null);
        app.getContacHelper().fillContactForm(contact, false);
        app.getContacHelper().submitContactModification();
        app.getContacHelper().returnToHomePage();
        List<ContactData> after = app.getContacHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}