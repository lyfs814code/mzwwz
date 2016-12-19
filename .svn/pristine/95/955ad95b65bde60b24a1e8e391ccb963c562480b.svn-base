package com.ytkl.mzwwz.util;

public class OrcaleDialect implements Dialect {

	public String getPaginationSql(String sql, int offset, int limit) {
		// TODO Auto-generated method stub
		return "select * from (select rownum rn, t.* from (" + sql
	         + ") t ) t1 where t1.rn > " + offset +" and t1.rn <="+(offset+limit);
	 }

}
