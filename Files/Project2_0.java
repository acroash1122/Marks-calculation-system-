import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Project2_0{
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) throws IOException{


		String[] course;
		int[][] marks;
		String path1;
		File marksList; 
		String path2;
		File courses;
		String path;
		File studentNo;
		int n=0;
		Scanner input;
		int stud = 0;

	System.out.println("WELCOME TO A.M.A.U MARKS CALCULATION SYSTEM");
	System.out.println();
	boolean flag1 = true;
	int tryy = 3;
	while(flag1){
		System.out.println("------ LOGIN PAGE ------");
		System.out.println("Press 1 ... if you already have an account");
		System.out.println("Press 2 ... for creating an account");
		System.out.println("Press 0 ... for exiting");
		try{
			System.out.println();
			System.out.print("ENTER CHOICE: ");
			int select = obj.nextInt();
	     	System.out.println();
	     	switch(select){
	     		case 1: obj.nextLine();
	     				while(tryy>=0){
		     				System.out.println("ENTER USERNAME");
		     				String uName = obj.nextLine();
		     				System.out.println("ENTER PASSOWRD");
		     				String pass = obj.nextLine();
		     			
		     				path1 = "accounts.txt";
							BufferedReader reader = new BufferedReader(new FileReader(path1));
							ArrayList<String> arr = new ArrayList<>();
							String line;
		     			
		     				while((line = reader.readLine()) != null){
								String name = line;
								String password = reader.readLine();
								arr.add(name);
								arr.add(password);
		     				}
							reader.close();
		     				boolean forBreak = false;
		     				for(int i=0 ; i<arr.size()-1 ; i++){
		     					for(int j=i+1 ; j<arr.size() ;j++){
		     						if(uName.equals(arr.get(i)) && pass.equals(arr.get(j))){
		     							System.out.println();
		     							System.out.println("*******************************");
		     							System.out.println("You have successfully logged in");
		     							System.out.println("*******************************");
		     							System.out.println();
		     							forBreak = true;
		     							break;
		     						}
		     					}
		     					if(forBreak)
		     						break;
		     				}

		     				if(forBreak){
		     					boolean flag2 = true;
								while(flag2){
									// For selecting correct option for semester and displaying table

									System.out.println("Choose the semester you want to check");
									System.out.println("Press 1 ... for 1st semester");
									System.out.println("Press 2 ... for 2nd semester");
									System.out.println("Press 3 ... for 3rd semester");
									System.out.println("Press 4 ... for 4th semester");
									System.out.println("Press 0 ... for exiting");

									try{
										System.out.println();
										System.out.print("ENTER CHOICE: ");
										int choice = obj.nextInt();
							     		System.out.println();		  
										switch(choice){
										case 1 :	path = "student_of_1_sem.txt";
													studentNo = new File(path);
												 	path1 = "marks_of_semester1.txt";
													marksList = new File(path1);
													path2 = "first_semester.txt";
													courses = new File(path2);

													input = new Scanner(studentNo);
													stud = input.nextInt();

													input = new Scanner(courses);
													course = new String[5];
													
													n=0;
													while(input.hasNext()){
														course[n] = input.nextLine();
														n++;
													}
								
													marks = new int[stud][5];
													input = new Scanner(marksList);
													for(int i=0 ; i<stud ; i++){
														for(int j=0 ; j<5; j++){
														marks[i][j] = input.nextInt();
														}
													}

													displayTable(marks , course);

													boolean endLoop = false;
													while(!endLoop){
														System.out.println("\n _____________ MENU ______________");
														System.out.println("\nPress 1 ... for calculating total marks of student");
														System.out.println("Press 2 ... for calculating average marks of a subject");
														System.out.println("Press 3 ... for finding a student's highest marks from all subjects");
														System.out.println("Press 4 ... for finding a student's lowest marks from all subjects");
														System.out.println("Press 5 ... for displaying the table");
														System.out.println("Press 6 ... for finding student who has highest total marks");
														System.out.println("Press 7 ... for finding student who has lowest total marks");
														System.out.println("Press 8 ... for seeing GPA and grades of a student");
														System.out.println("Press 0 ... for exiting the MENU");

														try{
															System.out.println();
															System.out.print("ENTER OPTION: ");
															int option = obj.nextInt();
															System.out.println();
															switch(option){
																case 1 : total_Marks(marks);
																break;

																case 2 : avg_Subject(marks,course);
																break;

																case 3 : stud_Highest(marks , course);
																break;

																case 4 : stud_Lowest(marks , course);
																break;

																case 5 : displayTable(marks , course);
																break;

																case 6 : highest_marks(marks , course);
																break;

																case 7 : lowest_marks(marks , course);
																break;

																case 8 : showGPA(marks , course , 5);
																break;

																case 0 : System.out.println("EXITING MENU...");
																		 System.out.println();
																		 endLoop = true;
																break;

																default: System.out.println("INVALID OPTION.. TRY AGAIN");
																		 System.out.println();
															}
														}
														catch(Exception ex){
															System.out.println();		  
															System.out.println("INVALID OPTION.. TRY AGAIN");
	     													System.out.println();		  
															obj.nextLine();
														}


													}	
													
										break; 

										case 2 :	path = "student_of_2_sem.txt";
													studentNo = new File(path);
													path1 = "marks_of_semester2.txt";
													marksList = new File(path1);
													path2 = "second_semester.txt";
													courses = new File(path2);

													input = new Scanner(studentNo);
													stud = input.nextInt();

													course = new String[5];
													input = new Scanner(courses);
													
													n=0;
													while(input.hasNext()){
														course[n] = input.nextLine();
														n++;
													}
													marks = new int[stud][5];
													input = new Scanner(marksList);
													for(int i=0 ; i<stud ; i++){
														for(int j=0 ; j<5 ; j++){
														marks[i][j] = input.nextInt();
														}
													}

													displayTable(marks , course);

													boolean endLoop1 = false;
													while(!endLoop1){
														System.out.println("\n _____________ MENU ______________");
														System.out.println("\nPress 1 ... for calculating total marks of student");
														System.out.println("Press 2 ... for calculating average marks of a subject");
														System.out.println("Press 3 ... for finding a student's highest marks from all subjects");
														System.out.println("Press 4 ... for finding a student's lowest marks from all subjects");
														System.out.println("Press 5 ... for displaying the table");
														System.out.println("Press 6 ... for finding student who has highest total marks");
														System.out.println("Press 7 ... for finding student who has lowest total marks");
														System.out.println("Press 8 ... for seeing GPA and grades of a student");
														System.out.println("Press 0 ... for exiting the MENU");

														try{
															System.out.println();
															System.out.print("ENTER OPTION: ");
															int option = obj.nextInt();
															System.out.println();
															switch(option){
																case 1 : total_Marks(marks);
																break;

																case 2 : avg_Subject(marks,course);
																break;

																case 3 : stud_Highest(marks , course);
																break;

																case 4 : stud_Lowest(marks , course);
																break;

																case 5 : displayTable(marks , course);
																break;

																case 6 : highest_marks(marks , course);
																break;

																case 7 : lowest_marks(marks , course);
																break;

																case 8 : showGPA(marks , course , 5);
																break;

																case 0 : System.out.println("EXITING MENU...");
																		 System.out.println();
																		 endLoop1 = true;
																break;

																default: System.out.println("INVALID OPTION.. TRY AGAIN");
																		 System.out.println();
															}
														}
														catch(Exception ex){
															System.out.println();		  
															System.out.println("INVALID OPTION.. TRY AGAIN");
	     													System.out.println();		  
															obj.nextLine();
														}

													}

										break;

										case 3 :	path = "student_of_3_sem.txt";
													studentNo = new File(path);
												 	path1 = "marks_of_semester3.txt";
													marksList = new File(path1);
													path2 = "third_semester.txt";
													courses = new File(path2);

													input = new Scanner(studentNo);
													stud = input.nextInt();

													course = new String[5];
													input = new Scanner(courses);
													
													n=0;
													while(input.hasNext()){
														course[n] = input.nextLine();
														n++;
													}
								
													marks = new int[stud][5];
													input = new Scanner(marksList);
													for(int i=0 ; i<stud ; i++){
														for(int j=0 ; j<5 ; j++){
														marks[i][j] = input.nextInt();
														}
													}

													displayTable(marks , course);

													boolean endLoop2 = false;
													while(!endLoop2){
														System.out.println("\n _____________ MENU ______________");
														System.out.println("\nPress 1 ... for calculating total marks of student");
														System.out.println("Press 2 ... for calculating average marks of a subject");
														System.out.println("Press 3 ... for finding a student's highest marks from all subjects");
														System.out.println("Press 4 ... for finding a student's lowest marks from all subjects");
														System.out.println("Press 5 ... for displaying the table");
														System.out.println("Press 6 ... for finding student who has highest total marks");
														System.out.println("Press 7 ... for finding student who has lowest total marks");
														System.out.println("Press 8 ... for seeing GPA and grades of astudent");
														System.out.println("Press 0 ... for exiting the MENU");

														try{
															System.out.println();
															System.out.print("ENTER OPTION: ");
															int option = obj.nextInt();
															System.out.println();
															switch(option){
																case 1 : total_Marks(marks);
																break;

																case 2 : avg_Subject(marks,course);
																break;

																case 3 : stud_Highest(marks , course);
																break;

																case 4 : stud_Lowest(marks , course);
																break;

																case 5 : displayTable(marks , course);
																break;

																case 6 : highest_marks(marks , course);
																break;

																case 7 : lowest_marks(marks , course);
																break;

																case 8 : showGPA(marks , course , 5);
																break;

																case 0 : System.out.println("EXITING MENU...");
																		 System.out.println();
																		 endLoop2 = true;
																break;

																default: System.out.println("INVALID OPTION.. TRY AGAIN");
																		 System.out.println();
															}
														}
														catch(Exception ex){
															System.out.println();		  
															System.out.println("INVALID OPTION.. TRY AGAIN");
	     													System.out.println();		  
															obj.nextLine();
														}
													}	
										break;

										case 4 :	path = "student_of_4_sem.txt";
													studentNo = new File(path);
												 	path1 = "marks_of_semester4.txt";
													marksList = new File(path1);
													path2 = "fourth_semester.txt";
													courses = new File(path2);

													input = new Scanner(studentNo);
													stud = input.nextInt();

													input = new Scanner(courses);
													course = new String[5];
													
													n=0;
													while(input.hasNext()){
														course[n] = input.nextLine();
														n++;
													}
								
													marks = new int[stud][5];
													input = new Scanner(marksList);
													for(int i=0 ; i<stud ; i++){
														for(int j=0 ; j<5; j++){
														marks[i][j] = input.nextInt();
														}
													}

													displayTable(marks , course);

													boolean endLoop3 = false;
													while(!endLoop3){
														System.out.println("\n _____________ MENU ______________");
														System.out.println("\nPress 1 ... for calculating total marks of student");
														System.out.println("Press 2 ... for calculating average marks of a subject");
														System.out.println("Press 3 ... for finding a student's highest marks from all subjects");
														System.out.println("Press 4 ... for finding a student's lowest marks from all subjects");
														System.out.println("Press 5 ... for displaying the table");
														System.out.println("Press 6 ... for finding student who has highest total marks");
														System.out.println("Press 7 ... for finding student who has lowest total marks");
														System.out.println("Press 8 ... for seeing GPA and grades of a student");
														System.out.println("Press 0 ... for exiting the MENU");

														try{
															System.out.println();
															System.out.print("ENTER OPTION: ");
															int option = obj.nextInt();
															System.out.println();
															switch(option){
																case 1 : total_Marks(marks);
																break;

																case 2 : avg_Subject(marks,course);
																break;

																case 3 : stud_Highest(marks , course);
																break;

																case 4 : stud_Lowest(marks , course);
																break;

																case 5 : displayTable(marks , course);
																break;

																case 6 : highest_marks(marks , course);
																break;

																case 7 : lowest_marks(marks , course);
																break;

																case 8 : showGPA(marks , course , 5);
																break;

																case 0 : System.out.println("EXITING MENU...");
																		 System.out.println();
																		 endLoop = true;
																break;

																default: System.out.println("INVALID OPTION.. TRY AGAIN");
																		 System.out.println();
															}
														}
														catch(Exception ex){
															System.out.println();		  
															System.out.println("INVALID OPTION.. TRY AGAIN");
	     													System.out.println();		  
															obj.nextLine();
														}


													}
													break;
								 
										case 0: System.out.println("EXITING SYSTEM....");
												System.out.println();
												flag2 = false;
										break;
												 
										default : System.out.println("INVALID OPTION.. TRY AGAIN"); 
												 System.out.println();		  
										}				
									}
									catch(Exception ex){
							     		System.out.println();		  
										System.out.println("INVALID OPTION.. TRY AGAIN");
							     		System.out.println();		  
										obj.nextLine();
									}
								}

								tryy = -2;
		     				}
		     				else{
		     					System.out.println();
		     					System.out.println("INVALID USRNAME OR PASSWORD.. "+tryy+" tries left");
		     					System.out.println();
		     					tryy--;
		     				}
	     				}
	     				
	     				flag1= false;
	     		break;

	     		case 2: obj.nextLine();
	     				String newName = "";
	     				String newPass = "";

	     				while(true){
	     					System.out.println("ENTER USERNAME");
	     					newName = obj.nextLine();
	     					if(newName.length()>2 && newName.length()<=15){
	     						int count=0;
	     						for(int i=0 ; i<newName.length();i++){
	     							if(Character.isLetter(newName.charAt(i)))
	     								count++;
	     						}
	     						if(count>=3)
	     							break;
	     						else
	     							System.out.println("\nUsername should atleast have three letters"+"\n\nTRY AGAIN\n");
	     					}
	     					else
	     						System.out.println("\nUsername length should be (3-15)"+"\n\nTRY AGAIN\n");
	     				}

	     				while(true){
	     					System.out.println("ENTER PASSOWRD");
	     					newPass = obj.nextLine();
	     					if(newPass.length()>4 && newPass.length()<=15){
	     						int count = 0;
	     						int count1 = 0;
	     						for(int i=0 ; i<newPass.length(); i++){
	     							if(Character.isLetter(newPass.charAt(i)))
	     								count++;
	     							if(Character.isDigit(newPass.charAt(i)))
	     								count1++;
	     						}
	     						if(count>=3){
	     							if(count1>=2)
	     								break;
	     							else
	     							System.out.println("\nPassword should atleast have two digits"+"\n\nTRY AGAIN..\n");
	     						}	     							
	     						else
	     							System.out.println("\nPassword should atleast have three letters"+"\n\nTRY AGAIN..\n");

	     					}
	     					else
	     						System.out.println("\nPassword length should be (5-15)"+"\n\nTRY AGAIN..\n");
	     				}	

	     				try{
	     					path = "accounts.txt";
	     					FileWriter wr = new FileWriter(path ,true);
	     					wr.write("\n"+newName);
	     					wr.write("\n"+newPass);
	     					wr.close();
	     				}
	     				catch(IOException ex){
    						System.out.println("IOException: " + ex.getMessage());
	     				}	
	     				System.out.println();
		     			System.out.println("****************************************");
	     				System.out.println("YOu have successfully created an account");
		     			System.out.println("****************************************");
	     				System.out.println();
	     		break;

	     		case 0: System.out.println("EXITING......");
	     				flag1 = false;
	     		break;

	     		default: System.out.println("INVALID OPTION... TRY AGAIN");
	     				 System.out.println();
	     	}		  
		}
		catch(Exception ex){
			System.out.println();		  
			System.out.println("INVALID OPTION... TRY AGAIN");
	     	System.out.println();		  
			obj.nextLine();
		}


	}

	if(tryy==-1){
		System.out.println("ALL TRIES HAVE BEEN USED... SYSTEM BLOCKED");
	}
	
	}//main method ending




