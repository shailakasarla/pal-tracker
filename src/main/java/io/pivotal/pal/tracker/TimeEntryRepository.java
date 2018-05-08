package io.pivotal.pal.tracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository{

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(long id);

    public List<TimeEntry> list();

    public TimeEntry update(long id, TimeEntry timeEntry);

    public void delete(long id);
}
