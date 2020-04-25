package repository;

import entity.Product;
import entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Collection<Product> findAllByBrand();
    Collection<String> findProductByBrand();

    List<String> findProductByClientIdOrBrand();

    @Query(value="select * from Product where clientId in (:clientId) Or brand in(:brand) Or color in(:color) Or size in(:sizes) " +
            "Or price in(:price) group by brand",
            nativeQuery = true)
    Collection<String> findProductByClientIdOrBrandOrColorOrPriceOrSize(@Param("brand") String brand, @Param("color") String color,
                                                                        @Param("size") String sizes, @Param("price") Long price, @Param("clientId") Integer clientId);
    @Query(value="select * from Product where clientId in (:clientId) and seller in (:seller) group by brand",
            nativeQuery = true)
    Collection<String> findProductBySeller(@Param("clientId") Integer clientId,@Param("seller") Seller seller);

    @Query(value="insert into Product (brand,color,size,price)  values(:brand,:color,:sizes,:price)",
            nativeQuery = true)
    @Modifying
    void insertProduct(@Param("brand") String brand, @Param("color") String color,
                       @Param("size") String sizes, @Param("price") Long price);

}
