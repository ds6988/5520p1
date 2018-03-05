package proj1;

//Compiled by: Dustin Scott

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.servlet.ServletException;

public class JavaQuizBean {
  private static PreparedStatement prepCreateUserTable;
  private static PreparedStatement prepCreateQuestionTable;
  private static PreparedStatement prepInsertQuestion;
  private static PreparedStatement prepCreateUser;
  private static PreparedStatement prepUpdateUser;
  private static PreparedStatement prepGetQuestion;
  private static PreparedStatement prepUpdateUserStats;
  
  private static String chapterNo="";
  private static String questionNo="";
  private static String question="";
  private static String choiceA="";
  private static String choiceB="";
  private static String choiceC="";
  private static String choiceD="";
  private static String choiceE="";
  private static String answerKey="";
  private static String hint="";
  
 
  public void init() throws ServletException,IOException,SQLException {
    initDB();   
    prepCreateUserTable.executeQuery();
    prepCreateQuestionTable.executeQuery();    
    createChapters();    
  }
  
  private void initDB() {
    try {
      //loads the jdbc
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("driver loaded successfully");
            
      //connect to the db
      Connection conn=DriverManager.getConnection("jdbc:mysql://local"
          +"host/5520p1","dscott","tiger");
        System.out.println("DB connected");
            
      //create query statements
      String userTableStr="create table if not exists intro11e (chapterNo"
              +" int(11),questionNo int(11),isCorrect bit(1) default 0,time"
              +" timestamp default current_timestamp,hostname varchar(100),"
              +" answerA bit(1) default 0,answerB bit(1) default 0,answerC"
              +" bit(1) default 0,answerD bit(1) default 0,answerE bit(1)"
              +" default 0,username varchar(100));";
      String questTableStr="create table if not exists intro11equiz" 
              +" (chapterNo int(11),questionNo int(11),question text,choiceA"
              +" varchar(1000),choiceB varchar(1000),choiceC varchar(1000),"
              +" choiceD varchar(1000),choiceE varchar(1000),answerKey"
              +" varchar(5),hint text);";
      String getQuestStr="select chapterNo,questionNo,question,choiceA,choiceB,"
              + "choiceC,choiceD,choiceE,answerKey,hint from intro11equiz where"
              + " chapterNo=?,questionNo=?";
      String insertQuestStr="insert into introllequiz (chapterNo,questionNo,"
              + "question,choiceA,choiceB,choiceC,choiceD,choiceE,answerKey,"
              + "hint) (?,?,?,?,?,?,?,?,?,?)";
      String updateStatsStr="";
      prepCreateQuestionTable=conn.prepareStatement(questTableStr);
      prepGetQuestion=conn.prepareStatement(getQuestStr);
      prepCreateUserTable=conn.prepareStatement(userTableStr);
      prepInsertQuestion=conn.prepareStatement(insertQuestStr);
      prepUpdateUserStats=conn.prepareStatement(updateStatsStr);

//      String viewString = "select id,first,last,mi,address,city,"
//          + "state,telephone,email from staff where id = ?";
//      String updateString = "update staff set first = ?,"
//          + "last = ?, mi = ?, address = ?, city = ?,"
//          + "state = ?, telephone = ?, email = ? where id = ?";
//      String insertString = "insert into staff "
//          + "(id,first,last,mi,address,city,state,telephone,email) values "
//          + "(?,?,?,?,?,?,?,?,?)";

    } 
    catch (Exception ex) {
      System.out.println(ex);
    }     
  }
  
  //switches between text files
  public static void createChapters() throws IOException {
    try {
      File file=null;
      for (int i=1;i<45;i++) {
        switch (i) {
          case 1:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter1.txt");
          case 2:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter2.txt");
          case 3:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter3.txt");
          case 4:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter4.txt");
          case 5:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter5.txt");
          case 6:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter6.txt");
          case 7:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter7.txt");
          case 8:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter8.txt");
          case 9:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter9.txt");
          case 10:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter10.txt");
          case 11:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter11.txt");
          case 12:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter12.txt");
          case 13:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter13.txt");
          case 14:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter14.txt");
          case 15:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter15.txt");
          case 16:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter16.txt");
          case 17:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter17.txt");
          case 18:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter18.txt");
          case 19:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter19.txt");
          case 20:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter20.txt");
          case 21:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter21.txt");
          case 22:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter22.txt");
          case 23:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter23.txt");
          case 24:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter24.txt");
          case 25:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter25.txt");
          case 26:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter26.txt");
          case 27:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter27.txt");
          case 28:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter28.txt");
          case 29:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter29.txt");
          case 30:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter30.txt");
          case 31:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter31.txt");
          case 32:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter32.txt");
          case 33:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter33.txt");
          case 34:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter34.txt");
          case 35:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter35.txt");
          case 36:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter36.txt");
          case 37:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter37.txt");
          case 38:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter38.txt");
          case 39:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter39.txt");
          case 40:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter40.txt");
          case 41:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter41.txt");
          case 42:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter42.txt");
          case 43:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter43.txt");
          case 44:
            file=new File("C:\\Users\\hektik4x4\\Desktop\\School\\Java Dev\\questions\\chapter44.txt");
        }
        createQuestionsTable(file);
      }
    } 
    catch (FileNotFoundException e) {}
  }
  
