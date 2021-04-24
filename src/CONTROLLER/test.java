package CONTROLLER;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File file = new File("src/DataSet/fas.jpg");
        System.out.println(file.delete());
    }
}
