package com.lzw.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;

public class test {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        Socket client=new Socket("127.0.0.1",6000);
        BufferedOutputStream dos=new BufferedOutputStream(client.getOutputStream());
        while(true)
        {
            String a=test.formatDouble4(Math.random()*100);
            String b=test.formatDouble4(Math.random()*1000);
            String str=a+"@"+b+"@";
            byte[] a1=str.getBytes();
            dos.write(a1,0,a1.length);
            dos.flush();
            Thread.sleep(2000);
        }
    }
    public static String formatDouble4(double d) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }

}
