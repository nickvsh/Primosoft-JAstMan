package com.primosoft.astman.core.db.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
public interface FunctionResult<Result> {
	Result buildResult(ResultSet resultSet) throws SQLException;
}
