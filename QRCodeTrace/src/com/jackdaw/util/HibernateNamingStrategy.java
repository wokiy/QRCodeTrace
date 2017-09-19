package com.jackdaw.util;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;

/**
 * HIBERNATE 数据库字段命名规则：小写，单词分割使用下划线
 */
@SuppressWarnings("deprecation")
public class HibernateNamingStrategy extends ImprovedNamingStrategy implements NamingStrategy {
	private static final long serialVersionUID = 1L;

	@Override
	public String columnName(String columnName) {
		return addUnderscores(columnName).toLowerCase();
	}

	@Override
	public String tableName(String tableName) {
		return addUnderscores(tableName).toLowerCase();
	}

}