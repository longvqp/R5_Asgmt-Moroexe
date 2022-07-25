package nash.moroexe.services;

import nash.moroexe.dto.request.CategoryRequestDTO;
import nash.moroexe.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryServices {
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO findCategoryById(Long id);
    CategoryResponseDTO updateCategory(CategoryRequestDTO categoryDTO, Long id);
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryDTO);
    void deleteCategory(int id);
}
