package com.example.springintroduction;

import com.example.springintroduction.dao.impl.EventDAO;
import com.example.springintroduction.dao.impl.TicketDAO;
import com.example.springintroduction.dao.impl.UserAccountDAO;
import com.example.springintroduction.dao.impl.UserDAO;
import com.example.springintroduction.facade.BookingFacade;
import com.example.springintroduction.model.Event;
import com.example.springintroduction.model.Ticket;
import com.example.springintroduction.model.impl.EventImpl;
import com.example.springintroduction.model.impl.UserImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

//@SpringBootTest
class SpringIntroductionApplicationTests {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private TicketDAO ticketDAO;
	@Autowired
	private UserAccountDAO userAccountDAO;
	@Autowired
	private BookingFacade bookingFacade;

	private EmbeddedDatabase embeddedDatabase;



}