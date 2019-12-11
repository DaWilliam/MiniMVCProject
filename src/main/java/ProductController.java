import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;

	@RequestMapping("addProduct")
	public ModelAndView addProductDetails() {
		
//		change add to corresponding jsp
		return new ModelAndView("add", "command", new Product());
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveAuthorDetails(@ModelAttribute("product") Product product) {
		productDAO.saveProductDetails(product);
		return new ModelAndView("redirect:/index.jsp");
	}

	@RequestMapping("viewByCat")
	public ModelAndView displayByCategory(String category) {
		List<Product> catList = productDAO.findByCategory(category);
		
//		change view to corresponding jsp
		return new ModelAndView("view", "catList", catList);
	}

	@RequestMapping("viewByName")
	public ModelAndView displayByName(String name) {
		List<Product> nameList = productDAO.findByName(name);
		
//		change view to corresponding jsp	
		return new ModelAndView("view", "nameList", nameList);
	}
}
