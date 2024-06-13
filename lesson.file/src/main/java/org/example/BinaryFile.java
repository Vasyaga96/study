package org.example;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class BinaryFile {
    public static void main(String[] args) throws Exception {
        Scanner scannerInput = new Scanner(System.in);
        System.out.print("Введите целое положительное число: ");
        short n = scannerInput.nextShort();
        try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("output.bin"))){
            ByteBuffer buffer = ByteBuffer.allocate(2 * n);
            for (short i = 1; i <= n; i++){
                buffer.putShort(i);
            }
            byte[] data = buffer.array();
            stream.write(data);
        }
        File file = new File("output.bin");
        long fileSize = file.length();
        byte[] data = new byte[(int) fileSize];
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file))) {
            stream.read(data);
        }
        ByteBuffer buffer2 = ByteBuffer.wrap(data);
        while (buffer2.hasRemaining()) {
            short y = buffer2.getShort();
            System.out.println(y * 3);
        }
    }
}
