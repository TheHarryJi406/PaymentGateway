package igc.tech.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller

class IndexController
{
	
	@RequestMapping (value="/",method = RequestMethod.GET)
	public String home(Model model)
	{	
		model.addAttribute("data", "test");
		return "index";
		
	}

}
