module com.ssi.clean.example.spring {
	requires com.ssi.clean.example.config;
	requires com.ssi.clean.example.usecase;
	requires com.ssi.clean.example.controller;
	requires spring.web;
	requires spring.beans;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires com.fasterxml.jackson.databind;
	requires jackson.annotations;

	exports com.ssi.clean.example.spring;
	exports com.ssi.clean.example.spring.config;
	opens com.ssi.clean.example.spring.config to spring.core;
}
