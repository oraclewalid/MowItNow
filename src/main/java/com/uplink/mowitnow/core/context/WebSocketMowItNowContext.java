package com.uplink.mowitnow.core.context;

import com.uplink.mowitnow.core.domain.Instruction;
import com.uplink.mowitnow.core.domain.LawnMower;
import com.uplink.mowitnow.utils.NotificationUtil;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by walid on 13/09/14.
 */
public class WebSocketMowItNowContext extends AbstractMowItNowContext {

    private WebSocketSession webSocketSession;

    public WebSocketMowItNowContext(String commands, WebSocketSession webSocketSession) throws IOException {
        super(commands);
        this.webSocketSession = webSocketSession;
    }

    @Override
    public void notify(NotificationType notificationType, String message) {
        try {
            String notificationText = NotificationUtil.toJson(notificationType, message);
            webSocketSession.sendMessage(new TextMessage(notificationText));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void move() {
        getListLawnMowerWithInstruction().stream()
                .forEach(paire -> paire.getLeftElement()
                .stream().forEach(instruction -> {
                            try {
                                instruction.move(paire.getRightElement());
                                Thread.sleep(1000);
                                isInTheArea(paire.getRightElement().getPosition());
                                notify(NotificationType.UPDATE, paire.getRightElement().toString());
                            } catch (Exception e) {
                                notify(NotificationType.ERROR , paire.getRightElement().toString());
                            }
                        }));
    }
}
