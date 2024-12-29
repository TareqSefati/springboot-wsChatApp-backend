package com.tareq.websocket.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Tareq Sefati on 28-Dec-24
 */
@Slf4j
public class AppTools {
    public static String generateConversationHash(String id1, String id2){
        try {
            // Create an array of the strings
            String[] strings = {id1, id2};
            // Sort the array to ensure order does not matter
            Arrays.sort(strings);
            // Combine the sorted strings
            String combined = strings[0] + strings[1];
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Generate the hash
            byte[] hashBytes = digest.digest(combined.getBytes());
            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("Error while hashing! {}", e.getMessage());
            return null;
        }
    }
}
