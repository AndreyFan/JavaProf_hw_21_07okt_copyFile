package de.telran.hw_21_07okt_CopyFiles;

import java.io.*;
import java.util.Scanner;

public class CopyFiles {
    // Task_1
    //  1. Написать приложение, которое будет копировать информацию из файла
    //  в другой файл.
    //Путь к существующему файлу и имя нового файла нужно вводить с клавиатуры.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите имя файла c расширением (и если нужно путь к нему), который будем копировать ");
        String fileSourse = scanner.nextLine();

        System.out.println("введите имя файла (и если нужно путь к нему), в который будем копировать ");
        String fileDest = scanner.nextLine();
        System.out.println();


        copyFile(fileSourse, fileDest);

    }

    public static void copyFile(String sourceFile, String destFile) {

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(destFile)
        ) {
            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {  // Чтение данных  и запись
                fos.write(buffer, 0, length);
            }

            System.out.println("Файл " + sourceFile +
                    " скопирован в  " + destFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

}
