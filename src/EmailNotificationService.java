public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotificationToParticipants(Meeting meeting) {

        System.out.println("Email notification sent to participants for  " + meeting);

    }
}
