package igc.tech.com.controller;

import igc.tech.com.dao.RoleDao;

import java.text.SimpleDateFormat;
import java.util.Date;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
@RequestMapping (value="/role")
class RoleController
{
	
	@Autowired
	RoleDao roleDao;
	
	@RequestMapping (value="/view",method = RequestMethod.GET)
	public String view(Model model)
	{	
		
		List<Map> list=roleDao.procRole(null, null, null, null, "a");
		model.addAttribute("dataList", list);
		model.addAttribute("view", true);
//		System.out.println(list);
		return "role";
		
	}
	
	
	@RequestMapping (value="/add",method = RequestMethod.GET)
	public String add( Model model)
	{	
		
		model.addAttribute("add", true);
		return "role";
		
	}
	
	
	@RequestMapping (value="/add",method = RequestMethod.POST)
	public String add(@RequestParam (value="id") String id , 
					@RequestParam (value="description") String roleDesc ,Model model)
	{	
		
		List<Map> list=roleDao.procRole(null, roleDesc, "tilak",null, "i");
		Map  map=(Map)list.get(0);
		System.out.println(map);
		model.addAttribute("dataStatus", map);
		model.addAttribute("add", true);
		
		System.out.println(id+roleDesc);
		return view(model);
		
	}
	
	@RequestMapping (value="/edit/{id}",method = RequestMethod.GET)
	public String edit(@PathVariable (value="id") String id ,   Model model)
	{	
		
		List<Map> list=roleDao.procRole(id, null, null, null, "s");
		Map  map=(Map)list.get(0);
		
		model.addAttribute("dataMap", map);
		model.addAttribute("edit", true);
		return "role";
		
	}
	
	@RequestMapping (value="/edit",method = RequestMethod.POST)
	public String edit(@RequestParam (value="id") String id , 
					@RequestParam (value="description") String roleDesc ,Model model)
	{	
		
		List<Map> list=roleDao.procRole(id, roleDesc, null, "tilak", "u");
		Map  map=(Map)list.get(0);
		
		model.addAttribute("dataStatus", map);
		return view(model);
		
	}
	
	@RequestMapping (value="/delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable (value="id") String id ,   Model model)
	{	
		
		List<Map> list=roleDao.procRole(id, null, null, null, "d");
		Map  map=(Map)list.get(0);
		
		model.addAttribute("dataStatus", map);
//		model.addAttribute("delete", true);
		return view(model);
		
	}

	
	
}
