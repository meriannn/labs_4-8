package main;

import command.CommandEnum;
import command.RegulateCommands;
import device.AvailableDevices;
import device.ElectronicDevice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);


    public static void MainMenu(){

        ArrayList<ElectronicDevice> allDevices = new ArrayList<>(AvailableDevices.BaseDevices());
        int choice = 0;
        do{
            MenuManaging.MainMenuText();
            choice = input.nextInt();
            MenuManaging.MenuManaging(choice, allDevices);

        }while(choice != 6);
    }

    public static void main(String[] args){
        MainMenu();
    }
}
