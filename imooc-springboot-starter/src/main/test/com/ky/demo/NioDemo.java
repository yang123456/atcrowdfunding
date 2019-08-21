package com.ky.demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("E:\\日常笔记\\subForm.txt","rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        int length = fileChannel.read(byteBuffer);
        while (length!=-1){
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            length = fileChannel.read(byteBuffer);
        }
        file.close();
    }
}

