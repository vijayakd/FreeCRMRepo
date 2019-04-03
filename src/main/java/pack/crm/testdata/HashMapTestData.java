package pack.crm.testdata;

import java.util.HashMap;

public class HashMapTestData {

public static HashMap<String, String> getUserLoginInfo() {

HashMap<String, String> userMap = new HashMap<String, String>();

userMap.put("user1", "vijaya1979_password");
userMap.put("user", "vijaya1000_password");

return userMap;
}

public static HashMap<Integer, String> monthMap() {
	
	HashMap<Integer, String> monMap = new HashMap<Integer, String>();

	monMap.put(1, "January");
	monMap.put(1, "February");
	monMap.put(1, "March");
	monMap.put(1, "April");
	monMap.put(1, "May");
	monMap.put(1, "June");
	monMap.put(1, "July");
	monMap.put(1, "August");
	monMap.put(1, "September");
	monMap.put(1, "October");
	monMap.put(1, "November");
	monMap.put(1, "December");
return monMap;
	
}



























}
