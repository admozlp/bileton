package com.ademozalp.bileton.util;

import java.net.Inet6Address;
import java.net.InetAddress;

public class LoginUtil {
    private LoginUtil() {
    }


    public static String convertIPv6ToIPv4(String ipv6Address) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipv6Address);
            if (inetAddress instanceof Inet6Address) {
                byte[] ipv4Bytes = new byte[4];
                System.arraycopy(inetAddress.getAddress(), 12, ipv4Bytes, 0, 4);
                return InetAddress.getByAddress(ipv4Bytes).getHostAddress();
            } else {
                return inetAddress.getHostAddress();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("IP adresi çözümlenemedi: " + ipv6Address, e);
        }
    }
}
