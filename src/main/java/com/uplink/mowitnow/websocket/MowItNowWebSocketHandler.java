/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uplink.mowitnow.websocket;

import com.uplink.mowitnow.core.context.WebSocketMowItNowContext;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MowItNowWebSocketHandler extends TextWebSocketHandler {

    private static Logger logger = Logger.getLogger(MowItNowWebSocketHandler.class);

    WebSocketMowItNowContext mowItNowContext;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        logger.info("Connection is established :" + session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        logger.info("Get message :" + message.getPayload());
        mowItNowContext = new WebSocketMowItNowContext(message.getPayload() , session);
        mowItNowContext.parse();
        mowItNowContext.move();
        session.close();
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
			throws Exception {
	}
}
