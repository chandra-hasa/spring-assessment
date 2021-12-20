package banking.assignment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//database
@Entity
@Table(name="acc_db")
public class AccountEntity {
	
	//database-columns
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ACC_NUM")
	private int anum;
	
	@Column(name="ACC_TYPE")
	private String accType;
	
	@Column(name="BALANCE")
	private int balance;
	
	//getters and setters
	public int getAid() {
		return anum;
	}
	public void setAid(int aid) {
		this.anum = aid;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
