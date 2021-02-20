package com.company;
import Object.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Enemy> enemys = new ArrayList<>();
        /**
         * Load Files if file exists from previous save;
         */
        File file = new File("Data.txt");

//        if(file.exists() && !file.isDirectory()){
//            Scanner scan = new Scanner("Data.txt");
//            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
//            try{
//                if(scan.hasNextLine()){
//                    // double health, double baseMelee, double baseDefense, double baseMage, String name, double gold
//                    Player player = new Player(Double.parseDouble(reader.readLine()),Double.parseDouble(reader.readLine()),Double.parseDouble(reader.readLine())
//                            ,Double.parseDouble(reader.readLine()),reader.readLine(),Double.parseDouble(reader.readLine()));
//                    players.add(player);
//                }
//            } catch (FileNotFoundException e){
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        //---------------------------------------------
        int switchCase= 0;
        String possbleChange;
        Scanner scan = new Scanner(System.in);
        //START INTRO -----------------------
        System.out.println("Hello Advernture! This world is yours to explore, but first we need to know your name?");
        Player p1 = new Player();
        System.out.println("What is your name?");
        String n = scan.nextLine();
        p1.setName(n);
        System.out.println("So your name is: " + p1.getName() + "?");
        System.out.println("You're entering the world of Azeira, Best of luck..... " + p1.getName());
        players.add(p1);
        Thread.sleep(4000);
        System.out.println("*You awaken within a forest no idea of your past but one thing is clear, the world you've entered is beautiful.*");
        Thread.sleep(4000);
        System.out.println("You begin to walk on a path, one that seems more perculure, after fifteen minutes of progress, a mysterious voice appears");
         Thread.sleep(4000);
        System.out.println(players.get(0).getName() + ", There is a weary traveler that needs assistance, take this sword and shield!!");
        Thread.sleep(4000);
        p1.swords.add(new Sword("Explorers Sword",1,5));
        p1.shields.add(new Shield("Travelers Shield",12,1));
        System.out.println(p1.swords.get(0).getName() + " added to your inventory");
        System.out.println(p1.shields.get(0).getName() + " added to your inventory");
        //END INTRO ----------------------------
        enemys.add(new Enemy(10,1.0,.2,0));
        //Enemy Creation

        System.out.println("Battle Begining");
        players.get(0).setHealth(battleBegin(p1,enemys.get(0)));

        if(players.get(0).getHealth() <= 0){
            System.out.println("Game over!");
        } else {
            enemys.clear();
            Thread.sleep(2000);
            players.get(0).setHealth(10.0);
            System.out.println("Health refilled");
            System.out.println(players.get(0).getHealth());
        }

        System.out.println("Save game?");
        int save = scan.nextInt();
        if(save == 1){
            saveState(players);
        }


    }

    static double battleBegin(Player p1, Enemy e) throws InterruptedException {
        Random rand = new Random();
        double r = rand.nextInt(5-1);

        Scanner scan = new Scanner(System.in);
        System.out.println("Total Health: " + p1.getHealth() + "||   Enemy Health: " + e.getHealth());
        Thread.sleep(1000);
        System.out.println("Current Weapon: " + p1.swords.get(0).getName());
        Thread.sleep(1000);
        System.out.println("1. Melee Attack");
        System.out.println("2. Block");
        double eHp = e.getHealth();
        int choice = scan.nextInt();
       do{
           if(choice == 1){
               double calc = p1.getBaseMelee() * p1.swords.get(0).getDamage() + 2;
               double pAD = p1.getBaseMelee() + p1.swords.get(0).getDamage() / calc;
               eHp = eHp - pAD;
               e.setHealth(eHp);
               System.out.println("Total Health: " + p1.getHealth() + "||   Enemy Health: " + e.getHealth());

               if(e.getHealth()<= 0){
                   return p1.getHealth();
               }else {
                   System.out.println("1. Melee Attack");
                   System.out.println("2. Block");
                   choice = scan.nextInt();
               }
           } else{
                double defcalc = p1.getBaseDefense() +p1.shields.get(0).getBlockDmg();
                double dmg = defcalc - (e.getBaseMelee() + r) - 3;
               System.out.println("Debug: dmg = " + dmg + " calc = " + defcalc);
                if(dmg < 0 ){
                    System.out.println("Total Health: " + p1.getHealth() + "||   Enemy Health: " + e.getHealth());
                    System.out.println("The Enemy misses their attack");
                    System.out.println("1. Melee Attack");
                    System.out.println("2. Block");
                    choice = scan.nextInt();
                } else{
                    System.out.println("The enemy damages you for " + dmg);
                    p1.setHealth(p1.getHealth() - dmg);
                    System.out.println("Total Health: " + p1.getHealth() + "||   Enemy Health: " + e.getHealth());
                    if(p1.getHealth() <= 0){
                        System.out.println("You have died :C");
                        return p1.getHealth();
                    }
                    System.out.println("1. Melee Attack");
                    System.out.println("2. Block");
                    choice = scan.nextInt();
                }
           }

        }while(!(e.getHealth()<=0));
       return p1.getHealth();
    }

    static void saveState(ArrayList<Player> p) throws IOException {
        Player player = p.get(0);
        FileWriter writer = new FileWriter("Data.txt");
        final Path path = Files.createTempFile("Data",".txt");
        File file = new File("Data.txt");
       if(!Files.exists(path)){
           file.createNewFile();
       }
        if(p.size() != 0){
            writer.write(String.valueOf(player.getHealth()));
            writer.write(System.lineSeparator());
            writer.write(String.valueOf(player.getBaseMelee()));
            writer.write(System.lineSeparator());
            writer.write(String.valueOf(player.getBaseDefense()));
            writer.write(System.lineSeparator());
            writer.write(String.valueOf(player.getBaseMage()));
            writer.write(System.lineSeparator());
            writer.write(player.getName());
            writer.write(System.lineSeparator());
            writer.write(String.valueOf(player.getGold()));
        }
    }

}
