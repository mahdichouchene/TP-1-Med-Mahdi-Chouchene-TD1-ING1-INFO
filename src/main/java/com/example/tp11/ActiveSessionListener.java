package com.example.tp11;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {
    private static final AtomicInteger ACTIVE_SESSIONS = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        updateActiveSessions(event, 1);
        System.out.println("ActiveSessionListener: session created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        updateActiveSessions(event, -1);
        System.out.println("ActiveSessionListener: session destroyed.");
    }

    private static synchronized void updateActiveSessions(HttpSessionEvent event, int change) {
        int activeSessions = ACTIVE_SESSIONS.addAndGet(change);
        event.getSession().getServletContext().setAttribute("activeSessions", activeSessions);
    }
}
