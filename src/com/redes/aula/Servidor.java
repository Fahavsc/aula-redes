package com.redes.aula;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
//import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		try {
			ServerSocket srv = new ServerSocket(5570);
			System.out.println("Aguardando conexão");
			Socket sock = srv.accept();

			System.out.println("Cliente conectado");
			
			byte[] arq = new byte[sock.getReceiveBufferSize()];
			BufferedInputStream bf = new BufferedInputStream(sock.getInputStream());
			bf.read(arq);

			//File arquivo = (File) getObjectFromByte(arq);
			
			String dir = "C:\\Users\\Fabricio Alves\\Desktop\\Servidor\\arq.txt";
			
			FileOutputStream fos = new FileOutputStream(dir);
			
			fos.write(arq);
			System.out.println("Gravando aquivo");
			Thread.sleep(2000);
			fos.close();
			srv.close();
			System.out.println("Arquivo enviado!");
		} catch (IOException | InterruptedException e) {

		}

	}

	private static Object getObjectFromByte(byte[] objectAsByte) {
		Object obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(objectAsByte);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();

			bis.close();
			ois.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;

	}
}
