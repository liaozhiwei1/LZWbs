package com.lzw.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

import com.lzw.Dao.selins;
import com.lzw.pojo.Data;

public class server {
	public Socket socket;
	public server(){
	ServerSocket sever;
	try {
		sever = new ServerSocket(6000);
		socket=sever.accept();
		System.out.println("连接成功");
		MyThread m=new  MyThread(socket);
		new Thread(m).start();
	
	} catch (IOException e) {
		e.printStackTrace();
		}
	}	
}


class MyThread implements Runnable{
	public BufferedInputStream dis;
	public Socket socket;
	StringBuffer str1 =new StringBuffer();	//储存需要加入的数据
	selins sl=new selins();
	String[] b;
	boolean bloo;
	boolean d;
	MyThread(Socket socket){
		this.socket=socket;
	}
	public void run() {
		try {
			dis=new BufferedInputStream(socket.getInputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 while(true){
			 d=true;
			 bloo=true;
			 try {
				byte[] c=new byte[1024];
				int len=0;
			 while(-1!=(len=dis.read(c)))
			 {
				 str1=str1.append(new String (c,0,len).trim());
				 int x=str1.indexOf("@", str1.indexOf("@")+1);
				 String temps=str1.substring(0, x);
				 str1.delete(0, x+1);
				 b=temps.split("@");
				for(int i=0;i<2;i++)
				{	
					System.out.println(b[i]);
					 d = Pattern.matches("(\\d\\d*\\.?\\d*)", b[i]);
					 if(!d)
					 {
						 	System.out.println(b[i]);
							System.out.println("earro");
							bloo=false;
							break;
					}
					}
				if(bloo){
					DecimalFormat df=new DecimalFormat("#.00");
					Data da=new Data();
					Data d=sl.sel();
					da.setTemperature(b[0]);
					da.setPressure(b[1]);
					double nextTemperature = 0.8*Double.parseDouble(b[0])+0.2*Double.parseDouble(d.getNextTemperature());
					double nextPressure = 0.8*Double.parseDouble(b[1])+0.2*Double.parseDouble(d.getNextPressure());
					da.setNextPressure(String.valueOf(df.format(nextPressure)));
					da.setNextTemperature(String.valueOf(df.format(nextTemperature)));
					sl.ins(da);
				}
				
			 }
			 } catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			}
		 }
	}
