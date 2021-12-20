package banking.assignment.mappings;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cust_db")
public class Customer {

		//database-columns
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column(name="ID")
		private int cid;
		
		@Column(name="CUST_NAME")
		private String name;
		
		public List<Accounts> getAccountList() {
			return accountList;
		}
		public void setAccountList(List<Accounts> accountList) {
			this.accountList = accountList;
		}
		@Column(name="DOB")
		private String dob;
		

		@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
		List<Accounts> accountList;
		
		//Getters and Setters
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
}
	
