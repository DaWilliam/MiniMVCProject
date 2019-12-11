package pyramid.MiniMVCProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller
public class AuthorController {
//    @Autowired
//    AuthorDAO authorDAO;
//
//    @RequestMapping("add")
//    public ModelAndView addAuthorDetails(){
//        return new ModelAndView("add","command",new Author());
//    }
//
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public ModelAndView saveAuthorDetails(@ModelAttribute("author") Author author){
//        authorDAO.saveAuthorDetails(author);
//        return new ModelAndView("redirect:/index.jsp");
//    }
//
//    @RequestMapping("view")
//    public ModelAndView displayAuthorDetails(){
//        List<Author> alist = authorDAO.getAuthorDetails();
//        return new ModelAndView("view","authorList", alist);
//    }
}
