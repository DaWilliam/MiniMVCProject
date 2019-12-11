package pyramid.MiniMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping("/products")
	public ModelAndView getProducts()
	{
		List<Product> plist = pdao.getProductDetails();
		return new ModelAndView("products", "productlist", plist);
	}
	
	@RequestMapping(value="getProduct", method=RequestMethod.GET)
	public ModelAndView getProduct(String prodName)
	{
		Product p = pdao.findByName(prodName).get(0);
		Cart cartItem = new Cart(p.getId(), p.getName(), p.getDescription(), p.getQuantity(), p.getPrice(), p.getCategory());
		return new ModelAndView("products", "cartItem", cartItem);
	}
}
