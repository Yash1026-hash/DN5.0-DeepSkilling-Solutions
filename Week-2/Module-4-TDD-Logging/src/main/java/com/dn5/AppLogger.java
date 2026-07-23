package com.dn5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {

    private static final Logger logger = LoggerFactory.getLogger(AppLogger.class);

    public void processOrder(int orderId) {
        logger.info("Processing order with id: {}", orderId);

        if (orderId <= 0) {
            logger.warn("Invalid order id: {}", orderId);
            return;
        }

        try {
            logger.debug("Fetching order details for id: {}", orderId);
            System.out.println("Order " + orderId + " processed successfully");
            logger.info("Order {} processed successfully", orderId);
        } catch (Exception e) {
            logger.error("Error processing order {}: {}", orderId, e.getMessage());
        }
    }

    public static void main(String[] args) {
        AppLogger app = new AppLogger();
        app.processOrder(101);
        app.processOrder(-1);
        app.processOrder(202);
    }
}
