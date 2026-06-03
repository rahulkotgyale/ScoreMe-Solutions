package com.scoreme.pipeline_scheduler;

import org.springframework.boot.SpringApplication;

public class TestPipelineSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.from(PipelineSchedulerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
