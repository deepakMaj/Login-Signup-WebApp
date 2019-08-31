package org.deepak.login;

public class Verification {
	
		public boolean dataverify(String data) {
			int count = 0;
			String[] arr = {"@","!","#","$","%","^","&","*","(",")","-","_","=","+","?","<",">",";",":","{","}","[","]","\",","|"};
			for(int i=0;i<arr.length;i++) {
				if(data.contains(arr[i])) {
					count = count + 1;
				}
			}
			if(count >= 1) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean emailverify(String email) {
			int count = 0;
			boolean data = false;
			String[] arr = {"!","#","$","%","^","&","*","(",")","-","_","=","+","?","<",">",";",":","{","}","[","]","\",","|"};
			for(int i=0;i<arr.length;i++) {
				if(email.contains(arr[i])) {
					count = count + 1;
				}
			}
			if(email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@gmail.in") || email.endsWith("@yahoo.in")) {
				data = true;
			}
			else {
				data = false;
			}
			if(count >= 1 || data == false) {
				return true;
			}
			else {
				return false;
			}
		}
}