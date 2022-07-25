package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private String description;
    private double rating;
    private int price;
    private int size;
    private int stock;

    private Date createdDate;
    private Boolean isActive;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private CategoryEntity category_ref;

    @OneToOne(mappedBy = "product")
    private ProductQuantity quantity;

}
