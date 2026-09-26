import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MeetingRoom {
    private int id;
    private List<Meeting> meetings;
    private int capacity;
    private ReentrantLock lock;

    public MeetingRoom(int id, int capacity) {
        this.id = id;
        this.meetings = new ArrayList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
    }

    public int getId() {
        return id;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "MeetingRoom" + id;
    }

    public Meeting scheduleMeeting(User organizer, List<User> atendee, LocalDateTime startTime, LocalDateTime endTime) {

        if (atendee.size() > this.capacity) return null;

        lock.lock();
        try {


            long startTimeEpoch = startTime.toEpochSecond(ZoneOffset.UTC);
            long endTimeEpoch = endTime.toEpochSecond(ZoneOffset.UTC);
            long prevEndTimeEpoch = -1;
            int meetingIndex = -1;


            for (int i = 0; i < meetings.size(); i++) {

                Meeting meeting = meetings.get(i);
                long nextStartTimeEpoch = meeting.getStartTime().toEpochSecond(ZoneOffset.UTC);
                if (prevEndTimeEpoch <= startTimeEpoch && endTimeEpoch <= nextStartTimeEpoch) {
                    meetingIndex = i;
                    break;
                } else prevEndTimeEpoch = meeting.getEndTime().toEpochSecond(ZoneOffset.UTC);

            }


            if (meetingIndex == -1 && prevEndTimeEpoch <= startTimeEpoch) {
                meetingIndex = meetings.size();
            }


            if (meetingIndex == -1) return null;
            Meeting scheduledMeeting = new Meeting(organizer, atendee, startTime, endTime, this);
            meetings.add(meetingIndex, scheduledMeeting);
            return scheduledMeeting;
        } finally {
            lock.unlock();
        }
    }
}
