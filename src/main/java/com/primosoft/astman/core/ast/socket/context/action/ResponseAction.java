/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.socket.context.action;

import com.primosoft.astman.core.command.Command;
import com.primosoft.astman.core.util.BlockHelper;

import java.net.SocketAddress;

/**
 * Created on 17.08.16.
 *
 * @author atelizhenko
 */
interface ResponseAction extends Command<String> {

	void setBlockHelper(BlockHelper blockHelper);

	void setSocketAddress(SocketAddress socketAddress);

	boolean stayConnection();
}
