package com.larbotech.consumer.scc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;

@Profile("stub")
@EnableStubRunnerServer
@Configuration
public class StubConfiguration {

}
