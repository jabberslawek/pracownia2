package HibernateModel;

import javax.persistence.*;

@Entity
@Table(name = "category")

public class Category {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Nazwa")
    private String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
