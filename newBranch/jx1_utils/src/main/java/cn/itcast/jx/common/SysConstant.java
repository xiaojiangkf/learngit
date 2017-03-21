package cn.itcast.jx.common;

import org.apache.log4j.Logger;

import com.google.inject.spi.UntargettedBinding;

/**
 * @Description:
 * @Author:		传智播客 java学院	传智.袁新奇
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月31日
 */
/*
 * 系统全局常量配置类
 */
public class SysConstant {
	private static Logger log = Logger.getLogger(SysConstant.class);

	public static String CURRENT_USER_INFO = "_CURRENT_USER";	//当前用户session name
	public static String USE_DATABASE = "MySql";				//使用的数据库 Oracle/SQLServer
	public static String USE_DATABASE_VER = "5.0";				//使用的数据库版本 10g/2000

	public static String DEFAULT_PASS = "123456";				//默认密码
	public static int PAGE_SIZE = 5;							//分页时一页显示多少条记录
	
	public static int DEPT_ENABLED=1;	// Dept启用
	public static int DEPT_DISABLED=0;	// Dept不启用
	
	public static int USER_ENABLED=1;	// User启用
	public static int USER_DISABLED=0;	// User不启用
	
	public static int MODULE_ENABLED=1;	// Module启用
	public static int MODULE_DISABLED=0;	// Module不启用
	
	
	
	
	
	
	
	
	
	
}
