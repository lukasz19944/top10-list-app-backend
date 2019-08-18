package pl.slusarski.top10listappbackend.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "List name is required")
    private String listName;
    @NotBlank(message = "List description is required")
    private String listDescription;
    @NotBlank(message = "List category is required")
    private String listCategory;
    private LocalDate publishDate;

    @Valid
    @NotEmpty(message = "All items are required")
    @NotNull
    @OneToMany(cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER,
            mappedBy = "list",
            orphanRemoval = true
    )
    private java.util.List<Item> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }

    public String getListCategory() {
        return listCategory;
    }

    public void setListCategory(String listCategory) {
        this.listCategory = listCategory;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public java.util.List<Item> getItems() {
        return items;
    }

    public void setItems(java.util.List<Item> items) {
        this.items = items;
    }

    @PrePersist
    protected void onCreate() {
        this.publishDate = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof List)) return false;
        List list = (List) o;
        return Objects.equals(id, list.id) &&
                Objects.equals(listName, list.listName) &&
                Objects.equals(listDescription, list.listDescription) &&
                Objects.equals(listCategory, list.listCategory) &&
                Objects.equals(publishDate, list.publishDate) &&
                Objects.equals(items, list.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, listName, listDescription, listCategory, publishDate, items);
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", listName='" + listName + '\'' +
                ", listDescription='" + listDescription + '\'' +
                ", listCategory='" + listCategory + '\'' +
                ", publishDate=" + publishDate +
                ", items=" + items +
                '}';
    }
}
