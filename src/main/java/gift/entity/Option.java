package gift.entity;

import gift.exception.MinimumOptionException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String name;
    @NotNull
    Integer quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    public Option() {

    }

    public Option(String name, Integer quantity, Product product) {
        this.name = name;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void updateOption(String name, Integer quantity, Product product) {
        this.name = name;
        this.quantity = quantity;
        this.product = product;
    }

    public void subtractQuantity(Integer quantity) {
        if (this.quantity - quantity <= 1) {
            throw new MinimumOptionException("옵션의 수량을 1개 이하로 남길 수 없습니다.");
        }
        this.quantity -= quantity;
    }

}
