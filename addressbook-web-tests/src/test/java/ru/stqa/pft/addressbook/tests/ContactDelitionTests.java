package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelitionTests extends TestBase {
    @Test
    public void testContactDelition(){
        app.getNavigationHelper().gotoHomePage();
        app.getContacHelper().selectContact();
        app.getContacHelper().deleteSelectedContacts();
        app.getContacHelper().deletedAlert();
        app.getContacHelper().returnToHomePage();
    }
}
