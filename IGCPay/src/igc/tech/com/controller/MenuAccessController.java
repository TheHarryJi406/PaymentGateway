package igc.tech.com.controller;

import igc.tech.com.dao.MenuAccessDao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping (value="/menuaccess")
public class MenuAccessController {
	
	@Autowired
	MenuAccessDao menuAcessDao;
	
	@RequestMapping (value="/view",method = RequestMethod.GET)
	public String view(Model model)
	{	
		
		List<Map> list=menuAcessDao.procMenuAccess(null,null, null, null,null, "a");
		model.addAttribute("dataList", list);
		model.addAttribute("view", true);
//		System.out.println(list);
		return "menuaccess";
		
	}
	
	
	@RequestMapping (value="/add",method = RequestMethod.GET)
	public String add( Model model)
	{	
		
		model.addAttribute("add", true);
		return "menuaccess";
		
	}
	
	
	@RequestMapping (value="/add",method = RequestMethod.POST)
	public String add(@RequestParam (value="id") String id , 
					@RequestParam (value="roleId") String roleId ,@RequestParam (value="menuId") String menuId, Model model)
	{	
		
		List<Map> list=menuAcessDao.procMenuAccess(null,null,null,"Harry",null, "i");
		Map  map=(Map)list.get(0);
		System.out.println(map);
		model.addAttribute("add", true);
		
		System.out.println(id+roleId+menuId);
		return view(model);
		
	}
	
	@RequestMapping (value="/edit/{id}",method = RequestMethod.GET)
	public String edit(@PathVariable (value="id") String id ,   Model model)
	{	
		
		List<Map> list=menuAcessDao.procMenuAccess(id,null, null, null,null, "s");
		Map  map=(Map)list.get(0);
		
		model.addAttribute("dataMap", map);
		model.addAttribute("edit", true);
		return "menuaccess";
		
	}
	
	@RequestMapping (value="/edit",method = RequestMethod.POST)
	public String edit(@RequestParam (value="id") String id , 
					@RequestParam (value="roleId") String roleId , @RequestParam(value="menuId") String menuId,Model model)
	{	
		
		List<Map> list=menuAcessDao.procMenuAccess(id, null, null,"Harry","Master", "u");
		Map  map=(Map)list.get(0);
		
		return view(model);
		
	}
	
	@RequestMapping (value="/delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable (value="id") String id ,   Model model)
	{	
		
		List<Map> list=menuAcessDao.procMenuAccess(id, null,null,null, null, "d");
		Map  map=(Map)list.get(0);
		
//		model.addAttribute("delete", true);
		return view(model);
		
	}
	
	
	
	

}
