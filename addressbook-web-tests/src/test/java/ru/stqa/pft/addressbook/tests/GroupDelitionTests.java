package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDelitionTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("name 0"));
        }
    }
    /*@BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().list().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }*/

    @Test
    public void testGroupDelition() {
        Groups before = app.db().groups();
        GroupData deleteGroup = before.iterator().next();
        app.group().delete(deleteGroup);
        Groups after = app.db().groups();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.withOut(deleteGroup)));
    }
}