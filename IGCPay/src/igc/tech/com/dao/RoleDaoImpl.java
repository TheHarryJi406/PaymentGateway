package igc.tech.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;




public class RoleDaoImpl extends JdbcTemplate implements RoleDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/
	
	@Override
	public List procRole(String roleId, String roleDesc,String createdBy,String updatedBy, String flag) {
		
//		String packageName="UTILITIES";
		String procName = "PROC_ROLE";
		SimpleJdbcCall call = new SimpleJdbcCall(this);

		
		
		
//		call=call.withCatalogName(packageName);
		call = call.withProcedureName(procName);
		
		call.addDeclaredParameter(new SqlParameter("IN_FLAG", OracleTypes.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_ROLE_ID", OracleTypes.NUMBER));
		call.addDeclaredParameter(new SqlParameter("IN_ROLE_DESC", OracleTypes.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_CREATED_BY", OracleTypes.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_UPDATED_BY", OracleTypes.VARCHAR));
		
		
		
		Map<String, Object> inp = new HashMap<String, Object>();
		inp.put("IN_FLAG", flag);
		inp.put("IN_ROLE_ID", roleId);
		inp.put("IN_ROLE_DESC", roleDesc);
		inp.put("IN_CREATED_BY", createdBy);
		inp.put("IN_UPDATED_BY", updatedBy);
		
		Map<String, Object> resultMap = call.execute(inp);
		
		return (ArrayList<Map>) resultMap.get("OUT_DATA");
	
	}
	
	

	
}
