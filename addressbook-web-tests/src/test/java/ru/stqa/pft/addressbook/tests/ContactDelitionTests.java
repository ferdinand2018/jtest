package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDelitionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Иван").withLastname("Иванов")
                    .withAddress("abc").withMobilePhone("1").withWorkPhone("2")
                    .withEmail("abc").withGroup(null), false);
        }
    }
    /*@BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if(app.contact().list().size() == 0){
            app.contact().create(new ContactData()
                    .withFirstname("Иван").withLastname("Иванов")
                    .withMobilePhone("+79772222333")
                    .withGroup(null), true);
        }
    }*/

    @Test
    public void testContactDelition(){
        Contacts before = app.db().contacts();
        ContactData deleteContact = before.iterator().next();
        app.contact().delete(deleteContact);
        Contacts after = app.db().contacts();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.withOut(deleteContact)));
    }
}
