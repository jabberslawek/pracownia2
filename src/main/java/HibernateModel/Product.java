package HibernateModel;

import javax.persistence.*;

@Entity
@Table(name = "product")

public class Product {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Producent_id", referencedColumnName = "id")
    private Brand producentId;

    @Column(name = "Model")
    private String model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kategoria_id", referencedColumnName = "id")
    private Category kategoriaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getProducentId() {
        return producentId;
    }

    public void setProducentId(Brand producentId) {
        this.producentId = producentId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Category getKategoriaId() {
        return kategoriaId;
    }

    public void setKategoriaId(Category kategoria_Id) {
        this.kategoriaId = kategoria_Id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", producentId=" + producentId +
                ", model='" + model + '\'' +
                ", kategoriaId=" + kategoriaId +
                '}';
    }
}
