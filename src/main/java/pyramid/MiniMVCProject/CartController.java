package pyramid.MiniMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cdao;
	
	@RequestMapping(value = "saveCartItem", method=RequestMethod.POST)
	public void addCartItem(Cart cart)
	{
		cdao.saveCartDetails(cart);
	}
	
	
	@RequestMapping("/cart")
	public ModelAndView getProducts()
	{
		List<Cart> clist = cdao.getCartDetails();
		return new ModelAndView("cart", "cartList", clist);
	}
	
}