// this mehtod is to display the whole table
	public static void displayTable(int[][] marks , String[] subjName){
		// for displaying above line of table
		System.out.printf("%-13s","ROLL #s");
		for(int i=0 ; i<subjName.length ; i++)
			System.out.printf("%-15s",subjName[i]);

		System.out.println();

		// for displaying the marks with roll no.s
		for(int i=0 ; i<marks.length ; i++){
			System.out.print("ROLL NO."+i+" :  ");
			for(int j=0 ; j<marks[i].length ; j++){
				System.out.printf("%-15d",marks[i][j]);
			}
			System.out.println();
		}
	}



// this method is to find out total marks of a student
	public static void total_Marks(int[][] list){
		System.out.println();

		boolean flag = true;
	while(flag){	
		try{
			for(int i=0 ; i<list.length ; i++)
				System.out.println("Roll No. "+i);

			System.out.println();
			System.out.print("Enter roll no. of student whose total marks you want: ");
			int student = obj.nextInt();
			int sum = 0;
			for(int j=0 ; j<list[student].length ; j++){
					sum+= list[student][j];     // adding all marks using loop
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Total marks of student with Roll No. "+student+" are: "+sum);
			System.out.println("-----------------------------------------------------------------");
			flag = false;
		}
		catch(Exception ex){
			System.out.println();		  
			System.out.println("INVALID OPTION");
			System.out.println();		  
			obj.nextLine();
		}
	}	
	}//method ending

// this method is to calculate average marks of a subject
	public static void avg_Subject(int[][] list , String[] subjName){
		String[] subjectName = subjName;
		

		boolean flag = true;
	while(flag){	
		try{
			for(int i=0 ; i<subjectName.length ; i++)
				System.out.println(i+ ". "+subjectName[i]);

			System.out.println();
			System.out.print("Enter the index of subject in which you want average: ");
			int subject = obj.nextInt();
			int sum = 0;

			for(int i=0 ; i<list.length ; i++){
				sum+= list[i][subject];
			}
			int average = sum/list.length;   

			System.out.println("-----------------------------------------------------------------");
			System.out.println("The aveage marks of subject ["+subjectName[subject]+"] are: "+average);
			System.out.println("-----------------------------------------------------------------");
			flag = false;
		}
		catch(Exception ex){
			System.out.println();		  
			System.out.println("INVALID OPTION");
			System.out.println();		  
			obj.nextLine();	
		}
	}		
	}//method ending

// this method is to find the highest marks of a student
	public static void stud_Highest(int[][] list , String[] subjName){

		boolean flag = true;
	while(flag){	
		try{
			for(int i=0 ; i<list.length ; i++)
				System.out.println("Roll No. "+i);

			System.out.println();
			System.out.print("Enter roll no. of student whose highest marks you want: ");
			int student = obj.nextInt();
			int highest = -1;
			String subject = "" ;
			for(int j=0 ; j<subjName.length ; j++){
				if(highest < list[student][j]){
					highest = list[student][j];
					subject = subjName[j]; 
				}
			}

			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Roll No. "+student+" got highest marks ["+highest+"] in subject ["+subject+"] ");
			System.out.println("-------------------------------------------------------------------------------");
			flag = false;
		}
		catch(Exception ex){
			System.out.println();		  
			System.out.println("INVALID OPTION");
			System.out.println();		  
			obj.nextLine();	
		}	
	}	
	}//method ending

// this method is to find the lowest marks of a student
	public static void stud_Lowest(int[][] list , String[] subjName){
		
		boolean flag = true;
	while(flag){
		try{
			for(int i=0 ; i<list.length ; i++)
				System.out.println("Roll No. "+i);

			System.out.println();
			System.out.print("Enter roll no. of student whose lowest marks you want: ");
			int student = obj.nextInt();
			int lowest = 101;
			String subject = "";
			for(int j=0 ; j<subjName.length ; j++){
				if(lowest > list[student][j]){
					lowest = list[student][j];
					subject = subjName[j]; 
				}
			}

			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Roll No. "+student+" got lowest marks ["+lowest+"] in subject ["+subject+"] ");
			System.out.println("-------------------------------------------------------------------------------");
			flag = false;
		}
		catch(Exception ex){
			System.out.println();		  
			System.out.println("INVALID OPTION");
			System.out.println();		  
			obj.nextLine();	
		}	
	}
	}//method ending
	
	public static void highest_marks(int[][] list , String[] subjName){
		displayTable(list , subjName);
		System.out.println();
		int highest = 0 ;
		int sum = 0 ;
		int student = 0;
		for(int i=0 ; i<list.length ; i++){
			sum = 0;
			for(int j=0 ; j<list[i].length ; j++){
				sum += list[i][j];
			}
			if(sum>highest){
				highest=sum;
				student = i;
			}
		}

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Roll No."+student+" got highest total marks which are: "+highest);
		System.out.println("-------------------------------------------------------------------------------");
		
	}	

	public static void lowest_marks(int[][] list , String[] subjName){
		displayTable(list , subjName);
		System.out.println();
		int lowest = 101 ;
		int sum = 0 ;
		int student = 0;
		for(int i=0 ; i<list.length ; i++){
			sum = 0;
			for(int j=0 ; j<list[i].length ; j++){
				sum += list[i][j];
			}
			if(sum<lowest){
				lowest=sum;
				student = i;
			}
		}

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Roll No."+student+" got lowest total marks which are: "+lowest);
		System.out.println("-------------------------------------------------------------------------------");
		
	}

	public static void showGPA(int[][] list , String[] subjName, int subj){
		
		boolean flag = true;
		while(flag){
				
			try{
				for(int i=0 ; i<list.length ; i++)
					System.out.println("Roll No. "+i);

				System.out.println();
				System.out.print("Enter roll no. of student whose GPA you want to see: ");
				int student = obj.nextInt();
				System.out.println();

				calculateGPA(list,subjName,subj,student);
			

				String path3 = "GPA.txt";
				File file1 = new File(path3);
				String path4 = "grades.txt";
				File file2  = new File(path4);

				Scanner inpu = new Scanner(file1);
				double[] gpa = new double[subj+1];
				int a=0;
				while(inpu.hasNext()){
					gpa[a] = inpu.nextDouble();
					a++;
				}

				inpu = new Scanner(file2);
				String[] grades = new String[subj];
				a=0;
				while(inpu.hasNext()){
					grades[a] = inpu.next();
					a++;
				}

				int[] marks = new int[subj];
				for(int i=student ; i<student+1 ; i++){
					for(int j=0 ; j<subj ; j++)
						marks[j] = list[i][j];
				}

				System.out.println("-----------------------------------------------------------------");
				System.out.printf("%-15s%-8s%-7s%-7s%4s","COURSE","CREDIT","MARKS","GRADE","G.P.");
				System.out.println();

				int credit = 0;
				for(int i=0; i<subj ; i++){
					if(i<=1)
						credit=4;
					else
						credit=3;
					System.out.printf("%-17s%-7d%-8d%-5s%-4.2f",subjName[i],credit,marks[i],grades[i],gpa[i]);
					System.out.println();
				}
				System.out.println();
				System.out.println("      TOTAL GPA = "+gpa[subj]);
				System.out.println("-----------------------------------------------------------------");
			
				flag=false;

			}
			catch(Exception ex){
				System.out.println();
				System.out.println("INVALID OPTION... TRY AGAIN");
				System.out.println();
				obj.nextLine();
			}
		}
	}

	public static void calculateGPA(int[][] list, String[] subjName, int subj, int stu) throws IOException{
		String path3 = "GPA.txt";
		File file1 = new File(path3);
		String path4 = "grades.txt";
		File file2  = new File(path4);

		PrintWriter p3 = new PrintWriter(path3);
		PrintWriter p4 = new PrintWriter(path4);

		double[] points = new double[subj];
		for(int i=stu; i<stu+1; i++){
			
			for(int j=0; j<list[i].length; j++){
				int marks = list[i][j];
				if(marks>=85){
					points[j] = 4.0;
					p3.println(4.0);
					p4.println("A");
				}
				else if(marks>=80 && marks<85){
					points[j] = 3.66;
					p3.println(3.66);
					p4.println("A-");
				}
				else if(marks>=75 && marks<80){
					points[j] = 3.33;
					p3.println(3.33);
					p4.println("B+");
				}
				else if(marks>=71 && marks<75){
					points[j] = 3.0;
					p3.println(3.0);
					p4.println("B");
				}
				else if(marks>=68 && marks<71){
					points[j] = 2.66;
					p3.println(2.66);
					p4.println("B-");
				}
				else if(marks>=64 && marks<68){
					points[j] = 2.33;
					p3.println(2.33);
					p4.println("C+");
				}
				else if(marks>=61 && marks<64){
					points[j] = 2.0;
					p3.println(2.0);
					p4.println("C");
				}
				else if(marks>=58 && marks<61){
					points[j] = 1.66;
					p3.println(1.66);
					p4.println("C-");
				}
				else if(marks>=54 && marks<58){
					points[j] = 1.3;
					p3.println(1.3);
					p4.println("D+");
				}
				else if(marks>=50 && marks<54){
					points[j] = 1.0;
					p3.println(1.0);
					p4.println("D");
				}
				else{
					points[j] = 0;
					p3.println(0);
					p4.println("F");
				}

			}
		}


		double total= 0;
		int creditHours = 0;
		for(int i=0 ; i<points.length ; i++){
			if(i<=1){
				total+= (points[i]*4);
				creditHours+=4;
			}
			else{
				total+= (points[i]*3);
				creditHours+=3;
			}
		}

		double totalGPA = total/creditHours;
		p3.printf("%3.2f",totalGPA);

		p3.close();
		p4.close();
	}
}