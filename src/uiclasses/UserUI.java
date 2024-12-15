package uiclasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Vector;

import main.Database;
import unisystem2023.News;
import users.User;
public abstract class UserUI{
  Vector<User> users = Database.getInstance().getAllUsers();
  protected User user;
  protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  protected BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

  public UserUI(){}

  public UserUI(User user){
    this.user = user;
  }

  public void print(String message) throws IOException{
    writer.write(message);
    writer.newLine();
    writer.flush();
  }

  public void viewNews() throws IOException{
    Vector <News> news = Database.getInstance().getNews();
    Collections.reverse(news);
    while(true){
      print("0. Exit");
      int count = 1;
      for(News cur: news){
        print(count + "." + cur);
        count++;
      }
      String ans = reader.readLine();
      if(ans.equals("0")){
        return;
      }
    }
  }

  public void changePassword() throws IOException {
      // Add a login step before changing the password
      print("Enter your login: ");
      String enteredLogin = reader.readLine();
      
      print("Enter your current password: ");
      String enteredPassword = reader.readLine();

      if (user.logIn(enteredLogin, enteredPassword, users)) {
          // User is authenticated
          while (true) {
              print("Insert new password: ");
              String newPassword1 = reader.readLine();
              print("Confirm new password: ");
              String newPassword2 = reader.readLine();

              if (newPassword1.equals(newPassword2)) {
                  user.setPassword(newPassword2);
                  print("Password changed successfully!");
                  break;
              } else {
                  print("Passwords don't match");
              }
          }
      } else {
          print("Invalid login or password. Cannot change password.");
      }
  }


  public abstract void main();

}
