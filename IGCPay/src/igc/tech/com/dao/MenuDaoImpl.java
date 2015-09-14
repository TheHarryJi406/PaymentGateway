package igc.tech.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;


public class MenuDaoImpl extends JdbcTemplate implements MenuDao {
	
public List procMenu(String menuId, String menuDesc,String menuUrl,String parentMenu, String createdBy,String updatedBy, String flag) {
		
//		String packageName="UTILITIES";
		String procName = "PROC_MENU";
		SimpleJdbcCall call = new SimpleJdbcCall(this);
	
	call = call.withProcedureName(procName);
	
	call.addDeclaredParameter(new SqlParameter("IN_FLAG", OracleTypes.CHAR));
	call.addDeclaredParameter(new SqlParameter("IN_MENU_ID", OracleTypes.NUMBER));
	call.addDeclaredParameter(new SqlParameter("IN_MENU_DESC", OracleTypes.VARCHAR));
	call.addDeclaredParameter(new SqlParameter("IN_MENU_URL", OracleTypes.VARCHAR));
	call.addDeclaredParameter(new SqlParameter("IN_PARENT_MENU", OracleTypes.NUMBER));
	call.addDeclaredParameter(new SqlParameter("IN_CREATED_BY", OracleTypes.VARCHAR));
	call.addDeclaredParameter(new SqlParameter("IN_UPDATED_BY", OracleTypes.VARCHAR));
	
	
	
	Map<String, Object> inp = new HashMap<String, Object>();
	inp.put("IN_FLAG", flag);
	inp.put("IN_MENU_ID", menuId);
	inp.put("IN_MENU_DESC", menuDesc);
	inp.put("IN_MENU_URL", menuUrl);
	inp.put("IN_PARENT_MENU", parentMenu);
	inp.put("IN_CREATED_BY", createdBy);
	inp.put("IN_UPDATED_BY", updatedBy);
	
	Map<String, Object> resultMap = call.execute(inp);
	
	return (ArrayList<Map>) resultMap.get("OUT_DATA");


}

}
