package pl.slusarski.top10listappbackend.domain;

import java.util.Objects;

public class Item {

    private String itemName;
    private String itemDescription;

    private List list;

    public Item() {

    }

    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName) &&
                Objects.equals(itemDescription, item.itemDescription) &&
                Objects.equals(list, item.list);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemName, itemDescription, list);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", list=" + list +
                '}';
    }
}
