
public class driver {
	public static dbConnect con = new dbConnect();
	public static rjcLoginFrame login;
	public static eagleCredFrame eagleCred;
	public static databaseFrame database;
	public static rjcLogoutFrame logout;
	
	public static void main(String[]args){
		
		login = new rjcLoginFrame();
		eagleCred = new eagleCredFrame();
		database = new databaseFrame();
		logout = new rjcLogoutFrame();
		
	}
}
