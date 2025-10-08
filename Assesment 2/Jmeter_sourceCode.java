package quarkifi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Jmeter {
	 public static void main(String[] args) throws Exception {
	        sendhits("https://the-internet.herokuapp.com", 5000, 2);    // 5k hits in 2 sec
	        sendhits("https://the-internet.herokuapp.com", 50000, 10);  // 50k hits in 10 sec
	    }

	    static void sendhits(String url, int hits, int seconds) throws InterruptedException {
	        ExecutorService executor = Executors.newFixedThreadPool(1000);//it allow many req rather one thread per req
	        for (int i = 1; i <=hits; i++) {
	            executor.submit(() -> {   //it define each thread process
	                try {
	                    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
	                    con.setRequestMethod("GET");
	                    con.getResponseCode();
	                    con.disconnect();
	                } catch (Exception ignore) {}
	            });
	        }
	        executor.shutdown();
	        executor.awaitTermination(seconds, TimeUnit.SECONDS);//wait till task to complete
	        System.out.println("Sent " + hits + " hits in " + seconds + " seconds");
	    }
	

}
