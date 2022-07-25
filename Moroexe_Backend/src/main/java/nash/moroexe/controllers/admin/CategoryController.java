package nash.moroexe.controllers.admin;

import nash.moroexe.dto.request.CategoryRequestDTO;
import nash.moroexe.dto.response.CategoryResponseDTO;
import nash.moroexe.services.CategoryServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {
    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping
    public List<CategoryResponseDTO> getAllCategory(){
        return this.categoryServices.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO findCategoryById(@PathVariable Long id){
        return this.categoryServices.findCategoryById(id);
    }

    @PutMapping
    public CategoryResponseDTO updateCategory(CategoryRequestDTO categoryDTO, Long id){
        return this.categoryServices.updateCategory(categoryDTO,id);
    }


}
