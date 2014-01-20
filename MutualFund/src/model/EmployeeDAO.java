package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.CustomerBean;
import databeans.EmployeeBean;
/*
 * Employee DAO
 * Yusi Jan 19 Version 1.0
 * co-author:
 * Notice! Username is the primarykey of table employee 
 */
public class EmployeeDAO extends GenericDAO<EmployeeBean>{

	public EmployeeDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(EmployeeBean.class, tableName, cp);
	}
	
	/*
	 * Create New Employee Account (used by employee only)
	 * @param employeebean
	 * @return void
	 */
	public void createNewEmployee(EmployeeBean eb) throws RollbackException{
		try{
			Transaction.begin();
			create(eb);
			Transaction.commit();
		}finally{
			if(Transaction.isActive()) Transaction.rollback();
		}
	}
	
	/*
	 * Check Password
	 * @param employee username, password
	 * @return true if the password is correct otherwise false
	 */
	public boolean checkPassword(String username, String password) throws RollbackException{
		
			EmployeeBean eb = read(username);
			if(eb==null) {
//				throw new RollbackException("User "+db.getUsername()+" no longer exists");
				return false;
			}
			if(eb.getPassword().equals(password)) return true;
			else return false;
		
	}
	
	/*
	 * Change password
	 * @param username, password
	 * @return void
	 */
	public void changePassword(String username, String password) throws RollbackException{
		try{
			Transaction.begin();
			EmployeeBean eb = read(username);
			
			if(eb==null) {
				throw new RollbackException("User "+eb.getUsername()+" no longer exists");
			}
			
			eb.setPassword(password);
			
			update(eb);
			Transaction.commit();
		}finally {
			if(Transaction.isActive()) Transaction.rollback();
		}
	}
	
	

}