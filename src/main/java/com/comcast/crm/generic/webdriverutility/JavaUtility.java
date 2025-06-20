package com.comcast.crm.generic.webdriverutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Pattern;


public class JavaUtility {

	 public int createRandomNumber() {
		 Random r=new Random();
		 int randomnum = r.nextInt(1000, 9999);
		 return randomnum;
	 }
	 
	 public LocalDate getDate() {
		 
		 LocalDate todaydate = LocalDate.now();
		return todaydate;
	 }
	 
 public LocalDate getDatePuleDays() {
		 
		 LocalDate todaydate = LocalDate.now().plusDays(30);
		return todaydate;
	 }
 
 
	 public long createRandomPhoneNumber() {
		 Random r=new Random();
		 long randomnum = r.nextInt(100000000,999999999);
		 return randomnum;
	 }
	 
	 
	 public int createRandomNumberForIndustry() {
		 Random r=new Random();
		 int randomnum = r.nextInt(2,29);
		 return randomnum;
	 }
	 
	 public int createRandomNumberForType() {
		 Random r=new Random();
		 int randomnum = r.nextInt(2,9);
		 return randomnum;
	 }
	 
	 
	 public int createRandomNumberForCategory() {
		 Random r=new Random();
		 int randomnum = r.nextInt(1,3);
		 return randomnum;
	 }
	 
	 
}
