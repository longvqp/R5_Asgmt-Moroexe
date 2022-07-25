package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String name;
    private Date createdDate;
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category_ref")
    private List<ProductEntity> product;


}
