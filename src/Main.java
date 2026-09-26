import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");

        User user1 = new User(1,"1@gmail.com","+91-1");
        User user2 = new User(2,"2@gmail.com","+91-2");
        User user3 = new User(3,"3@gmail.com","+91-3");

        MeetingRoom meetingRoom1 = new MeetingRoom(1,4);
        MeetingRoom meetingRoom2 = new MeetingRoom(2,2);

        MeetingScheduler meetingScheduler = new MeetingScheduler(
                List.of(user1,user2,user3),
                List.of(meetingRoom1,meetingRoom2),
                List.of(new EmailNotificationService(),new WhatsAppNotificationService())
        );


        Thread thread1 = new Thread(() -> {
            meetingScheduler.scheduleMeeting(
                    user1,
                    List.of(user1,user2,user3),
                    LocalDateTime.of(2026,1,1,8,0,0),
                    LocalDateTime.of(2026,1,1,10,0,0));
        });

        Thread thread2 = new Thread(() -> {
            meetingScheduler.scheduleMeeting(
                    user1,
                    List.of(user1,user2,user3),
                    LocalDateTime.of(2026,1,1,9,30,0),
                    LocalDateTime.of(2026,1,1,10,30,0));
        });


        thread1.start();
        thread2.start();




    }
}