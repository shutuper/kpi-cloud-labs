package org.example.demo.controller;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.demo.repo.entity.DemoEntity;
import org.example.demo.repo.AppDemoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class DemoController {

	final AppDemoRepository appDemoRepository;

	@PostConstruct
	public void init() {
		Random random = new Random();
		List<DemoEntity> collect = IntStream.range(0, 10)
				.mapToObj(i -> DemoEntity.builder()
						.message("Message number: " + random.nextInt(100_000))
						.build())
				.collect(Collectors.toList());
		appDemoRepository.saveAll(collect);
	}

	@GetMapping("/")
	public String index() throws UnknownHostException {
		return "Hello from Spring Boot Demo app! IP: " + InetAddress.getLocalHost();
	}

	@GetMapping("/messages")
	public List<String> getMessages() {
		return appDemoRepository.findAll().stream().map(DemoEntity::getMessage).limit(10).collect(Collectors.toList());
	}

}
