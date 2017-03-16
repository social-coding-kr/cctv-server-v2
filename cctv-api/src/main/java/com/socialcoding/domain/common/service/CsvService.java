package com.socialcoding.domain.common.service;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Service
public class CsvService {

	public <T> List<T> read(File file, Function<String[], T> lineMapper) {
		try(CSVReader reader = new CSVReader(new FileReader(file))) {
			return Flux.fromIterable(reader)
				.map(lineMapper)
				.collectList()
				.block();
		} catch (FileNotFoundException e) {
			log.error("File is not found", e);
			throw new RuntimeException("File is not found", e);
		} catch (Exception e) {
			log.error("Exception occurred", e);
			throw new RuntimeException("Exception occurred", e);
		}

	}

}
