package spring.demo.interviewkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.demo.interviewkit.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}