import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    PosterItem item = new PosterItem(1, "aaa");
    PosterItem item1 = new PosterItem(2, "bbb");
    PosterItem item2 = new PosterItem(3, "ccc");
    PosterItem item3 = new PosterItem(4, "ddd");
    PosterItem item4 = new PosterItem(5, "eee");
    PosterItem item5 = new PosterItem(6, "fff");
    PosterItem item6 = new PosterItem(7, "ggg");

    @Test
    public void add() {
        Manager manager = new Manager();
        manager.addItem(item);

        PosterItem[] expected = {item};
        PosterItem[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void outAll() {
        Manager manager = new Manager();
        manager.addItem(item);
        manager.addItem(item1);
        manager.addItem(item2);
        manager.addItem(item3);
        manager.addItem(item4);
        manager.addItem(item5);
        manager.findAll();

        PosterItem[] expected = {item, item1, item2, item3, item4, item5};
        PosterItem[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void outAllIfNotExistItems() {
        Manager manager = new Manager();
        manager.findAll();

        PosterItem[] expected = {};
        PosterItem[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void defaultLimReversOut() {
        Manager manager = new Manager();
        manager.addItem(item);
        manager.addItem(item1);
        manager.addItem(item2);
        manager.addItem(item3);
        manager.addItem(item4);
        manager.addItem(item5);
        manager.findLast();

        PosterItem[] expected = {item5, item4, item3, item2, item1};
        PosterItem[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void UserLimReversOut() {
        Manager manager = new Manager(7);
        manager.addItem(item);
        manager.addItem(item1);
        manager.addItem(item2);
        manager.addItem(item3);
        manager.addItem(item4);
        manager.addItem(item5);
        manager.addItem(item6);
        manager.findLast();

        PosterItem[] expected = {item6, item5, item4, item3, item2, item1, item};
        PosterItem[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void UserLimReversOutAbovePosterLength() {
        Manager manager = new Manager(7);
        manager.addItem(item);
        manager.addItem(item1);
        manager.addItem(item2);
        manager.addItem(item3);
        manager.addItem(item4);
        manager.addItem(item5);
        manager.findLast();

        PosterItem[] expected = {item5, item4, item3, item2, item1, item};
        PosterItem[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void UserLimReversOutNull() {
        Manager manager = new Manager(0);
        manager.addItem(item);
        manager.addItem(item1);
        manager.addItem(item2);
        manager.addItem(item3);
        manager.addItem(item4);
        manager.addItem(item5);
        manager.findLast();

        PosterItem[] expected = {};
        PosterItem[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
}

