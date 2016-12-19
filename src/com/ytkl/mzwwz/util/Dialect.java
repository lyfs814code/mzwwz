package com.ytkl.mzwwz.util;

public interface Dialect {
	
	public static enum Type {
	       MYSQL {
	           public String getValue(){return "mysql";}
	       },
	       ORACLE {
	           public String getValue() {return "oracle";}
	       };
	       public abstract String getValue();
	    }
	
    public String getPaginationSql(String sql, int offset, int limit);
}
