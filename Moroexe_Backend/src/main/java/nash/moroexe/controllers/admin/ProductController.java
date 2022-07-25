package nash.moroexe.controllers.admin;

import nash.moroexe.dto.response.ProductResponseDTO;
import nash.moroexe.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/product")
public class ProductController {
    private final ProductServices productService;

    public ProductController(ProductServices productService) {
        this.productService = productService;
    }

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
