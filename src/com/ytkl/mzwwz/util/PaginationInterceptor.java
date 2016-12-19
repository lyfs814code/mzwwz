package com.ytkl.mzwwz.util;

import java.sql.Connection;
import java.util.Properties;

import javax.naming.ConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor{

	private final static Log log = LogFactory.getLog(PaginationInterceptor.class);
	
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		StatementHandler statmentHandler = (StatementHandler)invocation.getTarget();
	    BoundSql boundSql = statmentHandler.getBoundSql();
	    MetaObject metaStatementHandler = MetaObject.forObject(statmentHandler);
	    RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
	    if(rowBounds == null || rowBounds == RowBounds.DEFAULT) {
	    	return invocation.proceed();
	    }
	    Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
	    Dialect.Type databaseType = null;
	    try{          
	    	databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());      
	    } catch(Exception e){        
	    	throw new ConfigurationException("the value of the dialect property in mybatis-config.xml is not defined : "+ configuration.getVariables().getProperty("dialect")); 
	    }
	    Dialect dialect =null;
	    switch(databaseType){         
	    	case MYSQL: dialect =new MySQL5Dialect();break;
	    	case ORACLE : dialect = new OrcaleDialect();
	    }
	       
	    String originalSql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");     
	    metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getPaginationSql(originalSql,rowBounds.getOffset(), rowBounds.getLimit()) );      
	    metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET );      
	    metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT );      
	    if(log.isDebugEnabled()){          
	    	log.debug("limit SQL : "+ boundSql.getSql());      
	    }
	    return invocation.proceed();
	}

	
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}