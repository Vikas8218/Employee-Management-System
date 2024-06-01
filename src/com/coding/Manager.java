package com.coding;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
		private int mid;
		private int sts;
		private String fname;
		private String email;
		private String pwd;
		private String roles;
		private String salary;
		private static Scanner sc = new Scanner(System.in);
		private static Scanner scanner = new Scanner(System.in);
		public static void ViewAllManager(String roles) {
			ArrayList<Manager> al = Dao.ViewAllManager(roles);
			System.out.println("Here is Your Manager Data");
			System.out.println("   UID  FIRST-NAME   EMAIL  ");
			System.out.println("---------------------------------");
			for(Manager m : al) {
				System.out.printf("%5d%10s%25s\n",m.getMid(),m.getFname(),m.getEmail());
			}
			System.out.println("\nPress Enter To Continue...");
			scanner.nextLine();
		}
		public static void ManagerLogin(String roles) {
			System.out.print("Enter Email ID : ");
			String email = sc.next();
			System.out.print("Enter Password : ");
			String pwd = sc.next();
			Manager u = Dao.CheckManager(email,pwd);
			if(u!=null) {
				while(true) {
				Dashboard(u);
				        System.out.println("|~~~~~~~~Manager Panal~~~~~~~~~~~~~|");
				        System.out.println("|******* 1.Add Staff **************|");
				        System.out.println("|******* 2.Remove Staff ***********|");
				        System.out.println("|******* 3.Update Salary(Emp)******|");
				        System.out.println("|******* 4.Mark Attendance(Emp)****|");
				        System.out.println("|******* 5.Mark Active/Unactive ***|");
				        System.out.println("|******* 6.View All Staff(only(act)|");
				        System.out.println("|******* 7. Exit ******************|");
				        System.out.println("          Enter your choice :       ");
				        int choice =sc.nextInt();
				        switch(choice) {
				            case 1 :
				               AddStaff("Staff");
				                break;
				            case 2 :
				                 RemoveStaff("Staff");          
				                break;
				            case 3 :
				            	 UpdateSalary();
				                break;
				            case 4 :
				              
				                break;
				            case 5 :
				               MarkAct("Staff");
				                break;
				            case 6 :
				            	ViewAllUsers();
				            	break;
				            case 7:
				            	
				                System.out.println("\n******Bye__Bye Manager********");
				                System.exit(0);
				                
				                break;
				            default :
				                System.out.println("*****try Again!*****");
				        }
				        }
				    } else {
				        System.out.println("Manager is Not Available");
				    }
			
		}
		public static void ViewAllUsers() {
			ArrayList<Manager> al = Dao.ViewAllUsers();
			 System.out.println("+-----+------------+-------+");
			System.out.println( "|UID  |FIRST-NAME  | Salary|");
			System.out.println( "+-----+------------+-------+");
			for(Manager m : al) {
				System.out.printf("%5d|%12s|%8s|\n",m.getMid(),m.getFname(),m.getSalary());
			}
			System.out.println("+-----+------------+-------+");
		}
		public static void Dashboard(Manager u) {
			System.out.println("Welcome, "+u.getFname());
		}
			public static void AddStaff(String roles) {
				System.out.print("Enter First Name : ");
				String fname = sc.next();
				System.out.print("Enter Email : ");
				String email = sc.next();
				System.out.print("Enter Password : ");
				String pwd = sc.next();
				Manager u = new Manager(fname,email,pwd,roles);
					    if (Dao.addStaff(u)) {
				        System.out.println("addstaff Added Success!");
				    } else {
				        System.out.println("Failed To Add staff!");
				    }
				}
		public static void AddManager(String roles) {
			System.out.print("Enter First Name : ");
			String fname = sc.next();
			System.out.print("Enter Email : ");
			String email = sc.next();
			System.out.print("Enter Password : ");
			String pwd = sc.next();
			Manager u = new Manager(fname,email,pwd,roles);
			if(Dao.AddManager(u)) {
				System.out.println("Manager Added Success!");
				System.out.println("Welcome! "+u.getFname());
			}else {
				System.out.println("Failed To Add Manager!");
			}
		}
		
		
		//   Remove staff
		public static void RemoveStaff(String roles) {
		    System.out.print("\nEnter ID : ");
		    int id = sc.nextInt();
		    try {
		        if(Dao.RemoveStaff(id))
		            System.out.println("\nStaff Deleted Successfully!");
		        else
		            System.out.println("\nStaff Not Found");
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		//
		public static void MarkAct(String roles) {
			System.out.println("Enter a Staff uid :");
			int uid =sc.nextInt();
			try {
				int sts =-1;
				System.out.println("Press 1 to Active   :");
				System.out.println("Press 0 to Unactive :");
				int ch =sc.nextInt();
				if(ch==1)
					sts=1;
				else if
					(ch==0)
					sts=0;
				else
					System.out.println("Worng Enter !!!");
				if((sts==1)||(sts==0)) 
					 if(Dao.MarkAct(sts,uid))
					System.out.println("press  Successfully !!");
			    	else
			    		System.out.println("Failed To Return !!\n");
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		// Update Salary 
		public static void UpdateSalary( ) {
			//ViewUsers();
			System.out.print("Enter User Id : ");
			int uid = sc.nextInt();
			System.out.print("Enter Salary : ");
			int salary = sc.nextInt();
			if(Dao.UpdateSalary(uid, salary))
				System.out.println("Update Salary Successfully!");
			else
				System.out.println("Salary Updation Failed!");
		}
       public Manager(String fname, String email, String pwd, String roles) {
			super();
			this.fname = fname;
			this.email = email;
			this.pwd = pwd;
			this.roles = roles;
			
		}
	public Manager() {
		super();
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary=salary;
	}
	public int getSts() {
		return sts;
	}
	public void setSts(int sts) {
		this.sts = sts;
	}
	}

