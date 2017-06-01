package com.company;
import nasoftware.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NAManager.init();
        Scanner reader = new Scanner(System.in);
        int inputBuffer = 1;
        while(inputBuffer != 0)
        {
            System.out.println("Input number to:\n 1. sign up\t2. log in\t3. add friend\t4. send message\t5. start receive messages\t0. shut down");
            inputBuffer = reader.nextInt();
            switch (inputBuffer)
            {
                case 1: signUp(); break;
                case 2: logIn(); break;
                case 3: addFriend(); break;
                case 4: sendMessage(); break;
                case 5: startReceiveMessages(); break;
                case 0: System.exit(0);
            }
        }
    }


    static void signUp()
    {
        Scanner reader = new Scanner(System.in);
        String account;
        String password;
        String name;
        System.out.println("Input the account:");
        account = reader.next();
        System.out.println("Input the password:");
        password = reader.next();
        System.out.println("Input the name:");
        name = reader.next();
        NAManager.accountManager.signUp(account,password,name, (String result) -> System.out.println(result.split("-")[0]));
    }

    static void logIn() {
        Scanner reader = new Scanner(System.in);
        String account;
        String password;
        System.out.println("Input the account:");
        account = reader.next();
        System.out.println("Input the password:");
        password = reader.next();
        NAManager.accountManager.logIn(account, password, (String result) -> System.out.println(result.split("-")[0]));
    }

    static void addFriend()
    {
        Scanner reader = new Scanner(System.in);
        String account;
        System.out.println("Input the friend's account:");
        account = reader.next();
        NAManager.friendsManager.addFriend(account, (String result) -> System.out.println(result.split("-")[0]));
    }

    static void sendMessage()
    {
        Scanner reader = new Scanner(System.in);
        String account;
        String message;
        System.out.println("Input the friend's account:");
        account = reader.next();
        System.out.println("Input the message:");
        message = reader.next();
        NAManager.messagesManager.sendMessageTo(account, message, (String result) -> System.out.println(result.split("-")[0]));
    }

    static void startReceiveMessages()
    {
        NAManager.messagesManager.addMessageListener((String result) -> System.out.println(result));
    }
}
