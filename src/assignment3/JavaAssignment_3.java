package assignment3;

import java.util.*;
import java.net.*;

public class JavaAssignment_3 {
    public static void main(String args[]) throws UnknownHostException {
        System.out.println("Enter an IP Address");
        Scanner sc=new Scanner(System.in);
        String ipAddress=sc.nextLine();
        calculatePingTime(ipAddress);
    }
    static void calculatePingTime(String ipAddress) throws UnknownHostException{
        InetAddress ip;
        ip = InetAddress.getByName(ipAddress);
        ArrayList<Double> time=new ArrayList<>();
        int t=1;
        while(t<=5) {
            double start = System.nanoTime();
            try {
                if (ip.isReachable(5000)) {
                    double finish = System.nanoTime();
                    System.out.println("Ping Time : " + (finish - start) + " nano seconds");
                    time.add(finish - start);
                    t++;
                } else {
                    System.out.println(ip + " NOT reachable.");
                    break;
                }
            } catch (UnknownHostException ex) {
                System.out.println("Host Not Present");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Median Time to Ping is "+Median(time));
    }
    public static double Median(ArrayList<Double> values) {
        Collections.sort(values);
        if (values.size() % 2 == 1)
            return values.get(((values.size() + 1) / 2) - 1);
        else {
            double lower = values.get((values.size() / 2) - 1);
            double upper = values.get(values.size() / 2);

            return (lower + upper) / 2;
        }
    }
}