package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Classroom {
	
	private UserAccount activeUser;
	private ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();

	public boolean verifyUsername(String username) {
		boolean exists = false;
		
		for(int i=0; i<accounts.size() && !exists; i++) {
			if(username.equals(accounts.get(i).getUsername())) {
				exists = true;
			}
		}
		
		return exists;
	}
	public boolean verifyCredentials(String username, String password) {
		boolean exists = false;
		boolean credentials = false;
		
		for(int i=0; i<accounts.size() && !exists; i++) {
			if(username.equals(accounts.get(i).getUsername())) {
				credentials = accounts.get(i).verifyPassword(password);
				if(credentials) {
					activeUser = accounts.get(i);
				}
				exists = true;
			}
		}
		
		return credentials;
	}
	public String searchPhoto(String username) {
		String photo = "";
		for(int i=0; i<accounts.size(); i++) {
			if((username.equals(accounts.get(i).getUsername()))){
				photo = accounts.get(i).getPhoto();
			}
		}
		return photo;
		
	}
	public void createAccount(String username, String password, String photo, String gender, String career,
			LocalDate birthday, String favBrowser) {
		
		UserAccount user = new UserAccount(username, password, photo, gender, career, birthday, favBrowser);
		accounts.add(user); 

	}
	public UserAccount getActiveUser() {
		return activeUser;
	}
	public ArrayList<UserAccount> getUsers(){
		return accounts;
		
	}

	

}