  //read text files
  public static void createQuestionsTable(File file) throws IOException {
    String s="";
    try (Scanner scan=new Scanner(file)) { 
        scan.next();
        chapterNo=Integer.toString(scan.nextInt());
        prepInsertQuestion.setString(1,chapterNo);
        System.out.println();
        while (scan.hasNext()) {
          question="";
          choiceA="";
          choiceB="";
          choiceC="";
          choiceD="";
          choiceE="";
          answerKey="";
          hint="";
          s=scan.next();
          if (s.toLowerCase().equals("section")) {
            scan.nextLine();
            questionNo=questionNo+1;
            scan.next();
            StringBuilder sb=new StringBuilder();
            while (!s.equals("a.")) {
              sb.append(s);
              sb.append(scan.nextLine());
              sb.append("\n");
              question=sb.toString();
              s=scan.next();
            }
            choiceA=scan.nextLine();
            scan.next();
            choiceB=scan.nextLine();
            s=scan.nextLine();
            Scanner sc=new Scanner(s);
            if (sc.next().equals("c.")) {
              choiceC=sc.nextLine(); 
              s=scan.nextLine();
            }
            sc.close();
            Scanner sd=new Scanner(s);
            if (sd.next().equals("d.")) {
              choiceD=sd.nextLine(); 
              s=scan.nextLine();
            }
            sd.close();
            Scanner se=new Scanner(s);
            if (se.next().equals("e.")) {
              choiceE=se.nextLine(); 
              s=scan.nextLine();
            }
            se.close();
            Scanner sk=new Scanner(s).useDelimiter(":");
            sk.next();
            answerKey=sk.next();
            sk.close();
            Scanner sh=new Scanner(s).useDelimiter(":");
            if (sh.next().toLowerCase().equals(hint)) {
              hint=sh.next();
              s=scan.nextLine();
            }            
            sh.close();
            prepInsertQuestion.setString(2,questionNo);
            prepInsertQuestion.setString(3,question);
            prepInsertQuestion.setString(4,choiceA);
            prepInsertQuestion.setString(5,choiceB);
            if (!choiceC.equals(""))
              prepInsertQuestion.setString(6,choiceC);
            if (!choiceD.equals(""))
              prepInsertQuestion.setString(7,choiceD);
            if (!choiceE.equals(""))
              prepInsertQuestion.setString(8,choiceE);
            prepInsertQuestion.setString(9,answerKey);
            if (!hint.equals("")) {
              prepInsertQuestion.setString(10,hint);
            }
            prepInsertQuestion.executeQuery();
          }
          else if (s.toLowerCase().equals("#")) {
            s=scan.next();
            if (s.toLowerCase().equals("section")) {
              scan.nextLine(); }
            questionNo=questionNo+1;
            s=scan.next();
            StringBuilder sb=new StringBuilder();
            while (!s.equals("a.")) {
              sb.append(s);
              sb.append(scan.nextLine());
              sb.append("\n");
              question=sb.toString();
              s=scan.next();
            }
            choiceA=scan.nextLine();
            scan.next();
            choiceB=scan.nextLine();
            s=scan.nextLine();
            Scanner sc=new Scanner(s);
            if (sc.next().equals("c.")) {
              choiceC=sc.nextLine(); 
              s=scan.nextLine();
            }
            sc.close();
            Scanner sd=new Scanner(s);
            if (sd.next().equals("d.")) {
              choiceD=sd.nextLine(); 
              s=scan.nextLine();
            }
            sd.close();
            Scanner se=new Scanner(s);
            if (se.next().equals("e.")) {
              choiceE=se.nextLine(); 
              s=scan.nextLine();
            }
            se.close();
            Scanner sk=new Scanner(s).useDelimiter(":");
            sk.next();
            answerKey=sk.next();
            sk.close();
            Scanner sh=new Scanner(s).useDelimiter(":");
            if (sh.next().toLowerCase().equals(hint)) {
              hint=sh.next();
              s=scan.nextLine();
            }            
            sh.close();
            prepInsertQuestion.setString(2,questionNo);
            prepInsertQuestion.setString(3,question);
            prepInsertQuestion.setString(4,choiceA);
            prepInsertQuestion.setString(5,choiceB);
            if (!choiceC.equals(""))
              prepInsertQuestion.setString(6,choiceC);
            if (!choiceD.equals(""))
              prepInsertQuestion.setString(7,choiceD);
            if (!choiceE.equals(""))
              prepInsertQuestion.setString(8,choiceE);
            prepInsertQuestion.setString(9,answerKey);
            if (!hint.equals("")) {
              prepInsertQuestion.setString(10,hint);
            }
            prepInsertQuestion.executeQuery();
          }  
          else
            scan.next();           
        }      
    } 
    catch (FileNotFoundException|SQLException e) {}
  }
  
}