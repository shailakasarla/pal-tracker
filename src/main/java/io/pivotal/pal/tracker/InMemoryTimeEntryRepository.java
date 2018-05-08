package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    public InMemoryTimeEntryRepository() {
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        Long id = timeEntries.size() + 1L;

        TimeEntry tempTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.put(id, tempTimeEntry);

        return tempTimeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry>timeEntryList = new ArrayList<TimeEntry>(timeEntries.values());
        return timeEntryList;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        timeEntry.setId(id);
        timeEntries.put(id, timeEntry);

        return timeEntry;
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }
}
