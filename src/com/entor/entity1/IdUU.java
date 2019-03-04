package com.entor.entity1;

import java.util.UUID;

public class IdUU {
	
public static   String UU() {
	 String uuid = UUID.randomUUID().toString();
     return uuid.replaceAll("-", "");
	
}
/*public static void main(String[] args) {
	 String uuid = UUID.randomUUID().toString().replaceAll("-", "");
     System.out.println(uuid);
}*/
}
