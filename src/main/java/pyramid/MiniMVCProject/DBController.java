package pyramid.MiniMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DBController {
	@Autowired
	CartDAO cdao;
	
	@Autowired
	ProductDAO pdao;
	
		
	@RequestMapping(value = "add_product/{id}/{quantity}", method=RequestMethod.GET)
	@ResponseBody
	public void saveCartItem(@PathVariable("id") int id, @PathVariable("quantity") int quantity)
	{
		Product p = pdao.findById(id).get(0);
		p.setQuantity(5);
		cdao.saveCartDetails(p);
	}	
	
	@RequestMapping("/cart")
	public ModelAndView getCartProducts()
	{
		List<Cart> clist = cdao.getCartDetails();
		return new ModelAndView("cart", "cartList", clist);
	}
	
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
