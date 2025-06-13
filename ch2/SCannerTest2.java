package ch2;

import java.util.Scanner;

import util.User.UserService;

public class SCannerTest2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserService.registerUser(scanner);
        UserService.login(scanner);
        scanner.close();
    }
}
