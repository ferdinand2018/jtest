package ru.stqa.pft.addressbook.ContactTestsFix.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testsContacModification(){
        app.goTo().homePage();
        if(!app.contact().isThereAContact()){
            app.contact().createContact(new ContactData("Иван", "Иванов", null), true);
        }
        List<ContactData> before = app.contact().getContactList();
        app.contact().initContactModification(before.size() - 1);
        ContactData contact = new ContactData("Иван", "Иванов", null);
        app.contact().fillContactForm(contact, false);
        app.contact().submitContactModification();
        app.contact().returnToHomePage();
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}