package com.fifthgen.prahranvet.vetwarebridge.utility;

import com.fifthgen.prahranvet.vetwarebridge.Application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Logger;

/**
 * All of the network functionality is implemented in this class.
 */
public class ConnectionManager {

    private static final int TIMEOUT = 2000;

    /**
     * Check whether the application can connect to the remote host.
     *
     * @return True if can connect, else false.
     */
    public static boolean checkConnection() {
        String apiUrl = Application.propertyManager.getProperty(PropertyKey.API_URL.getKey());

        try {
            URL url = new URL(apiUrl);

            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(url.getHost(), 80), TIMEOUT);

                if (socket.isConnected()) {
                    return true;
                } else {
                    Logger.getGlobal().info("Cannot connect to the remote host.");
                    return false;
                }
            }
        } catch (IOException e) {
            Logger.getGlobal().severe("An error occurred while connecting to the remote host.");
        }

        return false;
    }
}
