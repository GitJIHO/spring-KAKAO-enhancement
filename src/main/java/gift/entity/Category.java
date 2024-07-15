package gift.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String color;
    @NotNull
    private String image_url;
    @NotNull
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public Category(String name, String color, String image_url, String description) {
        this.name = name;
        this.color = color;
        this.image_url = image_url;
        this.description = description;
    }

    public Category(Long id, String name, String color, String image_url, String description) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image_url = image_url;
        this.description = description;
    }

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDescription() {
        return description;
    }
}
