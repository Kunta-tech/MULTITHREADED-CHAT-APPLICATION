# 💬 MULTITHREADED CHAT APPLICATION

*COMPANY* : CODTECH IT SOLUTIONS

*NAME* : SAUGATA KUNDU

*INTERN ID* : CT04DZ671

*DOMAIN* : JAVA PROGRAMMING

*DURATION* : 4 WEEKS

*MENTOR* : NEELA SANTHOSH

---

## 📋 Description

A real-time chat system built using **Spring Boot WebSockets** with support for **multithreading**, **multiple clients**, and **bidirectional communication** over STOMP and SockJS.

This project is a **functional chat application** where:

* A central Spring Boot server manages all WebSocket connections.
* Multiple clients can connect and exchange messages in real-time.
* Messages are instantly broadcast to all connected clients via WebSocket.

It uses:

* **STOMP over SockJS** for fallback and compatibility.
* A **simple in-memory broker** for lightweight, fast message delivery.
* **ThreadPoolTaskScheduler** for handling heartbeats and internal message dispatching concurrently.

---

## 🚀 Features

✅ Real-time messaging
✅ Multiclient communication
✅ WebSocket + STOMP protocol
✅ Multithreaded broker task execution
✅ Timestamped messages
✅ Heartbeat support to keep connections alive
✅ Frontend included (HTML + JS)

---

## 🏗️ Architecture

```
Client (Browser)
    |
    |  SockJS + STOMP
    v
Spring Boot WebSocket Server
    |
    |  Message Mapping
    v
Message Broker (/topic/messages)
    |
    |  Broadcast
    v
All Connected Clients
```

---

## 🧵 Multithreading and Heartbeat Support

The broker uses a custom **ThreadPoolTaskScheduler** for scheduling internal tasks and sending periodic heartbeats to all connected clients.

### Configuration

```java
@Bean
public ThreadPoolTaskScheduler messageBrokerTaskScheduler() {
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.setPoolSize(4);
    scheduler.setThreadNamePrefix("wss-heartbeat-");
    scheduler.initialize();
    return scheduler;
}

@Override
public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic")
            .setHeartbeatValue(new long[]{10000, 10000})
            .setTaskScheduler(messageBrokerTaskScheduler());
    registry.setApplicationDestinationPrefixes("/app");
}
```

### Why it matters

* ⚙️ Enables **multithreaded execution** of WebSocket events
* ❤️ Sends **heartbeats** to detect dead clients
* 🧼 Manages session cleanup tasks

---

## 🧪 Running the Application

### 🔧 Prerequisites

* Java 17+
* Maven

### ▶️ Run

```bash
mvn spring-boot:run
```

Then open:
📍 `http://localhost:8080/`

Open the same URL in **multiple tabs** or **browsers** to test real-time messaging.

---

## 🧪 Folder Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.codtech.chatapp/
│   │       ├── ChatAppApplication.java
│   │       ├── ChatController.java
│   │       ├── ChatMessage.java
│   │       └── WebSocketConfig.java
│   └── resources/
│       └── static/
│           └── index.html  <-- Web UI
```

---

## 🧑‍💻 Technologies Used

* Spring Boot
* Spring WebSocket
* STOMP Protocol
* SockJS
* JavaScript
* Maven

---

## 📄 License

MIT