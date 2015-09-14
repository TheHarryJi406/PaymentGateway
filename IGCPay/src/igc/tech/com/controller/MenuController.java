package igc.tech.com.controller;

import igc.tech.com.dao.MenuDao;

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
@RequestMapping (value="/menu")

public class MenuController {
	
	
	@Autowired
	MenuDao menuDao;
	
	@RequestMapping (value="/view",method = RequestMethod.GET)
	public String view(Model model)
	{	
		
		List<Map> list=menuDao.procMenu(null, null, null, null,null,null, "a");
		model.addAttribute("dataList", list);
		model.addAttribute("view", true);
//		System.out.println(list);
		return "menu";
		
	}
	
	
	@RequestMapping (value="/add",method = RequestMethod.GET)
	public String add( Model model)
	{	
		
		model.addAttribute("add", true);
		return "menu";
		
	}
	
	
	@RequestMapping (value="/add",method = RequestMethod.POST)
	public String add(@RequestParam (value="id") String id , 
					@RequestParam (value="description") String menuDesc ,Model model)
	{	
		
		List<Map> list=menuDao.procMenu(null,menuDesc,null,null, "harry",null, "i");
		Map  map=(Map)list.get(0);
		System.out.println(map);
		model.addAttribute("dataStatus", map);
		model.addAttribute("add", true);
		
		System.out.println(id+menuDesc);
		return view(model);
		
	}
	
	@RequestMapping (value="/edit/{id}",method = RequestMethod.GET)
	public String edit(@PathVariable (value="id") String id ,   Model model)
	{	
		
		List<Map> list=menuDao.procMenu(id,null, null, null,null,null, "s");
		Map  map=(Map)list.get(0);
		
		model.addAttribute("dataMap", map);
		model.addAttribute("edit", true);
		return "menu";
		
	}
	
	@RequestMapping (value="/edit",method = RequestMethod.POST)
	public String edit(@RequestParam (value="id") String id , 
					@RequestParam (value="description") String menuDesc ,Model model)
	{	
		
		List<Map> list=menuDao.procMenu(id, menuDesc, null,null,null, "harry", "u");
		Map  map=(Map)list.get(0);
		
		model.addAttribute("dataStatus", map);
		return view(model);
		
	}
	
	@RequestMapping (value="/delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable (value="id") String id ,   Model model)
	{	
		
		List<Map> list=menuDao.procMenu(id, null,null,null, null, null, "d");
		Map  map=(Map)list.get(0);
		
		model.addAttribute("dataStatus", map);
//		model.addAttribute("delete", true);
		return view(model);
		
	}

}
