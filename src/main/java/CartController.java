import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	@Autowired
	CartDAO cartDAO = new CartDAO();
	
	@RequestMapping("addToCart")
	public ModelAndView addProductDetails() {
		
//		change add to corresponding jsp
		return new ModelAndView("add", "command", new Product());
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveAuthorDetails(@ModelAttribute("cart") Cart cart) {
		cartDAO.saveCartDetails(cart);
		return new ModelAndView("redirect:/index.jsp");
	}

	@RequestMapping("viewCart")
	public ModelAndView displayByCategory(String category) {
		List<Cart> cartList = cartDAO.getCartDetails();
		
//		change view to corresponding jsp
		return new ModelAndView("view", "cartList", cartList);
	}

	
}
