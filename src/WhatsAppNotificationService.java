public class WhatsAppNotificationService implements NotificationService{
    @Override
    public void sendNotificationToParticipants(Meeting meeting) {

        System.out.println("whatsApp notification sent to participants for  " + meeting);

    }
}
