import controller.SeearchCatalogueController;
import entity.Seller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import repository.ProductRepository;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.transaction.Transactional;
import java.util.Collection;

@ContextConfiguration(
        classes = {SeearchCatalogueController.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class searchCatalogueControllerTest {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private Seller seller;

    @Test
    public void  searchCatalogueTest(){
        productRepository.insertProduct("Puma","White","S",Long.valueOf(12));
        Collection<String> c = productRepository.findProductByClientIdOrBrandOrColorOrPriceOrSize("Puma","White","S",Long.valueOf(12),1);
        Assert.assertFalse(c.isEmpty());
    }

    @Test
    public void  searchBySellerTest(){
        productRepository.insertProduct("Puma","White","S",Long.valueOf(12));
        Collection<String> c = productRepository.findProductBySeller(1, null);
        Assert.assertFalse(c.isEmpty());
    }


}
