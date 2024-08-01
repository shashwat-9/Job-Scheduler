package com.shashwat.scheduler_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.Buffer;

@SpringBootApplication
public class SchedulerServiceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("cmd.exe", "/c", "ssh -i D:/Workspace/Job-Scheduler/scheduler-service/src/main/resources/key.pem ubuntu@ec2-65-1-147-156.ap-south-1.compute.amazonaws.com");
//		processBuilder.command("cmd.exe", "/c", "dir");
		try {
			Process process = processBuilder.start();
			process.outputWriter().write("sudo apt update");
//			process.outputWriter().write("mkdir hiTry");
//			process.outputWriter().write("ls -lrt");
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			writer.write("sudo apt update\n");
			writer.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {

				System.out.println(line);
			}
			process.destroy();
			int exitCode = process.waitFor();
			System.out.println("Exit code " + exitCode);
		}	catch (IOException e) {
			e.printStackTrace();
		}	catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
