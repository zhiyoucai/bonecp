/*

Copyright 2009 Wallace Wadge

This file is part of BoneCP.

BoneCP is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

BoneCP is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with BoneCP.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.jolbox.bonecp;

import java.sql.SQLException;
import java.sql.Statement;


/**
 * Interface to the JDBC statement cache.
 *
 * @author wallacew
 */
public interface IStatementCache {
	/**
	 * Retrieves the cached statement identified by the given key
	 *
	 * @param sql SQL statement
	 * @return Statement, or null if not found.
	 */
	Statement get(String sql);

	/**
	 * Stores the given Statement in a cache.
	 *
	 * @param key SQL statement
	 * @param value JDBC Statement
	 * @throws SQLException on error
	 */
	void put(String key, Statement value) throws SQLException;

	/**
	 * Returns size of the softcache.  
	 *
	 * @return cache size
	 */
	int size();
	/**
	 * Returns size of the hard cache.
	 *
	 * @return hard cache size.
	 */
	int sizeHardCache();

	/**
	 * Returns the size of the queue of identical JDBC statements identified
	 * by the given SQL key
	 *
	 * @param sql
	 * @return queue size
	 */
	int sizeOfQueue(String sql);
	/**
	 * Removes the prepared statement sql cache
	 *
	 * @param sql statement cache to remove
	 */
	void remove(String sql);
	/**
	 * Clears the cache
	 *
	 */
	void clear();

	/**
	 * Retrieves the cached statement identified by the given key
	 *
	 * @param sql SQL Statement
	 * @param resultSetType a result set type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE
	 * @param resultSetConcurrency a concurrency type; one of ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE
	 * @param resultSetHoldability a ResultSet holdability constant; one of ResultSet.HOLD_CURSORS_OVER_COMMIT or ResultSet.CLOSE_CURSORS_AT_COMMIT
	 * @return Statement, or null if not found.
	 */
	Statement get(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability);

	/**
	 * Retrieves the cached statement identified by the given key
	 *
	 * @param sql SQL Statement
	 * @param resultSetType  a result set type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE
	 * @param resultSetConcurrency  a concurrency type; one of ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE
	 * @return Statement, or null if not found.
	 */
	Statement get(String sql, int resultSetType,
			int resultSetConcurrency);

	/**
	 * Retrieves the cached statement identified by the given key
	 *
	 * @param sql SQL Statement
	 * @param autoGeneratedKeys a flag indicating whether auto-generated keys should be returned; one of Statement.RETURN_GENERATED_KEYS or Statement.NO_GENERATED_KEYS
	 * @return Statement, or null if not found.
	 */
	Statement get(String sql, int autoGeneratedKeys);

	/**
	 * Retrieves the cached statement identified by the given key
	 *
	 * @param sql SQL Statement
	 * @param columnIndexes an array of column indexes indicating the columns that should be returned from the inserted row or rows
	 * @return Statement, or null if not found.
	 */
	Statement get(String sql, int[] columnIndexes);

	/**
	 * Retrieves the cached statement identified by the given key
	 *
	 * @param sql SQL Statement
	 * @param columnNames an array of column names indicating the columns that should be returned from the inserted row or rows
	 * @return Statement, or null if not found.
	 */
	Statement get(String sql, String[] columnNames);

	
	/** Calculates a cache key. 
	 * @param sql SQL Statement
	 * @param columnNames an array of column names indicating the columns that should be returned from the inserted row or rows
	 * @return cache key
	 */
	String calculateCacheKey(String sql, String[] columnNames);

	/** Returns a cache key.
	 * @param sql SQL Statement
	 * @param columnIndexes an array of column indexes indicating the columns that should be returned from the inserted row or rows
	 * @return cache key
	 */
	String calculateCacheKey(String sql, int[] columnIndexes);

	/** Returns a cache key.
	 * @param sql SQL Statement
	 * @param autoGeneratedKeys
	 * @return cache key.
	 */
	String calculateCacheKey(String sql, int autoGeneratedKeys);

	/** Returns a cache key.
	 * @param sql SQL Statement
	 * @param resultSetType  a result set type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE
	 * @param resultSetConcurrency a concurrency type; one of ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE
	 * @return cache key.
	 */
	String calculateCacheKey(String sql, int resultSetType,
			int resultSetConcurrency);

	/** Returns a cache key.
	 * @param sql SQL Statement
	 * @param resultSetType  a result set type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE
	 * @param resultSetConcurrency a concurrency type; one of ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE
	 * @param resultSetHoldability a ResultSet holdability constant; one of ResultSet.HOLD_CURSORS_OVER_COMMIT or ResultSet.CLOSE_CURSORS_AT_COMMIT
	 * @return cache key.
	 */
	String calculateCacheKey(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability);
}
