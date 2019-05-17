package com.redes.aula;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
	
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Fabricio Alves\\Desktop\\Cliente\\arq.txt");
			Socket cli = new Socket("localhost", 5570);
			BufferedOutputStream bf = new BufferedOutputStream(cli.getOutputStream());
			
			byte [] bytea = serializarArquivo(file);
			bf.write(bytea);
			bf.flush();
			bf.close();
			cli.close();
			
			
		} catch (IOException e) {

		}
	}
	
	private static byte[] serializarArquivo(File arquivo){
		   try {
		      ByteArrayOutputStream bao = new ByteArrayOutputStream();
		      ObjectOutputStream ous;
		      ous = new ObjectOutputStream(bao);
		      ous.writeObject(arquivo);
		      return bao.toByteArray();
		   } catch (IOException e) {
		      e.printStackTrace();
		   }
		 
		   return null;
		}
		 
}
