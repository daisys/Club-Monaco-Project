import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductTest {

    public String url;
    public Document doc;
    public Product product;

    @Before
    public void setup() throws IOException {

        url = "http://www.clubmonaco.com/product/index.jsp?productId=53008816";
        doc = Jsoup.connect(url).get();
        product = new Product(doc);

    }

    @Test
    public void whenGetProductNameShouldReturnProductName() {
        assertThat(product.getName(), is("Wayland Cardigan"));
    }

    @Test
    public void whenGetProductPriceShouldReturnProductPrice(){
        assertThat(product.getPrice(), is("$329.00"));
    }

}
