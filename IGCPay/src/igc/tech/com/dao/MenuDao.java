package igc.tech.com.dao;

import java.util.List;


public interface MenuDao {
	
	
	public List procMenu(String menuId, String menuDesc,String menuUrl,String parentMenu, String createdBy,String updatedBy, String flag);
	

}
