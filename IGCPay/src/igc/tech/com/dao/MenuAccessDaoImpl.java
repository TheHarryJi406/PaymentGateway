package igc.tech.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oracle.jdbc.driver.OracleTypes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class MenuAccessDaoImpl extends JdbcTemplate implements MenuAccessDao {
	
	public List procMenuAccess(String id, String roleId,String menuId,String createdBy,String updatedBy, String flag) {
		
		String procName = "PROC_MENU_ACCESS";
		SimpleJdbcCall call = new SimpleJdbcCall(this);
	
	call = call.withProcedureName(procName);
	
	call.addDeclaredParameter(new SqlParameter("IN_FLAG", OracleTypes.CHAR));
	call.addDeclaredParameter(new SqlParameter("IN_MENU_ACCESS_ID", OracleTypes.NUMBER));
	call.addDeclaredParameter(new SqlParameter("IN_ROLE_ID", OracleTypes.NUMBER));
	call.addDeclaredParameter(new SqlParameter("IN_MENU_ID", OracleTypes.NUMBER));
	call.addDeclaredParameter(new SqlParameter("IN_CREATED_BY", OracleTypes.VARCHAR));
	call.addDeclaredParameter(new SqlParameter("IN_UPDATED_BY", OracleTypes.VARCHAR));
	
	
	
	Map<String, Object> inp = new HashMap<String, Object>();
	inp.put("IN_FLAG", flag);
	inp.put("IN_MENU_ACCESS_ID", id);
	inp.put("IN_ROLE_ID", roleId);
	inp.put("IN_MENU_ID", menuId);
	inp.put("IN_CREATED_BY", createdBy);
	inp.put("IN_UPDATED_BY", updatedBy);
	
	Map<String, Object> resultMap = call.execute(inp);
	
	return (ArrayList<Map>) resultMap.get("OUT_DATA");


}

}
