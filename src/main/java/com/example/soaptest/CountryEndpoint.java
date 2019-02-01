package com.example.soaptest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.xyz.guides.blah.Country;
import io.xyz.guides.blah.Currency;
import io.xyz.guides.blah.GetCountryRequest;
import io.xyz.guides.blah.GetCountryResponse;


@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://xyz.io/guides/blah";

	private CountryRepository countryRepository;

	
	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountryzz(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		Country c = new Country();
		c.setCapital("Delhi");
		c.setCurrency(Currency.EUR);
		c.setPopulation(100000000);
		c.setName("India");
		response.setCountry(c);
		return response;
	}

}