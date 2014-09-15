package com.uplink.mowitnow.utils;

import com.uplink.mowitnow.core.context.NotificationType;

/**
 * Created by walid.chergui@fullsix.com .
 */
public class NotificationUtil {

  public static String toJson(NotificationType notification, Object message) {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("{\"type\" : \"%s\",  %s}",
      notification.toString(), message.toString()));
    return sb.toString();
  }

}
