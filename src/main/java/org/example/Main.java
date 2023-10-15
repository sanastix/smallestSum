package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        long n = Long.parseLong(lines.get(0));
        String[] numStrings = lines.get(1).split(" ");

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (String numString : numStrings) {
            queue.offer(Long.parseLong(numString));
        }

        long totalCost = 0;

        while (queue.size() > 1) {
            long sum = queue.poll() + queue.poll();
            totalCost += sum;
            queue.offer(sum);
        }

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(totalCost);
        writer.close();

    }
}