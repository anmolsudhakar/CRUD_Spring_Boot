package in.stackroute.repository;
import in.stackroute.model.Reminder;

import java.util.List;

public interface ReminderRepository {
    List<Reminder> getAllReminders();
    Reminder getReminderById(int id);
    Reminder addReminder(Reminder reminder);
    void updateReminder(int id, Reminder updatedReminder);
    void deleteReminder(int id);
}