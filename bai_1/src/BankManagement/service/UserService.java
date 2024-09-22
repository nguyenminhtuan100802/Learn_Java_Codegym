package BankManagement.service;

import BankManagement.model.User;
import BankManagement.variable.Choice.Choice;
import BankManagement.variable.TextColor.TextColor;
import BankManagement.variable.UserChoice.UserChoiceFind;


import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private ArrayList<User> userArrayList;

    public UserService() {
        userArrayList = new ArrayList<>();
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void addUser() {
        userArrayList.add(this.createNewUser());
        FileService.saveUserToFile(userArrayList);
    }

    public void findUser() {
        while (true) {
            boolean isExist = false;
            System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (Admin) > FIND USER (Admin)" + TextColor.END_COLOR + "=================");
            System.out.println("1. Find user by full name");
            System.out.println("2. Find user by phone number");
            System.out.println("3. Show all users");
            System.out.println("10. Return home");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.find = new Scanner(System.in).nextInt();

            switch (Choice.find) {
                case UserChoiceFind.FIND_BY_FULL_NAME:
                    break;
                case UserChoiceFind.FIND_BY_PHONE_NUMBER:
                    break;
                case UserChoiceFind.SHOW_ALL_USERS:
                    this.showAllUsers();
                    break;
                case UserChoiceFind.RETURN_HOME:
                    isExist = true;
                    break;
            }
            if (isExist) {
                break;
            }
        }
    }
    public void editUser(User user) {
    }

    public void deleteUser(User user) {
    }
    public void showAllUsers() {
        userArrayList = FileService.loadUserFromFile();
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i).toString());
        }
    }
    public void deleteAllUsers() {
        userArrayList.clear();
    }
    private User createNewUser() {
        System.out.print("Enter user full name:");
        String userFullName = new Scanner(System.in).nextLine();
        System.out.print("Enter user phone number:");
        String userPhoneNumber = new Scanner(System.in).nextLine();

        return new User(userFullName, userPhoneNumber);
    }
    private void findUserByFullName(){
        System.out.print("Enter user full name: you want to find:");
        String userFullName = new Scanner(System.in).nextLine();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getFullName().equals(userFullName)){
                System.out.println(userArrayList.get(i).toString());
            }
        }
    }
    private void findUserByPhoneNumber(){

    }
}
