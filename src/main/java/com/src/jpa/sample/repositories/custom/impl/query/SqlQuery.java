package com.src.jpa.sample.repositories.custom.impl.query;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;

public class SqlQuery {

	private static final String SQL_QUERY_PATH = "sql\\%s.dat";

	public SqlQuery() { }

	public String getSql(String sqlQueryFile) throws IOException {
		String filePath = String.format(SQL_QUERY_PATH, sqlQueryFile);
		File file = new ClassPathResource(filePath).getFile();
		byte[] bytes = Files.readAllBytes(file.toPath());
		return new String(bytes, StandardCharsets.UTF_8);
	}
}
