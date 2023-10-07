import controllers.DiaryController;
import dtos.request.LoginRequest;
import dtos.request.RegisterUserRequest;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    private static DiaryController diaryController = new DiaryController();
    private static String currentUser;

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        String menu = """
                Welcome to Ofofo Arena!!!
                1-> Create Account
                2-> Log in
                3-> Exit Application
                """;
        char userInput = input(menu).charAt(0);
        switch (userInput){
            case '1' -> registerAccount();
            case '2' -> logIn();
            default -> menu();
        }
    }
    public static void registerAccount(){
        String username = input("Enter Username");
        String password = input("Enter password");
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername(username);
        registerUserRequest.setPassword(password);
        String registeredName = diaryController.registerUser(registerUserRequest);
        print(registeredName);
        menu();
    }
    public static void logIn(){
        String username = input("Enter Username");
        String password = input ("Enter Password");
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);
        String loggedIn = diaryController.unlockDiary(loginRequest);
        if(loggedIn.equals("Incorrect Password") || loggedIn.equals("Kindly input a correct Username")){
            print("Log in with correct details");
            logIn();
        }
        else {
                currentUser = username;
                print(loggedIn);
                showDiaryMenu();
        }
    }

    public static void showDiaryMenu(){
        String menu = """
                1-> Create Entry
                2-> Find Entry
                3-> Update Entry
                4-> Delete Entry
                5-> Log Out
          
                """;
        char userInput = input(menu).charAt(0);
        switch (userInput){
            case '1' -> createEntry();
            case '2' -> findEntry();
            case '3' -> logOut();
        }
    }
    public static void logOut(){
        String locked = diaryController.lockDiary(currentUser);
        print(locked);
    }

    private static void createEntry() {
        String title = input("Enter your title");
        String body = input("Enter your body");
        String entry = diaryController.createEntry(currentUser,title, body);
        print(entry);
    }

    private static void findEntry(){
        String title = input("Enter your title");
        String FoundEntry = diaryController.findEntry(currentUser, title);
        print(FoundEntry);
    }

    public static void print(String message){
        out.println(message);
    }
    public static String input(String prompt){
        out.println(prompt);
        Scanner keyboard = new Scanner(in);
        return keyboard.nextLine();
    }

}