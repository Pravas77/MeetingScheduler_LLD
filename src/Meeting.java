import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private  User organizer;
    private List<User> atendee;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MeetingRoom meetingRoom;

    public Meeting(User organizer, List<User> atendee, LocalDateTime startTime, LocalDateTime endTime, MeetingRoom meetingRoom) {
        this.organizer = organizer;
        this.atendee = atendee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingRoom = meetingRoom;
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getAtendee() {
        return atendee;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "organizer=" + organizer +
                ", atendee=" + atendee +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", meetingRoom=" + meetingRoom +
                '}';
    }
}
