package nash.moroexe.controllers.admin;

import nash.moroexe.dto.response.ProductResponseDTO;
import nash.moroexe.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductServices productService;

    @GetMapping("/{id}")
    public ProductResponseDTO findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    //Testing
    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductResponseDTO productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping
    public ProductResponseDTO updateProduct(@Valid @RequestBody ProductResponseDTO productDto) {
        return productService.updateProduct(productDto);
    }

}
