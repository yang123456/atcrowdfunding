package com.atguigu.atcrowdfunding.producerAndconsumer.m5;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 消费者
 * 
 * @author Administrator
 */
public class Consumer implements Runnable {
	private PipedInputStream pipedInputStream;

	public Consumer() {
		pipedInputStream = new PipedInputStream();
	}

	public PipedInputStream getPipedInputStream() {
		return pipedInputStream;
	}

	@Override
	public void run() {
		int len = -1;
		byte[] buffer = new byte[1024];
		try {
			while ((len = pipedInputStream.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, len));
			}
			pipedInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
