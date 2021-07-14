package spring.demo.interviewkit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.demo.interviewkit.model.ProductModel;
import spring.demo.interviewkit.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/list")
    List<ProductModel> getListProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/insert")
    ProductModel insertProduct(@RequestBody ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @PutMapping("/update")
    ProductModel updateProduct(@RequestBody ProductModel productModel) {
        Optional<ProductModel> optProduct = productRepository.findById(productModel.getId());

        if (optProduct.isEmpty()) {
            return null;
        }

        ProductModel productToUpdate = optProduct.get();
        productToUpdate.setName(productModel.getName());
        productToUpdate.setStock(productModel.getStock());
        return productRepository.save(productToUpdate);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody ProductModel productModel) {
        productRepository.deleteById(productModel.getId());
    }
}