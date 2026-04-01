import java.io.*; 
import java.net.*;
public class EchoServer {
public static void main(String[] args) { 
try {
ServerSocket server = new ServerSocket(5000) 
System.out.println("Server started... Waiting for client"); 
Socket socket = server.accept(); 
System.out.println("Client connected");
BufferedReader in = new BufferedReader(
new InputStreamReader(socket.getInputStream())); 
PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
String message;
while ((message = in.readLine()) != null) { 
System.out.println("Client: " + message); 
out.println("Echo: " + message); // send back same message
if (message.equalsIgnoreCase("exit")) { 
break;
}
}
socket.close(); 
server.close();
System.out.println("Server closed");
} catch (IOException e) { 
e.printStackTrace();
}
}
}
import java.io.*; 
import java.net.*; 
import java.util.*;
public class EchoClient {
public static void main(String[] args) { 
try {
Socket socket = new Socket("localhost", 5000);
BufferedReader in = new BufferedReader(
new InputStreamReader(socket.getInputStream())); 
PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
Scanner sc = new Scanner(System.in);
String message; 
while (true) {
System.out.print("Enter message: "); 
message = sc.nextLine(); 
out.println(message); // send to server 
String response = in.readLine(); 
System.out.println("Server: " + response);
if (message.equalsIgnoreCase("exit")) { 
break;
}
}
socket.close();
} catch (IOException e) { 
e.printStackTrace();
}
}
}
