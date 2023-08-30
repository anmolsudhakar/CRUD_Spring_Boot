package in.stackroute.repository;
import in.stackroute.model.Reminder;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ReminderRepositoryImpl implements ReminderRepository {
    public final List<Reminder> reminders ;


    public ReminderRepositoryImpl(){

        reminders = new ArrayList<>();
        reminders.add(new Reminder(1,
                "Remind me to schedule" +
                        " MCQ assessment for the batch #3",
                "2023/08/31",
                true));
    }
    @Override
    public List<Reminder> getAllReminders() {
        return reminders;
    }

    @Override
    public Reminder getReminderById(int id) {
        return reminders.stream()
                .filter(reminder -> reminder.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reminder addReminder(Reminder reminder) {
        reminders.add(reminder);
        return reminder;
    }

    @Override
    public void updateReminder(int id, Reminder updatedReminder) {
        for (int i = 0; i < reminders.size(); i++) {
            if (reminders.get(i).getId() == id) {
                reminders.set(i, updatedReminder);
                break;
            }
        }
    }

    @Override
    public void deleteReminder(int id) {
        reminders.removeIf(reminder -> reminder.getId() == id);
    }
}
