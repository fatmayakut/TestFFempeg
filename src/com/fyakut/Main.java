package com.fyakut;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {




        String peticion="ffmpeg -i C:\\tanitim11.mp4 -i C:\\tanitim2.mp4 -i C:\\tanitim3.mp4 -i C:\\tanitim4.mp4 -filter_complex \"nullsrc=size=640x480 [base];[0:v] setpts=PTS-STARTPTS, scale=320x240 [upperleft]; [1:v] setpts=PTS-STARTPTS, scale=320x240 [upperright]; [2:v] setpts=PTS-STARTPTS, scale=320x240 [lowerleft]; [3:v] setpts=PTS-STARTPTS, scale=320x240 [lowerright]; [base][upperleft] overlay=shortest=1 [tmp1]; [tmp1][upperright] overlay=shortest=1:x=320 [tmp2]; [tmp2][lowerleft] overlay=shortest=1:y=240  [tmp3]; [tmp3][lowerright] overlay=shortest=1:x=320:y=240\" -c:v libx264 C:\\video\\tanitim12.mp4";
      // String peticion="ffmpeg -i rtsp://admin:admin@212.156.136.50:554/ucast/11 -vcodec libx264 -vb 500000 -g 60 -vprofile baseline -level 2.1 -acodec aac -ab 64000 -ar 48000 -ac 2 -vbsf h264_mp4toannexb -strict experimental -f mpegts udp://127.0.0.1:10000";

        try {

           Process p=Runtime.getRuntime().exec(peticion);

            System.out.println("aaa"+p);
            BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line="";
            while ((line=br.readLine())!=null){

                System.out.println("islem basarili"+line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,e);
        }
    }

}

