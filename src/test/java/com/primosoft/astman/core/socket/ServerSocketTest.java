package com.primosoft.astman.core.socket;

import com.primosoft.astman.core.ast.socket.SocketMechanismFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created on 10.09.16.
 *
 * @author atelizhenko
 */
@ActiveProfiles("test")
@ContextConfiguration("classpath:config/spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServerSocketTest {
	@Autowired
	private SocketMechanismFactory socketMechanismFactory;

	@Test
	public void testServerSocket() throws InterruptedException {
		// TODO: 10.09.16 uncomment to test sockets
//		socketMechanismFactory.runServerSocketMechanism();
//		while (true) {
//			synchronized (this) {
//				wait();
//			}
//		}
	}
}
