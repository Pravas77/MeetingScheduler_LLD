import java.time.LocalDateTime;
import java.util.List;

public class MeetingScheduler {
    private List<User> users;
    private List<MeetingRoom> meetingRooms;
    private List<NotificationService> notificationServices;

    public MeetingScheduler(List<User> users, List<MeetingRoom> meetingRooms, List<NotificationService> notificationServices) {
        this.users = users;
        this.meetingRooms = meetingRooms;
        this.notificationServices = notificationServices;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public List<NotificationService> getNotificationServices() {
        return notificationServices;
    }

    public Meeting scheduleMeeting(User organizer, List<User> atendee, LocalDateTime startTime, LocalDateTime endTime) {

        Meeting scheduledMeeting = null;
        for (MeetingRoom meetingRoom : meetingRooms){

            scheduledMeeting = meetingRoom.scheduleMeeting(organizer, atendee, startTime, endTime);
            if(scheduledMeeting != null) break;

        }

        if (scheduledMeeting == null) throw new RuntimeException("Unable to find meeting room for  " + startTime + "  " + endTime);
        for (NotificationService notificationService : notificationServices) notificationService.sendNotificationToParticipants(scheduledMeeting);
        return scheduledMeeting;
    }
}
