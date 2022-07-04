package repo.poi.createword.model;

import java.util.List;

public class Group {
    private String name;
    private List<GroupItem> items;

    public Group() {
    }

    public Group(String name, List<GroupItem> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupItem> getItems() {
        return items;
    }

    public void setItems(List<GroupItem> items) {
        this.items = items;
    }
}
