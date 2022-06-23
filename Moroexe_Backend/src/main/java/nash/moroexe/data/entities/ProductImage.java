package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductImage {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private String alt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="productImage")
    private ProductEntity product_ref;
}
