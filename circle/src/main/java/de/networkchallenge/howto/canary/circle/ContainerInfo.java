package de.networkchallenge.howto.canary.circle;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class ContainerInfo {
    public List<String> getInfo() {
        return Arrays.asList(getHost(), getVersion());
    }

    private String getHost() {
        String host = System.getenv("CONTAINER_HOST");
        if (host == null || host.isEmpty()) {
            try {
                host = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                host = "unknown";
            }
        }
        return "host: " + host;
    }

    private String getVersion() {
        String version = System.getenv("IMAGE_VERSION");
        return "version: " + (version != null ? version : "unknown");
    }
}
