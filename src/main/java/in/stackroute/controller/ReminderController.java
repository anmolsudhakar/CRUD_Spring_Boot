package in.stackroute.controller;
import in.stackroute.model.Reminder;
import in.stackroute.repository.ReminderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ReminderController {

    @Autowired
    private ReminderRepository reminderRepository;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome !";
    }


    @GetMapping("/reminders")
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = reminderRepository.getAllReminders();
        return new ResponseEntity<>(reminders, HttpStatus.OK);
    }

    @PostMapping("/reminders")
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
            TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(istTimeZone);

            Date currentTime = new Date();
            String istDate = sdf.format(currentTime);

            reminder.setDate(istDate);
            Reminder createdReminder = reminderRepository.addReminder(reminder);
            return new ResponseEntity<>(createdReminder, HttpStatus.CREATED);
        }


    @PutMapping("/reminders/{id}")
    public ResponseEntity<Void> updateReminder(@PathVariable int id, @RequestBody Reminder updatedReminder) {
        Reminder existingReminder = reminderRepository.getReminderById(id);
        if (existingReminder != null) {
            reminderRepository.updateReminder(id, updatedReminder);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reminders/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable int id) {
        Reminder existingReminder = reminderRepository.getReminderById(id);
        if (existingReminder != null) {
            reminderRepository.deleteReminder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}