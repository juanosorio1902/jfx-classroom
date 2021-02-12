package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Classroom {
	
	private UserAccount activeUser;
	
	private ArrayList<UserAccount> listAccounts = new ArrayList<UserAccount>();

	public boolean verifyUsername(String username) {
		boolean exists = false;
		
		for(int i=0; i<listAccounts.size() && !exists; i++) {
			if(username.equals(listAccounts.get(i).getUsername())) {
				exists = true;
			}
		}
		
		return exists;
	}
	public boolean verifyCredentials(String username, String password) {
		boolean exists = false;
		boolean credentials = false;
		
		for(int i=0; i<listAccounts.size() && !exists; i++) {
			if(username.equals(listAccounts.get(i).getUsername())) {
				credentials = listAccounts.get(i).verifyPassword(password);
				if(credentials) {
					activeUser = listAccounts.get(i);
				}
				exists = true;
			}
		}
		
		return credentials;
	}
	public void createAccount(String username, String password, String photo, String gender, String career,
			LocalDate birthday, String favBrowser) {
		
		UserAccount user = new UserAccount(username, password, photo, gender, career, birthday, favBrowser);
		listAccounts.add(user); 

	}

	public UserAccount getActiveUser() {
		return activeUser;
	}

}
