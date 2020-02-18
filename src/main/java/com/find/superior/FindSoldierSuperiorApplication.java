package com.find.superior;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Streams;

@SpringBootApplication
public class FindSoldierSuperiorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FindSoldierSuperiorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int[] soldiers = {2,1,2,1,2,4,5};
		int count =0;
		List<Integer> integerList = new ArrayList<>();
		Arrays.stream(soldiers).forEach(soldier -> {integerList.add(Integer.valueOf(soldier));});
		
		Instant start = Instant.now() ;
		//method1
		for(int i=0;i<integerList.size();i++) {
			if(integerList.contains(integerList.get(i)+1)) {
				count++;
			}
		}
		Instant end = Instant.now() ;
		
		//method2
		Instant start1 = Instant.now() ;
		long count1 =integerList.stream().filter(x-> integerList.contains(x+1)).count();
		Instant end1 = Instant.now() ;
		System.out.println("count " +count +"Duration " +Duration.between(start, end));
		System.out.println("count1 " +count1+"Duration " +Duration.between(start1, end1) );
		//List<> listOfSoldiers = Arrays.asList(soldiers);
		
	}

}
